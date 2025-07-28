package QuickTickets.Management.DTO.LoginRequest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import QuickTickets.Management.EnumConfiguration.Role;
import QuickTickets.Management.Theaters.TheaterServiceLayer;
import QuickTickets.Management.Theaters.Theaters;
import QuickTickets.Management.User.User;
import QuickTickets.Management.User.UserRepository;

@RestController
@RequestMapping("/api/auth")
//@CrossOrigin(origins = "*")
public class AuthController {
	
	@Autowired
	private UserRepository userRepository ;
	
	@Autowired
	private TheaterServiceLayer theaterService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request){
		
		User user = userRepository.findByemailId(request.getEmailId());
		
		if( user == null) {
			return ResponseEntity.status(401).body("User Not Found");
		}
		
		if(!user.getPassword().equals(request.getPassword())) {
			return ResponseEntity.status(401).body("Invalid Credentials");
		}
		
		if(user.getRole() == Role.ADMIN) {
			Theaters theater = theaterService.getByemailId(user.getEmailId());
			if(theater==null) {
				return ResponseEntity.status(401).body("Theater not found");
			}
			
			theater.setPassword(null);
			
			 Map<String, Object> response = new HashMap<>();
			    response.put("role", Role.ADMIN);
			    response.put("theater", theater);

			    return ResponseEntity.ok(response);
		}
		
		user.setPassword(null);
		return ResponseEntity.ok(user);
	}
	

}
