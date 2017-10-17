import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UTest {

	@Test
	public void testHelloWord() {
		assertEquals(3, Solution.countVowels("Hello World!"));
	}
	
  @Test
	public void testNumber() {
		assertEquals(0, Solution.countVowels("42"));
	}
	
  @Test
	public void testAnswer() {
		assertEquals(2, Solution.countVowels("forthytwo"));
	}
	
	
  @Test
	public void testAerospace() {
		assertEquals(5, Solution.countVowels("aerospace"));
	}
		
}//
