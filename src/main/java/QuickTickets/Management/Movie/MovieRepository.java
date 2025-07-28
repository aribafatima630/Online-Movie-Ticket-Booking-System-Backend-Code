package QuickTickets.Management.Movie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import QuickTickets.Management.EnumConfiguration.MovieStatus;

public interface MovieRepository extends JpaRepository<Movies, Integer> {
	
	List<Movies> findByMovieStatus(MovieStatus movieStatus);
	
	List<Movies> findBymovieName(String movieName);
	
	boolean existsBymovieName(String movieName);

}
