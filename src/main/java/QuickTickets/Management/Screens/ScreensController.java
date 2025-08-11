package QuickTickets.Management.Screens;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScreensController {

	@Autowired
	private ScreenServiceLayer screenService;
	
	@GetMapping("/api/screens")
	public List<ScreenDTO> getAllScreens(){
		
		return screenService.getAllScreens();
		
	}
	
	@GetMapping("/api/screensById")
	public ScreenDTO getScreenById(@RequestParam int screenId) {
		return screenService.getScreenById(screenId);
	}
	
	@GetMapping("/api/theaters/screens")
	public List<ScreenDTO> getScreensByTheaterId(@RequestParam int theaterId){
		
		return screenService.getScreenByTheaterId(theaterId);
		
	}
	
	@PostMapping("/api/theaters/screens")
	public ScreenDTO addScreenByTheaterId(@RequestParam int id, @RequestBody ScreenDTO screen) {
		
		return screenService.addScreenByTheaterId(id, screen);
		
	}
	
}
