package business;

public class User {
	private Member member;
	private String username;
	private String password;
	private Role role;
	
	public User(Member member, String username, String password, Role role) {
		this.password = password;
		this.username = username;
		this.role = role;
	}
}
