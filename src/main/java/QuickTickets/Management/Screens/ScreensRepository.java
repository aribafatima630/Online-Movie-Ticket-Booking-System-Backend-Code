package QuickTickets.Management.Screens;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreensRepository extends JpaRepository<Screens,Integer>{
	
	List<Screens> findByTheatersTheaterId(int theaterId);
	
}
