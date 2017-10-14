import static org.junit.Assert.*;

import org.junit.Test;

public class HouseTest {

	Address adr1 = new Address("SomeStreet",100,"ABC","Delft");
	Address adr2 = new Address("SomeStreet",100,"ABC","Delft");
	Address adr3 = new Address("AnotherStreet",16,"1003","Sofia");
	Address adr4 = new Address("1",2,"3","4");
	
	House house1 = new House(adr1,3,117000);
	House house2 = new House(adr2,3,117000);
	
	@Test
	public void test_toString() {
		String expected = "House [Address <SomeStreet 100, ABC, Delft>, 3 room(s), €117000]";
		String actual = house1.toString();
		assertEquals(expected, actual);
		assertNotEquals("House [Address <1 2, 3, 4>, 3 room(s), €117000]", actual);
	}

	@Test
	public void test_equals() {
		assertTrue(house1.equals(house2));
	}
}
