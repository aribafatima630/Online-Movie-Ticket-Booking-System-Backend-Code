package QuickTickets.Management.Movie;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import QuickTickets.Management.EnumConfiguration.MovieStatus;

public interface MovieRepository extends JpaRepository<Movies, Integer> {
	
	List<Movies> findByMovieStatus(MovieStatus movieStatus);
	
	List<Movies> findBymovieName(String movieName);
	
	boolean existsBymovieName(String movieName);
	
	@Query("SELECT m FROM Movies m LEFT JOIN FETCH m.cast WHERE m.movieId = :id")
	Optional<Movies> findByIdWithCast(@Param("id") int id);

}
