package QuickTickets.Management.Shows;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QuickTickets.Management.Movie.MovieDTO;
import QuickTickets.Management.Movie.MovieRepository;
import QuickTickets.Management.Movie.MovieServiceLayer;
import QuickTickets.Management.Movie.Movies;
import QuickTickets.Management.Screens.ScreenDTO;
import QuickTickets.Management.Screens.ScreenServiceLayer;
import QuickTickets.Management.Screens.Screens;
import QuickTickets.Management.Screens.ScreensRepository;
import QuickTickets.Management.TimeSlot.TimeSlot;
import QuickTickets.Management.TimeSlot.TimeSlotDTO;
import jakarta.transaction.Transactional;

@Service
public class ShowsServiceLayer {

    @Autowired
    private ShowsRepository showsRepository;

    @Autowired
    private ScreensRepository screenRepository;
    
    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private MovieServiceLayer movieLayer;
    
    @Autowired
    private ScreenServiceLayer screenLayer;

    // ====== Public Methods (Using DTOs) ======

    public List<ShowDTO> getAllShow() {
        List<Shows> shows = showsRepository.findAll();
        return shows.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ShowDTO getShowById(int showId) {
        Shows show = showsRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found with this ID: " + showId));
        return convertToDTO(show);
    }

    public ShowDTO addShow(int screenId, ShowDTO showDTO) {
        Shows show = convertToEntity(showDTO);

        Screens screen = screenRepository.findById(screenId)
                .orElseThrow(() -> new RuntimeException("Screen not found with this ID: " + screenId));
        show.setScreens(screen);

        if (show.getTime_slot() != null) {
            show.getTime_slot().forEach(slot -> slot.setShows(show));
        }

        Shows savedShow = showsRepository.save(show);
        return convertToDTO(savedShow);
    }

    public String deleteShow(int showId) {
        Shows show = showsRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found with this ID: " + showId));
        showsRepository.delete(show);
        return "Deleted Successfully";
    }
    
    public ShowDTO updateShow(int showId, ShowDTO showDTO) {
        Shows existingShow = showsRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found with ID: " + showId));

        // Update Movie
        Movies movie = movieRepository.findById(showDTO.getMovie().getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found with ID: " + showDTO.getMovie().getMovieId()));
        existingShow.setMovie(movie);

        // Update Screen
        Screens screen = screenRepository.findById(showDTO.getScreen().getScreenId())
                .orElseThrow(() -> new RuntimeException("Screen not found with ID: " + showDTO.getScreen().getScreenId()));
        existingShow.setScreens(screen);

        // Clear existing time slots and update with new ones
        List<TimeSlot> updatedSlots = showDTO.getTimeSlot().stream()
                .map(dto -> convertDTOToTimeSlot(dto, existingShow))
                .collect(Collectors.toList());

        existingShow.getTime_slot().clear();
        existingShow.getTime_slot().addAll(updatedSlots);

        // Save updated show
        Shows updatedShow = showsRepository.save(existingShow);

        // Convert and return as DTO
        return convertToDTO(updatedShow);
    }

    //  Helper Methods: Entity to DTO Conversion 

    @Transactional
    private ShowDTO convertToDTO(Shows show) {
        // Refetch show with time slots
        Shows showWithTimeSlots = showsRepository.findByIdWithTimeSlots(show.getShowId())
            .orElseThrow(() -> new RuntimeException("Show not found"));

        // Fetch MovieDTO with cast using your custom method
        Movies movieWithCast = movieRepository.findByIdWithCast(show.getMovie().getMovieId())
            .orElseThrow(() -> new RuntimeException("Movie not found"));
        MovieDTO movieDTO = movieLayer.convertToDTO(movieWithCast);

        // Convert Screen
        ScreenDTO screenDTO = screenLayer.convertToDTO(show.getScreens());

        // Convert TimeSlot list
        List<TimeSlotDTO> timeSlotDTOs = showWithTimeSlots.getTime_slot().stream()
            .map(slot -> new TimeSlotDTO(
                slot.getTime_slot_id(),
                slot.getStartTime(),
                slot.getEndTime(),
                0
            ))
            .collect(Collectors.toList());

        return new ShowDTO(show.getShowId(), movieDTO, screenDTO, timeSlotDTOs);
    }

    private Shows convertToEntity(ShowDTO dto) {
        Shows show = new Shows();
        show.setShowId(dto.getShowId());
        show.setMovie(movieLayer.convertToEntity(dto.getMovie()));
        show.setScreens(screenLayer.convertToEntity(dto.getScreen()));

        if (dto.getTimeSlot() != null) {
            List<TimeSlot> timeSlots = dto.getTimeSlot().stream().map(slotDTO -> {
                TimeSlot slot = new TimeSlot();
                slot.setTime_slot_id(slotDTO.getTimeSlotId());
                slot.setStartTime(slotDTO.getStartTime());
                slot.setEndTime(slotDTO.getEndTime());
                slot.setShows(show);
                return slot;
            }).collect(Collectors.toList());

            show.setTime_slot(timeSlots);
        }

        return show;
    }
    
    private TimeSlot convertDTOToTimeSlot(TimeSlotDTO dto, Shows show) {
        TimeSlot timeSlot = new TimeSlot();
        timeSlot.setTime_slot_id(dto.getTimeSlotId());
        timeSlot.setStartTime(dto.getStartTime());
        timeSlot.setEndTime(dto.getEndTime());
        timeSlot.setShows(show); // assign parent
        return timeSlot;
    }

}
