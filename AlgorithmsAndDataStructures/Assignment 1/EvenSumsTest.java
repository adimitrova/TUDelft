import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UTest {


	@Test
	public void testForM1() {
		assertEquals(0, Solution.sumEvenFor(-1));
	}

	@Test
	public void testWhileM1() {
		assertEquals(0, Solution.sumEvenWhile(-1));
	}

	@Test
	public void testRecM1() {
		assertEquals(0, Solution.sumEvenRec(-1));
	}

	@Test
	public void testFor2() {
		assertEquals(2, Solution.sumEvenFor(2));
	}

	@Test
	public void testWhile2() {
		assertEquals(2, Solution.sumEvenWhile(2));
	}

	@Test
	public void testRec2() {
		assertEquals(2, Solution.sumEvenRec(2));
	}

	@Test
	public void testFor6() {
		assertEquals(12, Solution.sumEvenFor(6));
	}

	@Test
	public void testWhile6() {
		assertEquals(12, Solution.sumEvenWhile(6));
	}
	
	@Test
	public void testRec6() {
		assertEquals(12, Solution.sumEvenRec(6));
	}
}//
