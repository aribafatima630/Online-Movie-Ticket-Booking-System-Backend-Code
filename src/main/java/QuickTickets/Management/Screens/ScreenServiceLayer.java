package QuickTickets.Management.Screens;

import java.util.List;

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
	
	public List<Screens> getAllScreens(){
		return screenRepository.findAll();
	}
	
	public List<Screens> getScreenByTheaterId(int theaterId){
		return screenRepository.findByTheatersTheaterId(theaterId);
	}
	
	public Screens addScreenByTheaterId(int id, Screens screen) {
		
		Theaters theater = theaterRepository.findById(id)
				.orElseThrow(()->new RuntimeException("Theater Not Found"));
		
		screen.setTheater(theater);
		
		return screenRepository.save(screen);
	}

}
