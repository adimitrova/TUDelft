import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainA2 {

	public static void main(String[] args) {
		// testing StringList' methods
		
		/*
		StringList one = new StringList(1);
        StringList other = new StringList(1);
        one.add("mimi");
        other.add("maimi");
        System.out.println(one.equals(other));
        
        StringList list = new StringList(3);
        list.add("String 1");
        list.add("String 1");
        System.out.println(list.contains("String 1"));
        */
		
		StringList list = new StringList(3);
        list.add("String 1");
        System.out.println(list.contains("String 1"));
		
		/*
		StringList List1 = new StringList(4);
		StringList List2 = new StringList(4);
		StringList List3 = new StringList(8);
		
		System.out.println("Initial Size: " + List1.getSize());
		
		List1.add("Ani");
		List1.add("Desi");
		List1.add("Boriana");
		List1.add("Ioana");
		
		List2.add("Ani");
		List2.add("Desi");
		List2.add("Boriana");
		List2.add("Ioana");
		
		List3.add("Ani");
		List3.add("Desi");
		List3.add("Boriana");
		List3.add("Roni");
		List3.add("Ioana");
		List3.add("Sherlock");

		System.out.println("Size List1: " + List1.getSize());
		System.out.println("Size List2: " + List1.getSize());
		System.out.println("Size List3: " + List1.getSize());
		
		System.out.println();
		System.out.println("List 1: " + List1.toString());
		System.out.println("List 2: " + List2.toString());
		System.out.println("List 3: " + List3.toString());
		
		System.out.println();
		System.out.println("Return the index of String \"Desi\" in List1: " + List1.index("Desi")); 
		System.out.println("Return the index of String \"Ani\" in List2: " + List2.index("Ani")); 
		System.out.println("Return the index of String \"Roni\" in List1: " + List1.index("Roni")); 
		System.out.println("Return the index of String \"Ioana\" in List3: " + List3.index("Ioana")); 
		System.out.println("Return the index of String \"Ioana\" in List2: " + List2.index("Ioana")); 
		
		System.out.println("List1 = List2: " + List1.equals(List2));
		System.out.println("List1 = List3: " + List1.equals(List3));
		System.out.println("List2 = List3: " + List2.equals(List3));
		
		System.out.println();
		List3.set(3, "Mimi");
		System.out.println("List 3: " + List3.toString());
		
		System.out.println();
		System.out.println("Does list 3 contain \"Mimi\"? " + List3.contains("Mimi"));
		System.out.println("Does list 2 contain \"Mimi\"? " + List2.contains("Mimi"));
		
		System.out.println();
		System.out.println("Size of List 2 (returns amount of actual values and not size of the list): " + List3.getSize());
		System.out.println("Position of \"Sherlock\" in List 2: " + List2.index("Sherlock") + " (does not exist)");
		System.out.println("Position of \"Sherlock\" in List 3: " + List3.index("Sherlock"));
		*/
	}
}


/*
 * --------- OUTPUT -----------
	Initial Size: 0
	Size List1: 4
	Size List2: 4
	Size List3: 4  			WRONG (think it's old output as it shows on the screen too, FIX!)
	
	List 1: <StringList[Ani,Desi,Boriana,Ioana]>
	List 2: <StringList[Ani,Desi,Boriana,Ioana]>
	List 3: <StringList[Ani,Desi,Boriana,Roni,Ioana,Sherlock,null,null]>
	
	Return the index of String "Desi" in List1: 1
	Return the index of String "Ani" in List2: 0
	Return the index of String "Roni" in List1: -1
	Return the index of String "Ioana" in List3: 4
	Return the index of String "Ioana" in List2: 3
	List1 = List2: true
	List1 = List3: false
	List2 = List3: false
	
	List 3: <StringList[Ani,Desi,Boriana,Mimi,Ioana,Sherlock,null,null]>
	
	Does list 3 contain "Mimi"? true
	Does list 2 contain "Mimi"? false
	
	Size of List 2 (returns amount of actual values and not size of the list): 6
	Position of "Sherlock" in List 2: -1 (does not exist)
	Position of "Sherlock" in List 3: 5
 */
