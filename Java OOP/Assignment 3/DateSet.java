import java.util.*;

public class DateSet {

	public static void main(String[] args) {
		DateSet list1 = new DateSet();
		DateSet list2 = new DateSet();
		Date date1 = new Date("17-05-17");
		Date date2 = new Date("18-05-17");
		
		list1.add(date1);
		list2.add(date2);
		
		System.out.println(list1.toString());
		System.out.println(list2.toString());
		
		System.out.println(list1.intersection(list2));
		
	}
	
	private ArrayList<Date> listOfDates;
	
	public DateSet(){
		listOfDates = new ArrayList<Date>();
	}
	
	public void add(Date date){
		if(!(listOfDates.contains(date))){
			listOfDates.add(date);
		}
	}
	
	public boolean contains(Date date){
		if(listOfDates.contains(date)){
			return true;
		}
		return false;
	}
	
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
