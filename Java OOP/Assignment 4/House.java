import java.io.IOException;
import java.util.Scanner;

public class House {
	public static void main(String[] args) {
		Address adr1 = new Address("SomeStreet",100,"ABC","Delft");
		Address adr2 = new Address("SomeStreet",100,"ABC","Delft");
		Address adr3 = new Address("AnotherStreet",16,"1003","Sofia");
		
		House house1 = new House(adr1,3,117000);
		House house2 = new House(adr2,3,117000);
		House house3 = new House(adr3,8,1000000);
		
		System.out.println(house3.toString());
		System.out.println(house1.equals(house2));
	}
	
	Scanner input = new Scanner(System.in);
	
	private Address address;
	private int nRooms;
	private int salePrice;
	
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
	
	// house address getter
	public Address getAddress() {
		return address;
	}
	
	// number of rooms getter
	public int getNoOfRooms() {
		return nRooms;
	}
	
	// Sales price getter
	public int getSalePrice() {
		return salePrice;
	}
	
	public boolean costsAtMost(int price) {
		if(price <= this.salePrice) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "House [" + this.getAddress() + ", " + this.getNoOfRooms() + " room(s), €" + this.getSalePrice() + "]";
	}
	
	// i don't understand what they ask for this method
	// TODO: fix.. ever | low priority
	public static House read(Scanner input) throws IOException {
		return null; //new House(Address.read(input),input.nextInt(),input.next()); 
	}
	
	public boolean equals(Object other) {
		boolean equals = false;
		
		if(other instanceof House) {
			House second = (House) other;
			if(this.getAddress() == second.getAddress()
					&& this.getNoOfRooms() == second.getNoOfRooms()
					&& this.getSalePrice() == second.getSalePrice()) {
				equals = true;
			}
		}
		return equals;
	}

}
