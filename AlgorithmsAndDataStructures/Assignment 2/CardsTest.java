import static org.junit.Assert.*;

import org.junit.Test;

public class UTest {

	private static final Card fiveOfClubs     = new Card(Suit.Clubs, Rank.Five);
	private static final Card fiveOfDiamonds  = new Card(Suit.Diamonds, Rank.Five);
	private static final Card sevenOfClubs    = new Card(Suit.Clubs, Rank.Seven);
	private static final Card sevenOfDiamonds = new Card(Suit.Diamonds, Rank.Seven);
	
	@Test
	public void test5Clubs7Diamonds() {
		assertTrue(fiveOfClubs.compareTo(sevenOfDiamonds) < 0);
	}

	@Test
	public void test5Clubs5Diamonds() {
		assertTrue(fiveOfClubs.compareTo(fiveOfDiamonds) < 0);
	}

	@Test
	public void test7Clubs5Diamonds() {
		assertTrue(sevenOfClubs.compareTo(fiveOfDiamonds) < 0);
	}
	
	@Test
	public void test5Clubs7Clubs() {
		assertTrue(fiveOfClubs.compareTo(sevenOfClubs) < 0);
	}
	
	@Test
	public void test7Diamonds5Clubs() {
		assertTrue(sevenOfDiamonds.compareTo(fiveOfClubs) > 0);
	}

	@Test
	public void test5Diamonds5Clubs() {
		assertTrue(fiveOfDiamonds.compareTo(fiveOfClubs) > 0);
	}

	@Test
	public void test5Diamonds7Clubs() {
		assertTrue(fiveOfDiamonds.compareTo(sevenOfClubs) > 0);
	}
	
	@Test
	public void test7Clubs5Clubs() {
		assertTrue(sevenOfClubs.compareTo(fiveOfClubs) > 0);
	}
	
	@Test
	public void testSame() {
		assertEquals(0, sevenOfClubs.compareTo(sevenOfClubs));
	}
	
	@Test
	public void testEquals() {
		assertEquals(0, sevenOfClubs.compareTo(new Card(Suit.Clubs, Rank.Seven)));
	}
}
//
