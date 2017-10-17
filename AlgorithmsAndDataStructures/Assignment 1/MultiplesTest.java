import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class UTest {


	@Test
	public void test0and2() {
		assertTrue(Solution.isMultiple(0,2));
	}

	@Test
	public void test6and2() {
		assertTrue(Solution.isMultiple(6,2));
	}

	@Test
	public void test6and4() {
		assertFalse(Solution.isMultiple(6,4));
	}

	@Test
	public void test6andM2() {
		assertTrue(Solution.isMultiple(6,-2));
	}
}//
