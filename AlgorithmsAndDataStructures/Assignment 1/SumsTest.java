import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UTest {


	@Test
	public void testForM1() {
		assertEquals(0, Solution.sumFor(-1));
	}

	@Test
	public void testWhileM1() {
		assertEquals(0, Solution.sumWhile(-1));
	}

	@Test
	public void testRecM1() {
		assertEquals(0, Solution.sumRec(-1));
	}

	@Test
	public void testFor2() {
		assertEquals(3, Solution.sumFor(2));
	}

	@Test
	public void testWhile2() {
		assertEquals(3, Solution.sumWhile(2));
	}

	@Test
	public void testRec2() {
		assertEquals(3, Solution.sumRec(2));
	}

	@Test
	public void testFor4() {
		assertEquals(10, Solution.sumFor(4));
	}

	@Test
	public void testWhile4() {
		assertEquals(10, Solution.sumWhile(4));
	}
	
	@Test
	public void testRec4() {
		assertEquals(10, Solution.sumRec(4));
	}
}//
