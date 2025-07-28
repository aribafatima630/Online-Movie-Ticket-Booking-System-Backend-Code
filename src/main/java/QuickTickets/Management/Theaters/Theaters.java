package QuickTickets.Management.Theaters;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import QuickTickets.Management.Address.Address;
import QuickTickets.Management.Screens.Screens;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="theaters")
public class Theaters {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "theater_id")
	private int theaterId;
	
	@Column(name = "theater_name")
	private String theaterName;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id",referencedColumnName="address_id")
	private Address address;
	
	@Column(name = "contact_number")
	private String contactNumber;
	
	@Column(name = "email")
	private String email;
	
	@OneToMany(mappedBy="theaters", cascade= CascadeType.ALL)
	@JsonIgnore
	private List<Screens> screens;
	
	@Column(name="password", unique=true)
	private String password;
	
	public Theaters() {}

	public Theaters(int theaterId, String theaterName, Address address, String contactNumber, String email,List<Screens> screens, String password) {
		super();
		this.theaterId = theaterId;
		this.theaterName = theaterName;
		this.address = address;
		this.contactNumber = contactNumber;
		this.email = email;
		this.screens=screens;
		this.password = password;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Screens> getScreens() {
		return screens;
	}

	public void setScreens(List<Screens> screens) {
		this.screens = screens;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password= password;
	}
	

	@Override
	public String toString() {
		return "Theaters [theaterId=" + theaterId + ", theaterName=" + theaterName + ", Address=" + address
				+ ", contactNumber=" + contactNumber + ", email=" + email + ", Screens=" + screens + ", Password= " + password + "]";
	}
	

}
