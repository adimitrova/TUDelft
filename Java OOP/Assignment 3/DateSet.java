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
		Date date3 = new Date("30-11-17");
		
		list1.add(date1);
		list1.add(date2);
		list2.add(date1);
		list2.add(date3);
		list3.add(date1);
		list3.add(date2);
		
		//System.out.println(list1.contains(date1));
		//System.out.println(list2.contains(date1));
		
		System.out.println("List 1: " + list1.toString());
		System.out.println("List 2: " + list2.toString());
		System.out.println("List 3: " + list3.toString());
		System.out.println("List 2 contains " + date1 + ": " + list2.contains(date1));
		System.out.println("List 2 contains " + date2 + ": " + list2.contains(date2));
		System.out.println("List 1 and List 3 combined: " + list1.intersection(list2));
		System.out.println("List 1 = List 3: " + list1.equals(list3));
		System.out.println("List 1 = List 2: " + list1.equals(list2));
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
	 * returns the Date objects which a List contains
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
	 * compare 2 DateSet Lists and return if they are equal or not
	 * @param second list to compare with
	 */
	public boolean equals(Object other) {
		boolean equal = false;
		if(other instanceof DateSet) {
			DateSet second = (DateSet) other;
			// if the sizes of the lists are equal, we check if also the Dates they contain are the same
			if(this.listOfDates.size() == second.listOfDates.size() && this.listOfDates.containsAll(second.listOfDates)) {
				equal = true;
			}
		}
		return equal;
	}
	
}
