package QuickTickets.Management.Screens;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QuickTickets.Management.Theaters.TheaterRepository;
import QuickTickets.Management.Theaters.Theaters;

@Service
public class ScreenServiceLayer {

    @Autowired
    private ScreensRepository screenRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    // Convert Screen entity to DTO
    public ScreenDTO convertToDTO(Screens screen) {
        ScreenDTO dto = new ScreenDTO();
        dto.setScreenId(screen.getScreenId());
        dto.setScreenName(screen.getScreenName());
        dto.setTotalSeat(screen.getTotalSeat());
        dto.setTheaterId(screen.getTheater().getTheaterId());
        dto.setTheaterName(screen.getTheater().getTheaterName());
        return dto;
    }

    // Convert DTO to Screen entity
    public Screens convertToEntity(ScreenDTO dto) {
        Screens screen = new Screens();
        screen.setScreenId(dto.getScreenId());
        screen.setScreenName(dto.getScreenName());
        screen.setTotalSeat(dto.getTotalSeat());

        Theaters theater = theaterRepository.findById(dto.getTheaterId())
            .orElseThrow(() -> new RuntimeException("Theater not found"));
        screen.setTheater(theater);

        return screen;
    }

    public List<ScreenDTO> getAllScreens() {
        return screenRepository.findAll()
            .stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }
    
    public ScreenDTO getScreenById(int screenId) {
    	Screens screen = screenRepository.findById(screenId)
    									.orElseThrow(()-> new RuntimeException("Screen Not Found"));
    	return convertToDTO(screen);
    }

    public List<ScreenDTO> getScreenByTheaterId(int theaterId) {
        return screenRepository.findByTheatersTheaterId(theaterId)
            .stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public ScreenDTO addScreenByTheaterId(int theaterId, ScreenDTO screenDTO) {
        screenDTO.setTheaterId(theaterId);
        Screens savedScreen = screenRepository.save(convertToEntity(screenDTO));
        return convertToDTO(savedScreen);
    }
}
