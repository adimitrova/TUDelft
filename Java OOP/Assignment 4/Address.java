import java.io.IOException;
import java.util.Scanner;

public class Address {
	Scanner input = new Scanner(System.in);
		
	private String street;
	private int number;
	private String zipCode;
	private String city;
	
	// Class constructor
	public Address(String streetIn, int numberIn, String zipCodeIn, String cityIn) {
		street = streetIn;
		number = numberIn;
		zipCode = zipCodeIn;
		city = cityIn;
	}
	
	public Address() {
		street = null;
		number = 0;
		zipCode = null;
		city = null;
	}
	
	// -------- Field getters ---------
	// Street getter
	public String getStreet() {
		return street;
	}
	
	// number getter
	public int getNumber() {
		return number;
	}
	
	// ZIP code getter
	public String getZipCode() {
		return zipCode;
	}
	
	// City getter
	public String getCity() {
		return city;
	}
	
	/**
	 * Method to read text and parse it into a new Address object
	 * @param input
	 * @return Address object
	 */
	public static Address read(Scanner input) throws IOException {		
		String street = input.next();
		int number = input.nextInt();
		String zip = input.next();
		String city = input.next();
		
		Address address = new Address(street,number,zip,city);
		return address;
	}
	
	
	/**
	 * Return friendly representation of the address
	 */
	public String toString() {
		return "Address <" + street + " " + number + ", " + zipCode + ", " + city + ">";
	}
	
	
	/**
	 * Return whether 2 Address objects are the same
	 * 
	 * NOTE: works when values are hard-coded, doesn't work when value are manually entered via Scanner and input.NextInt()
	 * Maybe the empty line input.nextLine() after NextInt() causes it? I add it in order to consume the empty line after
	 * adding integer.
	 */
	public boolean equals(Object other) {
		boolean equals = false;
		if(other instanceof Address) {
			Address second = (Address) other;
			if(this.getStreet() == second.getStreet() && this.getNumber() == second.getNumber() 
					&& this.getZipCode() == second.getZipCode() && this.getCity() == second.getCity()) {
				equals = true;
			}
		}
		return equals;
	}
	
}
