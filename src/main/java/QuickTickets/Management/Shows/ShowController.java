package QuickTickets.Management.Shows;

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
public class ShowController {
	
	@Autowired
	private ShowsServiceLayer showsService;
	
	@GetMapping("/api/shows")
	public List<Shows> getAllShows(){
		return showsService.getAllShows();
	}
	
	@GetMapping("/api/shows/byId")
	public Shows getShowById(@RequestParam int id) {
		return showsService.getShowById(id);
	}
	
	@PostMapping("/api/shows")
	public Shows addShow(@RequestParam int screenId, @RequestBody Shows show) {
		return showsService.addShow(screenId,show);
	}
	
	@PutMapping("/api/shows")
	public Shows updateShow(@RequestParam int id,@RequestBody Shows updatedShow) {
		return showsService.updateShow(id, updatedShow);
	}
	
	@DeleteMapping("/api/shows")
	public String deleteShow(@RequestParam int id) {
		return showsService.deleteShow(id);
	}
	
	@GetMapping("/api/shows/byScreenId")
	public Shows getShowByScreenId(@RequestParam int screenId) {
		return showsService.getShowByScreenId(screenId);
	}

}
