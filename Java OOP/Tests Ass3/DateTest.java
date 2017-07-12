import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DateTest {

	@Rule
    public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void equals_To_Same_True(){
		Date date1 = new Date("13-Jun-2017");
		Date date2 = new Date("13-Jun-2017");
		assertTrue("date1 and date2 are the same", date1.equals(date2));
	}

}
