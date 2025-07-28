package QuickTickets.Management.Theaters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QuickTickets.Management.Address.AddressService;

@Service
public class TheaterServiceLayer {
	
	@Autowired
	private TheaterRepository theaterRepository;
	
	@Autowired
	private AddressService addressService;
	
	public List<Theaters> getAllTheaters(){
		return theaterRepository.findAll();
	}
	
	public List<Theaters> getAllTheatersByCity(String city){
		
		List<Integer> addressId = addressService.findAddressIdByCity(city);
		
		return theaterRepository.findByAddress_addressIdIn(addressId);
	}
	
	public Theaters getByemailId(String email) {
		return theaterRepository.findByemail(email);
	}
	
	public Theaters addTheater(Theaters theater) {
		return theaterRepository.save(theater);
	}
	
	public Theaters putTheater(int id, Theaters updatedTheater) {
		
		Theaters theater = theaterRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Not Found"));
		
		theater.setTheaterName(updatedTheater.getTheaterName());
		theater.setAddress(updatedTheater.getAddress());
		theater.setContactNumber(updatedTheater.getContactNumber());
		theater.setEmail(updatedTheater.getEmail());
		theater.setScreens(updatedTheater.getScreens());
		
		if(updatedTheater.getPassword() != null) {
			theater.setPassword(updatedTheater.getPassword());
		}
		
		return theaterRepository.save(theater);

	}
	
	public String deleteTheater(int id) {
		if(!theaterRepository.existsById(id)) {
			throw new RuntimeException("Theater Not Found with ID:"+id);
		}
		theaterRepository.deleteById(id);
		return "Deleted Successfully of ID:"+id;
	}

}
