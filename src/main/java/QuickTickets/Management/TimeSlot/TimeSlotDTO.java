package QuickTickets.Management.TimeSlot;

import java.time.LocalTime;

public class TimeSlotDTO {
    private int timeSlotId;
    private LocalTime startTime;
    private LocalTime endTime;

    // Optional: include showId if needed for reference
    private int showId;

    // Constructors
    public TimeSlotDTO() {}

    public TimeSlotDTO(int timeSlotId, LocalTime startTime, LocalTime endTime, int showId) {
        this.timeSlotId = timeSlotId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.showId = showId;
    }

    // Getters and Setters
    public int getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(int timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }
}