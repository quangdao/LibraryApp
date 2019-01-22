package business;

public class Author extends Person {
	private String credentials;
	private String bio;
	
	public Author(String credendtials, String bio, Person person) {		
		super(person.getID(), person.getFirstname(), person.getLastname(), person.getPhone(),person.getAddress());
		this.credentials = credendtials;
		this.bio = bio;
	}
	
	public String getBio() {
		return bio;
	}
	public String getCredentials() {
		return credentials;
	}
	
}
