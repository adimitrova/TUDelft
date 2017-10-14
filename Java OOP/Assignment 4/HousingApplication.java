import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Note: This assignment is very modified. Some methods are altered due to the fact that I couldn't do something the way it was required,
 * so I did it in another way, probably more complex and/or weird/dumb. So you cannot rely on this if you want to copy parts of this for your TUDelft assignment :)
 * Oh, and it's also not a good practice, your own knowledge will suffer :)
 *  
 * @author Ani
 * @version 15 oct 17   FINALLY DONE (PHEW). Not sure all tests will be uploaded
 *
 */
public class HousingApplication {
	
	public static void main(String[] args) throws IOException {
		// --------------- as per the assignment ------------
		System.out.println("House file name: ");
		Scanner input = new Scanner(System.in);
		String fileToRead = input.next();
		
		/**
		 *  if I don't read the file first, the HouseCatalog created as an empty HashSet. If I first read the file
		 *  it reads it and creates an ArrayList which is then converted to HashSet and new HouseCatalog is created
		 *  So that's why I first create an empty catalog and then assign it the value of the read() method. 
		 */
		HouseCatalog catalog = new HouseCatalog();
		catalog = HouseCatalog.read(fileToRead);
		
		System.out.print("\nEnter max price: ");
		
		int maxPrice = input.nextInt();
		List<House> usersList = new ArrayList<House>();
		usersList = catalog.housesCostAtMost(maxPrice);
				
		for (House house : usersList) {
			System.out.println(house.toString());
		}
	}
}