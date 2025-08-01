package QuickTickets.Management.Shows;

import java.util.List;

import QuickTickets.Management.Movie.MovieDTO;
import QuickTickets.Management.Screens.ScreenDTO;
import QuickTickets.Management.TimeSlot.TimeSlotDTO;

public class ShowDTO {
    private int showId;
    private MovieDTO movie;
    private ScreenDTO screen;
    private List<TimeSlotDTO> timeSlot;

    // Constructors
    public ShowDTO() {}

    public ShowDTO(int showId, MovieDTO movie, ScreenDTO screen, List<TimeSlotDTO> timeSlot) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.timeSlot = timeSlot;
    }

    // Getters and Setters
    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public MovieDTO getMovie() {
        return movie;
    }

    public void setMovie(MovieDTO movie) {
        this.movie = movie;
    }

    public ScreenDTO getScreen() {
        return screen;
    }

    public void setScreen(ScreenDTO screen) {
        this.screen = screen;
    }

    public List<TimeSlotDTO> getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(List<TimeSlotDTO> timeSlot) {
        this.timeSlot = timeSlot;
    }
}
