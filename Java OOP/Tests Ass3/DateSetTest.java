import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DateSetTest {
	DateSet list1 = new DateSet();
	DateSet list2 = new DateSet();
	DateSet list3 = new DateSet();
	Date date1 = new Date("17-05-17");
	Date date2 = new Date("18-05-17");
	Date date3 = new Date("30-11-17");	
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void test_CorrectDateIsAddedToList() {
		/**
		 * tests both .toString() and .add() methods
		 */
		String expected = "ListOfDates <17-05-17>";
		list1.add(date1);
		assertEquals("Assert the list contains the correct date", expected, list1.toString());
	}

	@Test
	public void test_intersection() {
		// test .intersection() method
		list1.add(date1);
		list3.add(date2);
		String actual = list1.intersection(list3).toString();  
		String expected = "ListOfDates <17-05-17, 18-05-17>";
		assertEquals("Assert intersection works", expected, actual);
	}
	
	@Test
	public void test_contains() {
		list1.add(date1);
		list1.add(date2);
		assertTrue("Assert the list contains a certain date", list1.contains(date2));
	}
	
	@Test
	public void test_equals() {
		list1.add(date1);
		list2.add(date1);
		assertTrue("Assert two lists are identical", list1.equals(list2));
	}
}











