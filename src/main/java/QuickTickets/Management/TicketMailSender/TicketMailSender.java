package QuickTickets.Management.TicketMailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import QuickTickets.Management.Ticket.Ticket;

@Service
public class TicketMailSender {
	
	@Autowired
	private JavaMailSender sender;
	
	public void ticketMailSender(String toEmail, Ticket ticket) {
		
		String subject = "Movie Ticket Confirmation!";
		
		String body= "Hello " + ticket.getUserName() + ",\n\n"
                + "Your ticket has been confirmed!\n\n"
                + "Movie: " + ticket.getMovieName() + "\n"
                + "Theater: " + ticket.getTheaterName() + "\n"
                + "Date: " + ticket.getShowDate() + "\n"
                + "Time: " + ticket.getShowTime() + "\n"
                + "Seats: " + ticket.getTotalTickets() + "\n"
                + "Total Price: ₹" + ticket.getPrice() + "\n"
                + "Booking Time: " + ticket.getBookingTime() + "\n\n"
                + "Enjoy your movie with!\nQuickTickets By Ariba Fatima";
		
		SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        sender.send(message);
	}
	

}
