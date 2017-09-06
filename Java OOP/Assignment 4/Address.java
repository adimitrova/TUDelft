import java.util.Scanner;

public class Address {
	Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		Address adr1, adr2;		
		Scanner inp = new Scanner(System.in);
		
		System.out.println("Street: ");
		String addressin = inp.nextLine();
		System.out.println("Number: ");
		int numberin = inp.nextInt();
		System.out.println("ZIPCode: ");
		String zipin = inp.nextLine();
		inp.nextLine();
		System.out.println("City: ");
		String cityin = inp.nextLine();		
		
		adr1 = new Address(addressin,numberin,zipin,cityin);
		
		
		System.out.println("Street: ");
		String address2in = inp.nextLine();
		System.out.println("Number: ");
		int number2in = inp.nextInt();
		System.out.println("ZIPCode: ");
		String zip2in = inp.nextLine();
		inp.nextLine();
		System.out.println("City: ");
		String city2in = inp.nextLine();		
		
		adr2 = new Address(address2in,number2in,zip2in,city2in);
		
		System.out.println("Addresses are the same: " + adr1.equals(adr2));
		
	}
		
	private String street;
	private int number;
	private String zipCode;
	private String city;
	
	// -------- Field getters ---------
	// Street getter
	public String  getStreet() {
		return street;
	}
	
	// number getter
	public int  getNumber() {
		return number;
	}
	
	// ZIP code getter
	public String  getZipCode() {
		return zipCode;
	}
	
	// City getter
	public String  getCity() {
		return city;
	}
	
	// Class constructor
	public Address(String streetIn, int numberIn, String zipCodeIn, String cityIn) {
		street = streetIn;
		number = numberIn;
		zipCode = zipCodeIn;
		city = cityIn;
	}
	
	/**
	 * Method to read text and parse it into a new Address object
	 * @param input
	 * @return Address object
	 */
	public static Address read(Scanner input) {
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
		return "<Address: " + street + " " + number + ", " + zipCode + ", " + city + ">";
	}
	
	
	/**
	 * Return whether 2 Address objects are the same
	 */
	//TODO: fix why it doesn't work
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
