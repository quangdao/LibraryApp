package business;

import java.io.Serializable;

public class User implements Serializable{
	private Member member;
	private String username;
	private String password;
	private Role role;
	
	public User(Member member, String username, String password, Role role) {
		this.member = member;
		this.password = password;
		this.username = username;
		this.role = role;
	}
	
	public Member getMember() {
		return member;
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
		return new String(this.member + " " + this.username + " " +this.password + " " +  this.role.toString());
	}
}
