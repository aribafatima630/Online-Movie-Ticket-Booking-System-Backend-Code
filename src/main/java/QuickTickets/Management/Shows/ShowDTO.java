package QuickTickets.Management.Shows;

import java.util.List;

import QuickTickets.Management.Movie.MovieDTO;
import QuickTickets.Management.Screens.ScreenDTO;
import QuickTickets.Management.TimeSlot.TimeSlot;
import QuickTickets.Management.TimeSlot.TimeSlotDTO;

public class ShowDTO {
	
	private int showId;
	private int movieId;
	private int screenId;
	private List<TimeSlot> timeSlot;
	
	public ShowDTO() {}
	
	public ShowDTO(int showId, int movieId, int screenId, List<TimeSlot> timeSlot) {
		this.showId = showId;
		this.movieId = movieId;
		this.screenId = screenId;
		this.timeSlot = timeSlot;
		
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public List<TimeSlot> getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(List<TimeSlot> timeSlot) {
		this.timeSlot = timeSlot;
	}

	@Override
	public String toString() {
		return "ShowDTO [showId=" + showId + ", movieId=" + movieId + ", screenId=" + screenId + ", timeSlot="
				+ timeSlot + "]";
	}
	
}
