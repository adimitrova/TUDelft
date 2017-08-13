import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {
	// TODO Auto-generated method stub
	Person ani = new Person("Anelia");
	Date aniBday = new Date("26.02.1990");
	Date graduationDay = new Date("25.01.2018");
//	ani.addDate(aniBday);
//	//ani.addDate(graduationDay);
//	
	Person anelia = new Person("Anelia");
	Date aneliaBday = new Date("26.02.1990");
//	anelia.addDate(aneliaBday);
//	
//	System.out.println(ani.getName() + " " + anelia.getName());
//	System.out.println(ani.getDates() + " " + anelia.getDates());
//	System.out.println(ani.equals(anelia));
//	System.out.println(ani);
	
	
	@Test
	public void test_equalObjects() {
		ani.addDate(aniBday);
		anelia.addDate(aneliaBday);
		assertTrue("two people are the same if all values are the same",ani.equals(anelia));
	}
	
	@Test
	public void test_addingDate() {
		/** test .addDate() and .getDates() at once
		 * If .addDate() doesn't work there's no way that .getDates() would return the right value
		 * if .getDates() doesn't work, the whole test will fail
		 * => both methods tested
		 */
		ani.addDate(aniBday);
		String expected = "ListOfDates <26.02.1990>";
		String actual =  ani.getDates().toString();
		assertEquals("Test adding a Date obj actually does the job correctly", expected, actual);
	}
	
	@Test
	public void test_toString() {
		ani.addDate(aniBday);
		String expected = "Name: Anelia Dates: ListOfDates <26.02.1990>";
		String actual = ani.toString();
		
		assertEquals("toString returns correct value", expected, actual);
	}
	
	@Test
	public void test_getName() {
		String expected = "Anelia";
		String actual = ani.getName();
		assertEquals("Assert getName() returns correct value", expected, actual);
	}
}
