import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.experimental.theories.Theories;

public class Address implements Serializable {
/*	public static void main(String[] args) throws IOException {
		Scanner readThis = new Scanner("AddressTest");
		Address actual = new Address("Molslaan", 16, "2932FV", "Delft");
		Address expected = Address.read(readThis);
		
		System.out.println(expected.equals(actual));
		System.out.println(expected.getStreet() + " | " + actual.getStreet());
		System.out.println(expected.getNumber() + " | " + actual.getNumber());
		System.out.println(expected.getZipCode() + " | " + actual.getZipCode());
		System.out.println(expected.getCity() + " | " + actual.getCity());
		
		Scanner input = new Scanner(System.in);
		System.out.println(read(input));
	}*/
	
	 /* 
	  * ------------------------------------------------------------------------------
	  * ------------------------------ CLASS CODE ------------------------------------
	  * ------------------------------------------------------------------------------
	  */
	
	private String street;
	private int number;
	private String zipCode;
	private String city;
	private static String ioFile;
	private static List<Address> addressList = new ArrayList<Address>();
	
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
	
	public static void setFileName(String FileNameIn) {
		ioFile = FileNameIn + ".txt";
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
	
	// address list getter
	public static List<Address> getAddressList() {
		return addressList;
	}
	
	/**
	 * Method to read from file with Scanner and return Address object
	 * ISSUE: I cannot return multiple objects at once?! If I have a file with more than one line and keeo the implementation as is
	 * I return only the last value, as they override. If I add the values in a List and use a foreach and assign the current value
	 * to the return statement, throws NullPointer exception
	 * And I cannot return the whole list because the return value needs to be address
	 * WORKAROUND: Only solution is to have just one line of data (i.e. just for one Address obj) per file, which is pointless
	 * TODO: figure this out
	 * P.S. adding the address objects into a list so I can iterate over them at some point, if necessary
	 * EXAMPLE: File must be with data for one object on a single line, separated by spaces AND an integer N as first line, like so:
	 * 1
	 * Street Number ZipCode City
	 * 
	 * @param input
	 * @return new Address object
	 * @throws IOException
	 */
	public static Address read(String input) throws IOException {	
		Address tempAdr = null;
	
		String line = input;		
		String[] splitLine = line.split("\\s+");
		int wordCount = splitLine.length;
		
		// if line contains address data
		if(wordCount == 4) {
			String tempStreet = splitLine[0];
			String tempNumStr = splitLine[1];
			int tempNumber = Integer.parseInt(tempNumStr);
			String tempZip = splitLine[2];
			String tempCity = splitLine[3];
			
			tempAdr = new Address(tempStreet,tempNumber,tempZip,tempCity);
		}	
		
		return tempAdr;
	}
	
	
	/**
	 * Return whether 2 Address objects are the same
	 * IMPORTANT: When comparing Strings ALWAYS use the .equal() method of the String class
	 */
	public boolean equals(Object other) {
		boolean equals = false;
		if(other instanceof Address) {
			Address second = (Address) other;
			if(this.getStreet().equals(second.getStreet()) && this.getNumber() == second.getNumber() 
			&& this.getZipCode().equals(second.getZipCode()) && this.getCity().equals(second.getCity()) ) {
				equals = true;
			}
		}
		return equals;
	}
	
	/**
	 * Return friendly representation of the address
	 */
	public String toString() {
		return "Address <" + street + " " + number + ", " + zipCode + ", " + city + ">";
	}
	
}
