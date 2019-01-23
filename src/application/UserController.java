package application;

import java.time.LocalDateTime;

import business.Address;
import business.Author;
import business.Member;
import business.Person;
import business.Role;
import business.User;

public class UserController {
	
	public static Address createAddress(String street, String city, String state, String zip) {
		return new Address(street, city, state, zip);
	}
	
	public static Person createAuthor(String firstname, String lastname, String phone, Address address, String credendtials, String bio) {		
		LocalDateTime currentTime = LocalDateTime.now();
		String id = ""+currentTime.getYear() + currentTime.getMonth() + currentTime.getDayOfMonth() +currentTime.getHour() +currentTime.getMinute()+currentTime.getSecond();
		Person person = new Author(id, firstname, lastname, phone, address, credendtials,bio); 
		return person;
	}
	
	public static Person createMember(String firstname, String lastname, String phone, Address address) {		
		LocalDateTime currentTime = LocalDateTime.now();
		String id = ""+currentTime.getYear() + currentTime.getMonth() + currentTime.getDayOfMonth() +currentTime.getHour() +currentTime.getMinute()+currentTime.getSecond();
		return new Member(id, firstname, lastname, phone, address);
	}
	
	public static User createUser (Member member, String username, String password, Role role) {
		return new User(member, username, password, role);
	}
	
	
	
	
	
}
