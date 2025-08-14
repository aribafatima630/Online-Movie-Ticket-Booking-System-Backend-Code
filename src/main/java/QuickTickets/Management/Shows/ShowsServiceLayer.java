package QuickTickets.Management.Shows;

import java.util.ArrayList;
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
	private MovieRepository movieRepository;
	
	@Autowired
	private ScreensRepository screenRepository;
	
	@Autowired
	private ShowsRepository showRepository;
	
	///helper Methods
	
	public ShowDTO convertToDto(Shows show) {
		ShowDTO dto = new ShowDTO();
		
		dto.setShowId(show.getShowId());
		dto.setMovieId(show.getMovie().getMovieId());
		dto.setScreenId(show.getScreens().getScreenId());
		if(show.getTime_slot() != null) {
			dto.setTimeSlot(new ArrayList<>(show.getTime_slot()));
		}else {
			throw new RuntimeException("Time Slot Required");
		}
		
		return dto;
	}
	
	public Shows convertToEntity(ShowDTO dto) {
		Shows show = new Shows();
		
		show.setShowId(dto.getShowId());
		
		Movies movie = movieRepository.findById(dto.getMovieId()).orElse(null);
		show.setMovie(movie);
		
		Screens screen = screenRepository.findById(dto.getScreenId()).orElse(null);
		show.setScreens(screen);
		
		show.setTime_slot(dto.getTimeSlot());
		
		return show;
		
	}
	
	@Transactional
	public List<ShowDTO> getAllShow(){
		List<Shows> shows = showRepository.findAll();
		List<ShowDTO> showDTOs = new ArrayList<>();
		for(Shows show : shows) {
			showDTOs.add(convertToDto(show));
		}
		return showDTOs;
	}
	
	@Transactional
	public ShowDTO getShowByScreenId(int screenId) {
		Shows show = showRepository.findByScreensScreenId(screenId);
		if (show == null) {
	        throw new RuntimeException("Show not found for screenId: " + screenId);
	    }
		return convertToDto(show);
	}
	
	public ShowDTO addShow(ShowDTO dto) {
		Movies movie = movieRepository.findById(dto.getMovieId())
					  				  .orElseThrow(() -> new RuntimeException ("Movie Not Found"));
		
		Screens screen = screenRepository.findById(dto.getScreenId())
										 .orElseThrow(()-> new RuntimeException("Screen Not found"));
		
		Shows show = new Shows();
		show.setMovie(movie);
		show.setScreens(screen);
		if (dto.getTimeSlot() != null) {
	        for (TimeSlot ts : dto.getTimeSlot()) {
	            ts.setShows(show);
	        }
	        show.setTime_slot(dto.getTimeSlot());
	    }

		
		Shows saved = showRepository.save(show);
		return convertToDto(saved);
		
	}


}
