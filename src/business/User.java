package business;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = -4950812670890222362L;
	private String username;
	private String password;
	private Role role;
	
	public User(String username, String password, Role role) {
		this.password = password;
		this.username = username;
		this.role = role;
	}
	
	public String getPassword() {
		return password;
	}
	public String getUsername() {
		return username;
	}
	public Role getRole() {
		return role;
	}
	
	@Override
	public String toString() {
		return new String(this.username + " " +this.password + " " +  this.role.toString());
	}
}
