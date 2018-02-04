package codingSchoolAppP1;


public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	
	public User(String username, String password, String email) {
		this.username = username;
		this.setPassword(password);
		this.email = email;
	}
	
	public User() {}
	
	public String toString() {
		return "ID: '" + id + "'\n" + "Username: '" + username + "'\n" + "Password: '" + password + "'\n" + "Email: '" + email + "'";
	}
	
	public int getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public User setUsername(String username) {
		this.username = username;
		return this;
	}
	
	public String getEmail() {
		return email;
	}
	
	public User setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}

}
