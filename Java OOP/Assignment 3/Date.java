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
	}
	
	// fields
	String date;
	
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
		return this.date;
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
