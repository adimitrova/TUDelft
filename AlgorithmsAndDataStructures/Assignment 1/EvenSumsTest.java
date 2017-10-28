import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.*;
public class EvenSumsTest {

	EvenSums sum = new EvenSums();

	@Test
	public void testForM1() {
		assertEquals(0, EvenSums.sumEvenFor(-1));
	}

	@Test
	public void testWhileM1() {
		assertEquals(0, EvenSums.sumEvenWhile(-1));
	}

	@Test
	public void testRecM1() {
		assertEquals(0, sum.sumEvenRec(-1));
	}

	@Test
	public void testFor2() {
		assertEquals(2, EvenSums.sumEvenFor(2));
	}

	@Test
	public void testWhile2() {
		assertEquals(2, EvenSums.sumEvenWhile(2));
	}

	@Test
	public void testRec2() {
		assertEquals(2, sum.sumEvenRec(2));
	}

	@Test
	public void testFor6() {
		assertEquals(12, EvenSums.sumEvenFor(6));
	}

	@Test
	public void testWhile6() {
		assertEquals(12, EvenSums.sumEvenWhile(6));
	}
	
	@Test
	public void testRec6() {
		assertEquals(12, sum.sumEvenRec(6));
	}
	
	@Test
	public void testRec15() {
		assertEquals(56, sum.sumEvenRec(15));
	}
	
	@Test
	public void testRec5() {
		assertEquals(6, sum.sumEvenRec(5));
	}
}//
