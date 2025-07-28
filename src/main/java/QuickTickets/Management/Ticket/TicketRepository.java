package QuickTickets.Management.Ticket;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
	
	List<Ticket> findByTheaterName(String theaterName);

}
