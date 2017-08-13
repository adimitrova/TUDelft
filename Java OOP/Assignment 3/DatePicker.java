import java.util.*;

public class DatePicker {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatePicker personList = new DatePicker();
		Person ani = new Person("Anelia");
		Date aniBday = new Date("26.02.1990");
		ani.addDate(aniBday);
		personList.addPerson(ani);
		//personList.addPerson(ani);
		
		
	}
	
	
	List<Person> people;
		
	/**
	 * constructor
	 */
	public DatePicker() {
		people = new ArrayList<>();
	}
	
	/**
	 * Adding new person into the list
	 * @param personIn
	 */
	public void addPerson(Person personIn) {
		if(!(this.people.contains(personIn))) {
			people.add(personIn);
		} else {
			throw new IllegalArgumentException("Person already in");
		}
	}
	
	/**
	 * get the listOfPeople
	 * for each PERSON in listOfPeople 
	 * access its DateSet listOfDates and get EACH Date
	 * maybe use DateSet.intersection() or DateSet.printList()?
	 */
	public DateSet commonDates() {
		DateSet listOfAllDates = new DateSet();
		
		// TODO: finish (not sure how)
		
		if(people.size() >= 2) {
			for (int personIndex = 0; personIndex < people.size(); personIndex++) {  	// loop over the list of people
				DateSet tempSet = people.get(personIndex).getDates();
				listOfAllDates = listOfAllDates.add(tempSet.getDates());
			}
		}
		return listOfAllDates;
	}
}
