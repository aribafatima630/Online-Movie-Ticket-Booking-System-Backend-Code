package QuickTickets.Management.Ticket;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="movie_name")
	private String movieName;
	
	@Column(name="theater_name")
	private String theaterName;
	
	@Column(name="show_date")
	private LocalDate showDate;
	
	@Column(name="show_time")
	private LocalTime showTime;
	
	@Column(name="total_tickets")
	private int totalTickets;
	
	@Column(name="price")
	private double price;
	
	@Column(name="booking_time")
	private LocalDateTime bookingTime;
	
	public Ticket() {}

	public Ticket(long id, String userName, String movieName, String theaterName, LocalDate showDate,
			LocalTime showTime, int totalTickets, double price, LocalDateTime bookingTime) {
		super();
		this.id = id;
		this.userName = userName;
		this.movieName = movieName;
		this.theaterName = theaterName;
		this.showDate = showDate;
		this.showTime = showTime;
		this.totalTickets = totalTickets;
		this.price = price;
		this.bookingTime = bookingTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public LocalDate getShowDate() {
		return showDate;
	}

	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}

	public LocalTime getShowTime() {
		return showTime;
	}

	public void setShowTime(LocalTime showTime) {
		this.showTime = showTime;
	}

	public int getTotalTickets() {
		return totalTickets;
	}

	public void setTotalTickets(int totalTickets) {
		this.totalTickets = totalTickets;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDateTime getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(LocalDateTime bookingTime) {
		this.bookingTime = bookingTime;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", UserName=" + userName + ", movieName=" + movieName + ", theaterName="
				+ theaterName + ", showDate=" + showDate + ", showTime=" + showTime + ", totalTickets=" + totalTickets
				+ ", price=" + price + ", bookingTime=" + bookingTime + "]";
	}
	

}
