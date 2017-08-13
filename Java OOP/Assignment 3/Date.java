import java.util.Arrays;

/**
 * Class representing a list/set, containing multiple Dates
 * @author Anelia Dimitrova
 * @version 2
 * @date last (updated/modified) on: 12/07/17
 * @date finished: 14/06/17
 */

public class Date {
	
	// fields
	private String date;
	private String combined; 
	
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
	@Override
	public String toString(){
		return this.date;
	}
	
	/**
	 * Compares if two Date objects are the same
	 * @param other (date object)
	 */
	@Override
	public boolean equals(Object other){
		boolean equal = false;
		if(other instanceof Date){
			Date second = (Date) other;
			if(this.date == second.date){
				equal = true;
			}
		}
		return equal;
	}
}
