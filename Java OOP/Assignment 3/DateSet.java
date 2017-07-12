/**
 * Class representing a list/set, containing multiple Dates
 * @author Anelia Dimitrova
 * @version 2
 * @date 12/07/17
 */

import java.util.*;

public class DateSet {

	// ------------------- MAIN METHOD -----------------
	public static void main(String[] args) {
		DateSet list1 = new DateSet();
		DateSet list2 = new DateSet();
		Date date1 = new Date("17-05-17");
		Date date2 = new Date("18-05-17");
		
		list1.add(date1);
		list2.add(date2);
		
		//System.out.println(list1.contains(date1));
		//System.out.println(list2.contains(date1));
		
		System.out.println(list2.toString());
		System.out.println(list1.intersection(list2));
		
	}
	// ------------------- END METHOD -----------------
	
	
	// ------------------- MAIN CLASS CODE -----------------
	private List<Date> listOfDates;
	private Date date;
	private int listSize = 0;
	
	/*
	 * constructor
	 */
	public DateSet(){
		listOfDates = new ArrayList<Date>();
	}
	
	/**
	 * Method to add a date into a Date object
	 * @param date
	 */
	public void add(Date date){
		if(!(listOfDates.contains(date))){
			listOfDates.add(date);
			listSize+=1;
		}
	}
	
	public List<Date> printList(){
		return this.listOfDates;
	}
	
	/**
	 * Check if a Date object has a certain date inside
	 * 
	 * @param date
	 * @return boolean true or false
	 */
	public boolean contains(Date date){
		if(listOfDates.contains(date)){
			return true;
		}
		return false;
	}
	
	public String toString() {
		// TODO: fix
		String start = "ListOfDates<";
		String end = ">";
		String res = null;
		int counter = 0;
		
		while(counter < listOfDates.size()) {
			res = res + listOfDates.get(counter) + ",";
		}
		
		return start + res + end;
	}
	
	/**
	 * Method to combine (intersect) dates contained in 2 date objects. 
	 * 
	 * @param other
	 * @return list of all dates from both objects
	 */
	public DateSet intersection(DateSet other){
		DateSet combined = new DateSet();
		
		for (int pos = 0; pos < this.listOfDates.size(); pos++) {
			combined.add(this.listOfDates.get(pos));
		}
		
		for (int pos = 0; pos < other.listOfDates.size(); pos++) {
			combined.add(other.listOfDates.get(pos));
		}

		return combined;
	}
	
}
