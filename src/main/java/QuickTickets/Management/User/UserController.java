package QuickTickets.Management.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserServiceLayer userService;
	
	@GetMapping("/api/user")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/api/userById")
	public User getUserById(@RequestParam int id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/api/userByPassword")
	public User getUserByPassword(@RequestParam String password) {
		return userService.getUserByPassword(password);
	}
	
	@GetMapping("/api/userByEmail")
	public User getByEmailId(@RequestParam String emailId) {
		return userService.getByEmailId(emailId);
	}
	
	@PostMapping("/api/user")
	public User addUser(@RequestBody User user) {
		System.out.println("Received user: " + user);
		return userService.addUser(user);
	}
	
	@PostMapping("/api/admin/signup")
	public User addAdmin(@RequestBody User user) {
		return userService.addAdmin(user);
	}
	
	@PutMapping("/api/user")
	public User updateUser(@RequestParam int id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}
	
	@DeleteMapping("/api/user")
	public User deleteUser(@RequestParam int id) {
		return userService.deleteUser(id);
	}
	
}
