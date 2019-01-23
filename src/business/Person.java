package business;

import java.io.Serializable;

public abstract class Person implements Serializable {
	private String ID;
	private String firstname;
	private String lastname;
	private String phone;
	private Address address;
	
	
	public Person(String id, String firstname, String lastname, String phone, Address address) {
		this.ID = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.address = address;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public String getID() {
		return ID;
	}
	public String getLastname() {
		return lastname;
	}
	public String getPhone() {
		return phone;
	}
	
	
	 
	@Override
	public String toString() {	
		return new String(this.ID + " " + this.firstname + " " + this.lastname + " " + this.phone + " " + this.address);
	}
}
