import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Scanner;
import org.junit.Test;

public class AddressTest {
	
	Address adr1 = new Address("SomeStreet",100,"ABC","Delft");
	Address adr2 = new Address("SomeStreet",100,"ABC","Delft");
	Address adr3 = new Address("AnotherStreet",16,"1003","Sofia");
	
	@Test
	public void test_equals() {
		assertTrue(adr1.equals(adr2));
		assertFalse(adr1.equals(adr3));
	}
	
	@Test
	public void test_toString() {
		String expected = "Address <SomeStreet 100, ABC, Delft>";
		String actual = adr1.toString();
		
		assertEquals("Check if the toString() works as expected", expected, actual);
	}
	
	@Test
	public void test_read() throws IOException {
		Scanner readThis = new Scanner("AddressTest");
		Address actual = new Address("Molslaan", 16, "2932FV", "Delft");
		Address expected = Address.read(readThis);
		
		//assertTrue(expected.equals(actual));
		assertTrue(actual.equals(expected));
		//assertEquals("Check if the read() method returns the right object", expected, actual);
	}
}
