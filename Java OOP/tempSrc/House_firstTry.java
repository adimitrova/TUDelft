import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class House_firstTry {
//	public static void main(String[] args) throws IOException {
//		Scanner input = new Scanner(System.in);
//		
//		House.read(input);
//	}
	
	Scanner input = new Scanner(System.in);
	
	private Address_firstTry address_firstTry;
	private int nRooms_firstTry;
	private int salePrice_firstTry;
	private static List<House_firstTry> houseList_firstTry;
	
	/**
	 * Class Constructor
	 * @param addressIn
	 * @param nRoomsIn
	 * @param salePriceIn
	 */
	public House_firstTry(Address_firstTry addressIn, int nRoomsIn, int salePriceIn) {
		address_firstTry = addressIn;
		nRooms_firstTry = nRoomsIn;
		salePrice_firstTry = salePriceIn;
	}
	
	// house address getter
	public Address_firstTry getAddress_firstTry() {
		return address_firstTry;
	}
	
	// number of rooms getter
	public int getNoOfRooms_firstTry() {
		return nRooms_firstTry;
	}
	
	// Sales price getter
	public int getSalePrice_firstTry() {
		return salePrice_firstTry;
	}
	
	// address list getter
	public static List<House_firstTry> getHouseList() {
		return houseList_firstTry;
	}
	
	public boolean costsAtMost_firstTry(int price) {
		if(price <= this.salePrice) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "House [" + this.getAddress_firstTry() + ", " + this.getNoOfRooms_firstTry() + " room(s), €" + this.getSalePrice_firstTry() + "]";
	}

	// i don't understand what they ask for this method
	// TODO: fix.. ever | low priority
	public static String read(Scanner inp) throws IOException {
		int tempRooms;
		int tempPrice;
		House_firstTry tempHouse;
		String tempHouseString = null;
		List<House_firstTry> tempHouseList = new ArrayList<House_firstTry>();
		
		for (Address_firstTry adr : Address_firstTry.getAddressList_firstTry()) {
			System.out.println("House: " + adr + "\n");
			System.out.print("Enter price for it: ");
			tempPrice = inp.nextInt();
			System.out.print("Enter number of rooms: ");
			tempRooms = inp.nextInt();
			tempHouse = new House_firstTry(adr, tempRooms, tempPrice);
			tempHouseList.add(tempHouse);
		}
		
		houseList = tempHouseList;
		for (House_firstTry hs : tempHouseList) {
			tempHouseString = hs.toString();
		}
		return tempHouseString;
	}
	
	public boolean equals(Object other) {
		boolean equals = false;
		
		if(other instanceof House_firstTry) {
			House_firstTry second = (House_firstTry) other;
			if(this.getAddress_firstTry() == second.getAddress_firstTry()
					&& this.getNoOfRooms_firstTry() == second.getNoOfRooms_firstTry()
					&& this.getSalePrice_firstTry() == second.getSalePrice_firstTry()) {
				equals = true;
			}
		}
		return equals;
	}

}
