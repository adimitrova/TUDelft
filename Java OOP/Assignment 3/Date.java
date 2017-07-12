import java.util.Arrays;

/**
 * Class representing the current Date
 * @author Anelia Dimitrova
 * @version 1
 *
 */
public class Date {

	public static void main(String[] args) {
		Date today = new Date("13-jun-17");
		Date tomorrow = new Date("13-jun-17");
		System.out.println(today.equals(tomorrow));
		System.out.println(today.toString());
	}
	
	// fields
	String date;
	String combined; 
	
	/**
	 * class constructor
	 * initializes the date with the input date from the user
	 * @param inpDate
	 */
	public Date(String inpDate){
		date = inpDate;
	}
	
	/**
	 * returns a representation of the current date
	 */
	public String toString(){
		String start = "Date[";
		String fullDate = date;
		String end = "]";
		combined = start + fullDate + end;
		
		return this.combined;
	}
	
	/**
	 * Compares if two Date objects are the same
	 * @param other (date object)
	 */
	public boolean equals(Object other){
		boolean equal = false;
		if(other instanceof Date){
			Date second = (Date) other;
			if(this.toString() == second.toString()){
				equal = true;
			}
		}
		return equal;
	}
}
