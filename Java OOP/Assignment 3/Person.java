/**
 * Class to create a Person with name and dates (bday or other)
 * @author Ani
 * @version 13 Aug 2017
 */
import java.util.*;

public class Person {
	// class fields
	private String name;
	private DateSet dates;

	public Person(String nameIn) {
		name = nameIn;
		dates = new DateSet();
	}
	
	public String getName() {
		return name;
	}
	
	public DateSet getDates() {
		return dates;
	}
	
	public void addDate(Date dateIn) {
		if(!(dates.contains(dateIn))) {
			dates.add(dateIn);
		} else {
			// validate user input with IllegalArgumentException error
			throw new IllegalArgumentException("This date is already added.");
		}
	}
	
	public boolean equals(Person other) {
		boolean isEqual = false;
		if(other instanceof Person) {
			Person second = (Person) other;
			if(this.name == second.name && this.dates.equals(second.dates)){
				isEqual = true;
			}
		}		
		return isEqual;
	}

	public String toString() {
		String output = "Name: " + this.getName() + " Dates: " + this.getDates();
		return output;
	}
}
