package QuickTickets.Management.Movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import QuickTickets.Management.EnumConfiguration.MovieStatus;

@RestController
public class MovieController {
	
	@Autowired
	private MovieServiceLayer movieService ;
	
	@GetMapping("/api/movies")
	public List<MovieDTO> getAllMovies(){
		return movieService.getAllMovies();
	}
	
	@GetMapping("/api/movies/byId")
	public MovieDTO getById(@RequestParam int id) {
		return movieService.getMovieById(id);
	}
	
	@GetMapping("/api/movies/available")
	public List<MovieDTO> getAvailableMovie(@RequestParam MovieStatus movieStatus){
		return movieService.getAvailableMovie(movieStatus);
	}
	
	@GetMapping("/api/movies/name")
	public List<MovieDTO> getMovieByName(@RequestParam String movieName){
		return movieService.getMovieByName(movieName);
	}
	
	@PostMapping("/api/movies")
	public MovieDTO addMovieApi(@RequestBody MovieDTO movie) {
		return movieService.addMovie(movie);
	}
	
	@PutMapping("/api/movies")
	public MovieDTO updateById(@RequestParam int id,@RequestBody MovieDTO movie) {
		return movieService.updateMovieById(id,movie);
	}
	
	@DeleteMapping("/api/movies")
	public String deleteById(@RequestParam int id) {
		return movieService.deleteMovieById(id);
	}
	

}
