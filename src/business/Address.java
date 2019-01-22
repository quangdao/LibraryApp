package business;

public class Address {
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
	
	
}
