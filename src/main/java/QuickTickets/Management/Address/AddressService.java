package QuickTickets.Management.Address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	
	public List<Integer> findAddressIdByCity(String city){
		return addressRepository.findAddressIdByCity(city);
	}
	
	
}
