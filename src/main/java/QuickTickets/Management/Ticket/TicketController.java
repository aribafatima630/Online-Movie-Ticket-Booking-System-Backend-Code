package QuickTickets.Management.Ticket;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import QuickTickets.Management.TicketMailSender.TicketMailSender;

@RestController
public class TicketController {
	
	@Autowired
	private TicketServiceLayer ticketService;
	
	@PostMapping("/api/ticket")
	public Ticket bookTicket(@RequestBody Ticket ticket) {
		return ticketService.bookTicket(ticket);
	}
	
	@GetMapping("/api/ticket")
	public Optional<Ticket> getTicket(@RequestParam Long id){
		return ticketService.getTicket(id);
	}
	
	@GetMapping("/api/ticket/byTheater")
	public List<Ticket> getTicketByTheaterName(@RequestParam String theaterName){
		return ticketService.getTicketByTheaterName(theaterName);
	}

}
