package QuickTickets.Management.Screens;

public class ScreenDTO {
    private int screenId;
    private String screenName;
    private int totalSeat;

    // Optional: include theater name or ID if needed in response
    private int theaterId;
    private String theaterName;

    // Constructors
    public ScreenDTO() {}

    public ScreenDTO(int screenId, String screenName, int totalSeat, int theaterId, String theaterName) {
        this.screenId = screenId;
        this.screenName = screenName;
        this.totalSeat = totalSeat;
        this.theaterId = theaterId;
        this.theaterName = theaterName;
    }

    // Getters and Setters
    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }
}