package QuickTickets.Management.Screens;



import com.fasterxml.jackson.annotation.JsonIgnore;
import QuickTickets.Management.Theaters.Theaters;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="screens")
public class Screens {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="screen_id")
	private int screenId;
	
	@Column(name="screen_name")
	private String screenName;
	
	@Column(name="total_seat")
	private int totalSeat;
	
	@ManyToOne
	@JoinColumn(name="theater_id",nullable=false)
	@JsonIgnore
	private Theaters theaters;
	
	public Screens() {}

	public Screens(int screenId, String screenName, int totalSeat, Theaters theaters) {
		super();
		this.screenId = screenId;
		this.screenName = screenName;
		this.totalSeat = totalSeat;
		this.theaters = theaters;
		//this.shows = shows;
	}

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

	public Theaters getTheater() {
		return theaters;
	}

	public void setTheater(Theaters theaters) {
		this.theaters = theaters;
	}

//	public List<Shows> getShows() {
//		return shows;
//	}
//
//	public void setShows(List<Shows> shows) {
//		this.shows = shows;
//	}

	@Override
	public String toString() {
		return "Screens [screenId=" + screenId + ", screenName=" + screenName + ", totalSeat=" + totalSeat
				+ ", theater=" + theaters + "]";
	}
	

}
