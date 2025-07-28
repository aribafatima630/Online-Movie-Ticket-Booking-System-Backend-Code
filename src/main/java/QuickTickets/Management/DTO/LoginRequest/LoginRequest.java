package QuickTickets.Management.DTO.LoginRequest;

public class LoginRequest {
	
	String emailId;
	String password;
	
	public LoginRequest() {}
	
	public LoginRequest(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmail(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequest [email=" + emailId + ", password=" + password + "]";
	}

}
