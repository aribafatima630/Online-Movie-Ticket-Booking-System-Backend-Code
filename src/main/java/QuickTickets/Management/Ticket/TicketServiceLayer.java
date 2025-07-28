package QuickTickets.Management.Ticket;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QuickTickets.Management.TicketMailSender.TicketMailSender;
import QuickTickets.Management.User.User;
import QuickTickets.Management.User.UserRepository;

@Service
public class TicketServiceLayer {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TicketMailSender sender;
	
	@Autowired
	private TicketRepository ticketRepository;
	
	public Ticket bookTicket(Ticket ticket) {
		ticket.setBookingTime(LocalDateTime.now());
		ticketRepository.save(ticket);
		
		User user = userRepository.findByname(ticket.getUserName());
		
		if(user != null) {
			sender.ticketMailSender(user.getEmailId(), ticket);
		}
		
		
		return ticket;
	}
	
	public Optional<Ticket> getTicket(Long id) {
		return ticketRepository.findById(id);
	}
	
	public List<Ticket> getTicketByTheaterName(String theaterName){
		return ticketRepository.findByTheaterName(theaterName);
	}

}
