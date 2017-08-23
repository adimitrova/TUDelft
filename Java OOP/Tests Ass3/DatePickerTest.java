import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DatePickerTest {

	DatePicker personList = new DatePicker();
	Person ani = new Person("Anelia");
	Date aniBday = new Date("26.02.1990");

	Person pesho = new Person("Pesho");
	Date peshoBday = new Date("29.05.1996");
	Date peshoGraduation = new Date("23.05.2016");
	
	@Test
	public void test_addPerson() {
		ani.addDate(aniBday);
		personList.addPerson(ani);
		int expected = 1;
		int actual = personList.people.size();
		double delta = 0.01;
		
		assertEquals("Assert that the add() method works", expected, actual, delta);
	}

	@Test
	public void test_commonDates(){
		personList.addPerson(ani);
		personList.addPerson(pesho);
		ani.addDate(aniBday);
		pesho.addDate(peshoBday);
		
		String expected = "ListOfDates <26.02.1990, 29.05.1996> ";
		String actual = personList.commonDates().toString();
		
		assertEquals("Assert common dates are working", expected, actual);
	}
	
	@Test
	public void test_toString(){
		personList.addPerson(pesho);
		personList.addPerson(ani);
		ani.addDate(peshoBday);
		pesho.addDate(peshoBday);
		pesho.addDate(peshoGraduation);
		
		String expected = "All People's Dates [ListOfDates <29.05.1996, 23.05.2016> ]";
		String actual = personList.toString();
		
		assertEquals("Assert common dates are working", expected, actual);
	}
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void test_lessThanTwoObjects(){
		// test illegalargumentexception will pop out if there are less than 2
		// objects in the list
		personList.addPerson(ani);
		expectedException.expect(IllegalArgumentException.class);
		personList.commonDates();
	}
}
