import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DateTest {

	Date date1 = new Date("13-Jun-2017");
	Date date2 = new Date("13-Jun-2017");
	String exampleDateString = "13-Jun-2017";
	
	@Rule
    public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void equals_To_Same_True(){
		assertTrue("date1 and date2 are the same", date1.equals(date2));
	}
	
	@Test
	public void constructorTest(){
		// test if the constructor has set the object to its correct value
		// test also the toString() method together with that
		assertSame("Constructor sets the correct value", exampleDateString, date1.toString());
	}
}
