import java.util.*;

public class DatePicker {
	public static void main(String[] args) {
		DatePicker personList = new DatePicker();
		Person ani = new Person("Anelia");
		Date aniBday = new Date("26.02.1990");
		ani.addDate(aniBday);
		personList.addPerson(ani);

		Person pesho = new Person("Pesho");
		Date peshoBday = new Date("29.05.1996");
		Date peshoGraduation = new Date("23.05.2016");
		pesho.addDate(peshoBday);
		//pesho.addDate(peshoGraduation);
		personList.addPerson(pesho);
		
		System.out.println(personList.getPerson(1));
		System.out.println(personList.commonDates());
		System.out.println(personList.toString());
	}
	
	List<Person> people;
		
	/**
	 * constructor
	 */
	public DatePicker() {
		people = new ArrayList<Person>();
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
	 * Returns person obj at given index 
	 * 
	 * @param indexIn
	 * @return
	 */
	public Person getPerson(int indexIn){
		return people.get(indexIn);
	}
	
	/**
	 * get the listOfPeople
	 * for each PERSON in listOfPeople 
	 * access its DateSet listOfDates and get EACH Date
	 * maybe use DateSet.intersection() or DateSet.printList()?
	 */
	public DateSet commonDates() {
		DateSet listOfAllDates = new DateSet();
		
		// TODO: fix
		
		if(people.size() >= 2) {
			for (int personIndex = 0; personIndex < people.size(); personIndex++) {  	// loop over the list of people
				listOfAllDates = listOfAllDates.intersection(people.get(personIndex).getDates());
			}
		} else {
			throw new IllegalArgumentException("Less than 2 objects in the list");
		}
		return listOfAllDates;
	}
	
	/**
	 * Returns friendly representation of all dates in the set
	 */
	public String toString(){
		String res = "All People's Dates [";
		DateSet toString = new DateSet();
		toString = commonDates();
		
		return res = res + toString + "]";
	}
}
