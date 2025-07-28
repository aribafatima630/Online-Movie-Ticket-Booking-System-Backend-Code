package QuickTickets.Management.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Integer>{
	
	User findBypassword(String password);
	
	User findByemailId(String emailId);
	
	User findByname(String name);

}
