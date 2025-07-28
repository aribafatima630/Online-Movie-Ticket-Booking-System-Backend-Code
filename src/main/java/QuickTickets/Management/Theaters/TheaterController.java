package QuickTickets.Management.Theaters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheaterController {
	
	@Autowired
	private TheaterServiceLayer theaterService;
	
	@GetMapping("/api/theaters")
	public List<Theaters> getAllTheaters(){
		return theaterService.getAllTheaters();
	}
	
	@GetMapping("/api/theaters/byLocation")
	public List<Theaters> getAllTheatersByCity(@RequestParam String city){
		return theaterService.getAllTheatersByCity(city);
	}
	
	@PostMapping("/api/theaters")
	public Theaters addTheater(@RequestBody Theaters theater) {
		return theaterService.addTheater(theater);
	}
	
	@PutMapping("/api/theaters")
	public Theaters putTheater(@RequestParam int id, @RequestBody Theaters theater) {
		
		return theaterService.putTheater(id, theater);
		
	}
	
	@DeleteMapping("/api/theaters")
	public String deleteTheater(@RequestParam int id) {
		return theaterService.deleteTheater(id);
	}

}
