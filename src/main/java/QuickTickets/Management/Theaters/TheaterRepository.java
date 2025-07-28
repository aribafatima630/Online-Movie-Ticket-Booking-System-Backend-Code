package QuickTickets.Management.Theaters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theaters,Integer>{
	
	 List<Theaters> findByAddress_addressIdIn(List<Integer> addressId);
	 Theaters findByemail(String email);
	 
	// Theaters findByScreen_screenId(int screenId);
	 
}
