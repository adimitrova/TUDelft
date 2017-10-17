import org.junit.*;
import static org.junit.Assert.*;

public class UTest {
  
  	@Test
	public void testDrawFromEmptyHand() {
		
		Deck deck = new Hand();
		try {
			deck.draw();
		} catch (Deck.EmptyDeckException e) {
			assertEquals(1, e.getNumberOfMissingCards());
			return;
		}		
		fail();
	}
	
	@Test
	public void testAddAndDrawFromEmptyHand() {

		Deck deck = new Hand();
		Card queenOfHearts = new Card(Suit.Hearts, Rank.Queen);

		deck.add(queenOfHearts);
		try {
			assertSame(queenOfHearts, deck.draw());
		} catch (Deck.EmptyDeckException e) {
			fail();
		}
	}
	
	@Test
	public void testMoveNoneBetweenHands() {

		Deck deck1 = new Hand();
		Deck deck2 = new Hand();
		
		try {
			deck1.move(deck2, 0);					
		} catch (Deck.EmptyDeckException e) {
			fail(); // moving zero cards should not throw an exception
		}
		try {
			deck2.draw();					
		} catch (Deck.EmptyDeckException e) {
			assertEquals(1, e.getNumberOfMissingCards());
		}
	}
	
	@Test
	public void testDrawAddMoveDraw() {

		Deck deck1 = new Deck(1);
		Deck deck2 = new Hand();
		
		try {
			// draw two cards
			Card c1 = deck1.draw();
			Card c2 = deck1.draw();
			
			// put them back
			deck1.add(c2);
			deck1.add(c1);
			
			// move two cards to other deck
			deck1.move(deck2, 2);
			
			// draw cards from other deck
			Card d1 = deck2.draw();
			Card d2 = deck2.draw();
			assertTrue((d1 == c1 && d2 == c2) || (d1 == c2 && d2 == c1));
		} catch (Deck.EmptyDeckException e) {
			fail(); 
		}
	}
}
//
