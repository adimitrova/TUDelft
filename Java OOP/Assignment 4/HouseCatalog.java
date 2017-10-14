import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author ani
 *
 */

public class HouseCatalog {
/*	public static void main(String[] args) throws IOException {
		System.out.println("House file name: ");
		Scanner input = new Scanner(System.in);
		String fileToRead = input.next();
		
		HouseCatalog.read(fileToRead);
		
	}*/
	
	static Set<House> houses;
	static List<House> outpList = new ArrayList<House>();
	
	/**
	 * Constructor
	 */
	public HouseCatalog() {
		houses = new HashSet<House>(outpList);
	}
	
	/**
	 * Add House obj to the set
	 * @param house
	 */
	public void addHouse(House house) {
		houses.add(house);
	}
	
	/**
	 * Check for max price and return houses that are equal to or below that price
	 * @param price
	 * @return
	 */
	public List<House> housesCostAtMost(int price){
		List<House> housesLessThanMax = new ArrayList<House>();
		
		for (House house : houses) {
			if(house.getSalePrice() <= price) {
				housesLessThanMax.add(house);
			}
		}
		return housesLessThanMax;
	}
	
	/**
	 * Read file containing House and Address objects and return HouseCatalog out of these houses as a set
	 * 
	 * ------ FIXED ------
	 * ISSUE: i don't know how to do it. Everything I try doesn't work. I don't know how to provide a file that contains everything,
	 * House details and Address details and have these read if I call the House.read() and it calls Address.read() on its end. 
	 * Because I provide a filled with just one address file to Address.read() and just one House file to House.address(), how to read a file
	 * with the following format then?
	 * 
	 * @param fileNameIn
	 * @return
	 * @throws IOException
	 */
	public static HouseCatalog read(String fileNameIn) throws IOException {		
		String fileIn = fileNameIn;
		Scanner readFromFile = new Scanner(fileIn);
		outpList = House.read(readFromFile);
		
		HouseCatalog catalog = new HouseCatalog();
		System.out.println(catalog);
		return catalog;
	}
	
	/**
	 * return friendly representation of the catalog of houses
	 */
	public String toString() {
		String beginning = "HouseCatalog <";
		String finaloutp = "";
		for (int i = 0; i < House.getHouseList().size(); i++) {
			finaloutp += "\n" + House.getHouseList().get(i).toString();
		}		
		return beginning + finaloutp + ">";			
	}
}
