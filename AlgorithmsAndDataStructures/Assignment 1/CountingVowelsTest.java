import static org.junit.Assert.assertEquals;
import org.junit.*;
import org.junit.Test;

public class CountingVowelsTest {

	@Test
	public void testHelloWord() {
		assertEquals(3, CountingVowels.countVowels("Hello World!"));
	}
	
  @Test
	public void testNumber() {
		assertEquals(0, CountingVowels.countVowels("42"));
	}
	
  @Test
	public void testAnswer() {
		assertEquals(2, CountingVowels.countVowels("forthytwo"));
	}
	
	
  @Test
	public void testAerospace() {
		assertEquals(5, CountingVowels.countVowels("aerospace"));
	}
		
}//
