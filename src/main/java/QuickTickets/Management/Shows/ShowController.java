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
	public List<ShowDTO> getAllShows(){
		return showsService.getAllShow();
	}
	
	@GetMapping("/api/shows/byId")
	public ShowDTO getShowById(@RequestParam int showId) {
		return showsService.getShowById(showId);
	}
	
	@PostMapping("/api/shows")
	public ShowDTO addShow(@RequestParam int screenId, @RequestBody ShowDTO show) {
		return showsService.addShow(screenId,show);
	}
	
	@PutMapping("/api/shows")
	public ShowDTO updateShow(@RequestParam int id,@RequestBody ShowDTO updatedShow) {
		return showsService.updateShow(id, updatedShow);
	}
	
	@DeleteMapping("/api/shows")
	public String deleteShow(@RequestParam int showId) {
		return showsService.deleteShow(showId);
	}
	
//	@GetMapping("/api/shows/byScreenId")
//	public Shows getShowByScreenId(@RequestParam int screenId) {
//		return showsService.getShowByScreenId(screenId);
//	}

}
