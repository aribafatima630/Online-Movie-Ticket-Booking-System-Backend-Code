package QuickTickets.Management.Shows;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowsRepository extends JpaRepository<Shows,Integer>{
	
	Shows findByScreensScreenId(int screenId);
	
	//List<Shows> findByMovies_movieId(int movieId);

}
