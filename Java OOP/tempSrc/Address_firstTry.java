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

public class Address_firstTry implements Serializable {
	 /* 
	  * ------------------------------------------------------------------------------
	  * ------------------------------ CLASS CODE ------------------------------------
	  * ------------------------------------------------------------------------------
	  */
	Scanner input = new Scanner(System.in);
		
	private String street;
	private int number;
	private String zipCode;
	private String city;
	private static String ioFile;
	private static List<Address_firstTry> addressList;
	
	// Class constructor
	public Address_firstTry(String streetIn, int numberIn, String zipCodeIn, String cityIn) {
		street = streetIn;
		number = numberIn;
		zipCode = zipCodeIn;
		city = cityIn;
		addressList = new ArrayList<Address_firstTry>();
	}
	
	public Address_firstTry() {
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
	public static List<Address_firstTry> getAddressList() {
		return addressList;
	}
	
	/**
	 * Method to read text and parse it into a new Address object
	 * Also creates a file where the address details are saved. 
	 * 
	 * @param input
	 * @return Address object
	 * 
	 * @Note: I think I need to read the address from the keyboard from the user
	 * then create an object and save it in a text file
	 * @NB! replaced the method name from read() to write()
	 */
	public static Address_firstTry write(Scanner input) throws IOException {		
		System.out.print("Street: \n");
		String street = input.next();
		System.out.print("Number: \n");
		int number = input.nextInt();
		System.out.print("Zip Code: \n");
		String zip = input.next();
		System.out.print("City: \n");
		String city = input.next();
		
		Address_firstTry address = new Address_firstTry(street,number,zip,city);
		
		// take the data and write it to a text file where each address gets on a new line and an empty line is inserted at the end
		FileWriter addressFile = new FileWriter(ioFile, true); // this constructor appends data at the end and doesn't wipe old data out
		PrintWriter adrWriter = new PrintWriter(addressFile);
		adrWriter.println(address.getStreet());
		adrWriter.println(address.getNumber());
		adrWriter.println(address.getZipCode());
		adrWriter.println(address.getCity());
		adrWriter.println();
		adrWriter.close();
		
		return address;
	}
	
	public static String getList(List<Address_firstTry> addrListIn) throws IOException {
		Address_firstTry.readList(addrListIn);
		String tempAdr = null;
		
		for (Address_firstTry adr : addrListIn) {
			tempAdr = adr.toString();
		}
		return tempAdr;
	}
	
	/**
	 * Extra method out of the assignment for reading out the whole list of Address objects
	 * I plan to use it in the House Class by showing the address to the user and asking for details like Rooms and Price 
	 * and then saving them back together in a House Object 
	 * Note: this method also plays as an Address List setter (by adding values to it from reading them from a file)
	 * 
	 * @param List<Address> AddrListIn
	 * @throws IOException
	 */
	public static void readList(List<Address_firstTry> addrListIn) throws IOException {
		try {
			addressList = addrListIn;	// assigning the input list to the class field list
			// read from a previously created file from user input
			FileReader inpAdrFileRead = new FileReader(ioFile);
			BufferedReader adrStream = new BufferedReader(inpAdrFileRead);
			String currLine = adrStream.readLine();
			// counter to count the number of objects
			int count = 0;
			
			// create some variables
			String tempStreet = null;
			int tempNumber = 0;
			String tempStringNumber = null;
			String tempZip = null;
			String tempCity = null;
			
			// check if the line is empty and if not, read 4 lines and create an object
			try {
				while(!currLine.isEmpty()) {
					tempStreet = currLine;

					// Go to next line drStream.readLine() and parse the result to a variable
					tempStringNumber = adrStream.readLine();
					tempNumber = Integer.parseInt(tempStringNumber);
					
					// Go to next line drStream.readLine() and parse the result to a variable
					tempZip = adrStream.readLine();
					
					// Go to next line drStream.readLine() and parse the result to a variable
					tempCity = adrStream.readLine();
					
					Address_firstTry tempAdr = new Address_firstTry(tempStreet,tempNumber,tempZip,tempCity);
					addressList.add(tempAdr);
					
					// Go to next line drStream.readLine() and parse the result to a variable
					currLine = adrStream.readLine();
					
					count++;
					
					// if the next line is empty, trim it so we get to a non-empty line which should also keep us within the outer if statement
					if(currLine.isEmpty()) {
						// trims the line
						currLine.trim();
						// read next line
						currLine = adrStream.readLine();
					}
				}
			} catch (NullPointerException endOfFile){
				System.out.println("Reached end of file.");
				System.out.printf("%d objects found.\n---------List of Objects---------\n", count);
			}
		} catch (java.io.FileNotFoundException noSuchFile) {
			System.out.println("File not created due to 0 entries");
		}
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
		if(other instanceof Address_firstTry) {
			Address_firstTry second = (Address_firstTry) other;
			if(this.getStreet() == second.getStreet() && this.getNumber() == second.getNumber() 
					&& this.getZipCode() == second.getZipCode() && this.getCity() == second.getCity()) {
				equals = true;
			}
		}
		return equals;
	}
	
}
