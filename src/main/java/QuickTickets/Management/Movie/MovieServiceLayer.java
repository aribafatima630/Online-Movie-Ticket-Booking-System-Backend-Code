package QuickTickets.Management.Movie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QuickTickets.Management.EnumConfiguration.MovieStatus;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class MovieServiceLayer {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private castRepository castRepo;
	
	public MovieServiceLayer(MovieRepository movieRepository) {
		this.movieRepository=movieRepository;
	}
	
	public List<Movies> getAllMovies(){
		return movieRepository.findAll();
	}
	
	public Movies getMovieById(int MovieId) {
		return movieRepository.findById(MovieId).orElse(null);
	}
	
	public Movies addMovie(Movies movie) {
		
		if (movie.getCast() != null) {
	        for (Cast castMember : movie.getCast()) {
	            castMember.setMovie(movie);
	        }
	    }
		
		return movieRepository.save(movie);
	}
	
	@Transactional
	public Movies updateMovieById(int id,Movies updatedMovie) {
		Movies movie = movieRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Movie not found"));
		
			movie.setMovieStatus(updatedMovie.getMovieStatus());
			movie.setMovieType(updatedMovie.getMovieType());
			movie.setDescription(updatedMovie.getDescription());
			movie.setPrice(updatedMovie.getPrice());
			movie.setImage(updatedMovie.getImage());
			movie.setBannerImage(updatedMovie.getBannerImage());
			movie.setRating(updatedMovie.getRating());
			movie.setDuration(updatedMovie.getDuration());
			
			if(updatedMovie.getCast()!=null) {
				
				List<Cast> castArray = new ArrayList<>();
				
				for(Cast cast: updatedMovie.getCast()) {
					Cast existingCast = castRepo.findById(cast.getCastId())
										.orElseThrow(()-> new RuntimeException("Cast Not Found"));
					
					existingCast.setMovie(movie); 
					castArray.add(existingCast);
				}
				
				movie.setCast(castArray);
				
			}
			
			return movieRepository.save(movie);
		
	}
	
	public String deleteMovieById(int id) {
		if (!movieRepository.existsById(id)) {
	        throw new RuntimeException("Movie not found with ID: " + id);
	    }
	    movieRepository.deleteById(id);
	    return "Deleted Successfully Movie of Id:" + id;
	}
	
	public List<Movies> getAvailableMovie(MovieStatus movieStatus){
		return movieRepository.findByMovieStatus(movieStatus);
	}
	
	public boolean checkMovieByName(String movieName) {
		return movieRepository.existsBymovieName(movieName);
	}
	
	public List<Movies> getMovieByName(String movieName) {
		return movieRepository.findBymovieName(movieName);
	}
	
}
