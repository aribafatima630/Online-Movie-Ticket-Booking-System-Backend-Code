package QuickTickets.Management.Address;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_id")
	private int addressId;
	
	@Column(name="street_no")
	String streetNo;
	
	@Column(name="landmark")
	String landmark;
	
	@Column(name="city")
	String city;
	
	@Column(name="pincode")
	String pincode;
	
	public Address() {}

	public Address(String streetNo, String landmark, String city, String pincode) {
		super();
		this.streetNo = streetNo;
		this.landmark = landmark;
		this.city = city;
		this.pincode = pincode;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [streetNo=" + streetNo + ", landmark=" + landmark + ", city=" + city + ", pincode=" + pincode
				+ "]";
	}
	
	
}
