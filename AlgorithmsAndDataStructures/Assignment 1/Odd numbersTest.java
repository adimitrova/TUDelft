import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class UTest {


	@Test
	public void test2() {
		assertFalse(Solution.isOdd(2));
	}

	@Test
	public void testM2() {
		assertFalse(Solution.isOdd(-2));
	}

	@Test
	public void test0() {
		assertFalse(Solution.isOdd(0));
	}

	@Test
	public void test1() {
		assertTrue(Solution.isOdd(1));
	}

	@Test
	public void test3() {
		assertTrue(Solution.isOdd(3));
	}

	@Test
	public void testM3() {
		assertTrue(Solution.isOdd(-3));
	}
}//
