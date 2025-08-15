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
	
	@GetMapping("/api/shows/ByScreenIdt")
	public ShowDTO getShowByScreenId(@RequestParam int screenId) {
		return showsService.getShowByScreenId(screenId);
	}
	
	@PostMapping("/api/shows")
	public ShowDTO addShow(@RequestBody ShowDTO show) {
		return showsService.addShow(show);
	}
	

}
