import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class House {
	private Address address;
	private int nRooms;
	private int salePrice;
	private static List<House> houseList = new ArrayList<House>();
	
	/**
	 * Class Constructor
	 * @param addressIn
	 * @param nRoomsIn
	 * @param salePriceIn
	 */
	public House(Address addressIn, int nRoomsIn, int salePriceIn) {
		address = addressIn;
		nRooms = nRoomsIn;
		salePrice = salePriceIn;
	}
	
	public House() {
		address = null;
		nRooms = 0;
		salePrice = 0;
	}
	
	// house address getter
	public Address getAddress() {
		return this.address;
	}
	
	// number of rooms getter
	public int getNoOfRooms() {
		return nRooms;
	}
	
	// Sales price getter
	public int getSalePrice() {
		return salePrice;
	}
	
	// address list getter
	public static List<House> getHouseList() {
		return houseList;
	}
	
	// add house to the list
	public static void addHouseToList(House houseIn) {
		houseList.add(houseIn);
	}
	
	/**
	 * check for max price and output the houses that are equal or below this price
	 * 
	 * @param price
	 * @return
	 */
	public boolean costsAtMost(int price) {
		if(price <= this.salePrice) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns friendly representation of the House object
	 */
	public String toString() {
		return "House [" + this.getAddress() + ", " + this.getNoOfRooms() + " room(s), €" + this.getSalePrice() + "]";
	}
	
	public static int countLines(String inpFile) throws IOException {
		int lineCount = 0;
		BufferedReader reader = new BufferedReader(new FileReader(inpFile));
		while (reader.readLine() != null) {
			lineCount++;
		}
		reader.close();
		return lineCount;
	}

	/**
	 * Reads a file and extracts the data from it and makes an instance of class House
	 * 
	 * @param inp
	 * @return
	 * @throws IOException
	 */
	public static List<House> read(Scanner inp) throws IOException {
		String inpFile = inp.nextLine() + ".txt";
		File houseFile = new File(inpFile);
		Scanner readHouseFile = new Scanner(houseFile, "UTF-8");	// parse File object to the Scanner
		//int lineNr = countLines(inpFile);
		
		//create and initialize variables
		House tempHouse = null;
		Address tempAdr = null;
		int rooms, price;
		rooms = price = 0;
		List<House> tempList = new ArrayList<House>();
		
		/**
		 * Files have the form of:
		 * 1									[Count of houses to be created]
		 * DeHovenStraat 16 2932FV Delft		[Address]
		 * 7 1223000							[House Parameters]
		 * 
		 * ISSUE: This means that when this is provided to the HouseCatalog class, I need to read the first int 
		 * to know how many Houses to create with the House.read() method. However the House.read() gets the exact same file
		 * So it needs to skip the first 2 lines: disregard the first one as it's the number of houses in the file
		 * and assign the result from reading the second with the Address.read() to an Address object. 
		 * The Address.read(), on its end needs to only read the second line and produce the Address file.
		 * However what if there is more than one address?  
		 */
		while(readHouseFile.hasNextLine()) {
			Scanner readLine = new Scanner(readHouseFile.nextLine());	// this will select the first line (which is the House count and we don't need it)
			String line = readLine.nextLine();		// assign value of the curr line to the line variable	[houses count]
			String[] splitLine = line.split("\\s+");	// split the line in words by a space delimiter
			int wordCount = splitLine.length;	//count the number of words on the line
			
				if(wordCount > 1 && wordCount < 5) {
					// if line contains address data
					if(wordCount == 4) {
						tempAdr = Address.read(line); 
				}
				
				// if line contains house data
				if(wordCount == 2) {					
					rooms = Integer.parseInt(splitLine[0]);	// assign the first token/word to rooms number variable
					price = Integer.parseInt(splitLine[1]);	// assign the second token/word to price variable
					tempHouse = new House(tempAdr,rooms,price);
					houseList.add(tempHouse);
				}
			}		
		}
		
		readHouseFile.close();
		return houseList;
	}
	
	/**
	 * Checks if 2 houses are the same
	 */
	public boolean equals(Object other) {
		boolean equals = false;
		
		if(other instanceof House) {
			House second = (House) other;
			if(this.getAddress().equals(second.getAddress())
					&& this.getNoOfRooms() == second.getNoOfRooms()
					&& this.getSalePrice() == second.getSalePrice()) {
				equals = true;
			}
		}
		return equals;
	}

}
