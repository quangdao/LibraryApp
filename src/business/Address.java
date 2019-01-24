package business;

import java.io.Serializable;


public class Address implements Serializable{
	private static final long serialVersionUID = 2628632935836470086L;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	public Address(String street, String city, String state,String zip) {
		this.zip = zip;
		this.city = city;
		this.state = state;
		this.street = street;	
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getStreet() {
		return street;
	}
	public String getZip() {
		return zip;
	}
	
	
	@Override
	public String toString() {
		
		return new String(this.street + " " + this.city + " " + this.state + " " + this.zip );
		
	}
	
	
	
}
