package QuickTickets.Management.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QuickTickets.Management.EnumConfiguration.Role;

@Service
public class UserServiceLayer {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public User getUserByPassword(String password) {
	    return userRepository.findBypassword(password);
	}
	
	public User getByEmailId(String emailId) {
		return userRepository.findByemailId(emailId);
	}
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public User addAdmin(User user) {
		user.setRole(Role.ADMIN);
		return userRepository.save(user);
	}
	
	public User updateUser(int id,User user) {
		User newUser = userRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("User Not Found"));
		
		newUser.setName(user.getName());
		newUser.setEmailId(user.getEmailId());
		newUser.setPassword(user.getPassword());
		newUser.setRole(user.getRole());
		
		return userRepository.save(newUser);
	}
	
	public User deleteUser(int id) {
		Optional<User> user = userRepository.findById(id);
		
		if(user.isPresent()) {
			userRepository.deleteById(id);
			return user.get();
		}else {
			throw new RuntimeException("user Not Found");
		}
	}

}
