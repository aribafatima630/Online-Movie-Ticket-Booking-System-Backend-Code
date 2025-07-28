package QuickTickets.Management.TimeSlot;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import QuickTickets.Management.Shows.Shows;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="time_slot")
public class TimeSlot {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int time_slot_id;
	
	@Column(name="start_time")
	private LocalTime startTime;
	
	@Column(name="end_time")
	private LocalTime endTime;
	
	@ManyToOne
	@JoinColumn(name="show_id",nullable = false)
	@JsonIgnore
	private Shows shows;
	
	public TimeSlot() {}

	public TimeSlot(int time_slot_id, LocalTime startTime, LocalTime endTime, Shows shows) {
		super();
		this.time_slot_id = time_slot_id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.shows = shows;
	}

	public int getTime_slot_id() {
		return time_slot_id;
	}

	public void setTime_slot_id(int time_slot_id) {
		this.time_slot_id = time_slot_id;
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
	
	@JsonIgnore
	public Shows getShows() {
		return shows;
	}

	public void setShows(Shows shows) {
		this.shows = shows;
	}

	@Override
	public String toString() {
		return "TimeSlot [time_slot_id=" + time_slot_id + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", shows=" + shows + "]";
	}
	
	

}
