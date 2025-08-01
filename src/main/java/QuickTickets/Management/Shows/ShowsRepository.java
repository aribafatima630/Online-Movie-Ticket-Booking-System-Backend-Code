package QuickTickets.Management.Shows;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShowsRepository extends JpaRepository<Shows,Integer>{
	
	Shows findByScreensScreenId(int screenId);
	
	@Query("SELECT s FROM Shows s LEFT JOIN FETCH s.time_slot WHERE s.showId = :id")
	Optional<Shows> findByIdWithTimeSlots(@Param("id") int id);
	
	//List<Shows> findByMovies_movieId(int movieId);

}
