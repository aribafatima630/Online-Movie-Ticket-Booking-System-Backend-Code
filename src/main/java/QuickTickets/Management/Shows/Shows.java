package QuickTickets.Management.Shows;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import QuickTickets.Management.Movie.Movies;
import QuickTickets.Management.Screens.Screens;
import QuickTickets.Management.TimeSlot.TimeSlot;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="shows")
public class Shows {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="show_id")
	private int showId;
	
	@ManyToOne
	@JoinColumn(name = "movie_movie_id",referencedColumnName="movie_id")
	private Movies movie;
	
	@OneToOne
	@JoinColumn(name="screen_id",referencedColumnName="screen_id")
	private Screens screens;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<TimeSlot> time_slot;
	
	public Shows() {}

	public Shows(int showId, Movies movie, Screens screens, List<TimeSlot> time_slot) {
		super();
		this.showId = showId;
		this.movie = movie;
		this.screens = screens;
		this.time_slot = time_slot;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public Movies getMovie() {
		return movie;
	}

	public void setMovie(Movies movie) {
		this.movie = movie;
	}

	public Screens getScreens() {
		return screens;
	}

	public void setScreens(Screens screens) {
		this.screens = screens;
	}

	public List<TimeSlot> getTime_slot() {
		return time_slot;
	}

	public void setTime_slot(List<TimeSlot> time_slot) {
		this.time_slot = time_slot;
	}

	@Override
	public String toString() {
		return "Shows [showId=" + showId + ", movie=" + movie + ", screens=" + screens + ", time_slot=" + time_slot
				+ "]";
	}
	

}
