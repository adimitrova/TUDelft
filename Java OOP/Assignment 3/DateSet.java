/**
 * Class representing a list/set, containing multiple Dates
 * @author Anelia Dimitrova
 * @version 2
 * @date last (updated/modified) on: 12/07/17
 * @date finished: 
 */

import java.util.*;

public class DateSet {

	// ------------------- MAIN METHOD -----------------
	public static void main(String[] args) {
		DateSet list1 = new DateSet();
		DateSet list2 = new DateSet();
		DateSet list3 = new DateSet();
		Date date1 = new Date("17-05-17");
		Date date2 = new Date("18-05-17");
		Date date3 = new Date("13-07-17");
	
		list1.add(date1);
		list1.add(date3);
		list2.add(date2);
		list2.add(date3);		
		list3.add(date2);
		list3.add(date3);
		
		//System.out.println(list1.contains(date1));
		//System.out.println(list2.contains(date1));
		
		System.out.println("List 1 contains " + date2 + "? " + list1.contains(date2));
		System.out.println("List 1 contains " + date1 + "? " + list1.contains(date1));
		System.out.println("List 1: " + list1.toString());
		System.out.println("List 2: " + list2.toString());
		System.out.println("Intersection: " + list1.intersection(list2));
		System.out.println("List 1 & 3 the same: " + list1.equals(list3));
		System.out.println(list1.printList());
		
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
			listSize += 1;
		}
	}
	
	/**
	 * returns all the values in a list
	 * @return
	 */
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
	
	/**
	 * returns nice human-friendly representation of the List with the contained values
	 */
	public String toString() {
		String start = "ListOfDates <";
		String end = ">";
		String midResult = null;
		
		for (int counter = 0; counter < listOfDates.size(); counter++) {
			midResult = midResult + listOfDates.get(counter).toString() + ", ";
		} 
		
		/**
		 * remove the trailing comma as well as the leading "null" value 
		 * in front of the first Date object in the list 
		 */
		String datesFormatted = midResult.substring(4, midResult.lastIndexOf(","));
		return start + datesFormatted + end;
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
	
	/**
	 * returns a representation of the current List obj with Date objects in it
	 */
	@Override
	public boolean equals(Object other) {
		boolean equals = false;
		if(other instanceof DateSet) {
			DateSet second = (DateSet) other;
			// if sizes of the two arrays are the same, then we compare all the elements within the arrays
			// to compare all the elements, we use the List method containsAll()
			if(this.listOfDates.size() == second.listOfDates.size() && this.listOfDates.containsAll(second.listOfDates)) {
				equals = true;
			}
		}		
		return equals;
	}
		
}
