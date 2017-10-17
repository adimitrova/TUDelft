import static org.junit.Assert.*;
import org.junit.Test;

public class UTest {

	@Test
	public void testDrawFromEmptyDeck() {
		
		Deck deck = new Deck(0);
		try {
			deck.draw();
		} catch (Deck.EmptyDeckException e) {
			assertEquals(1, e.getNumberOfMissingCards());
			return;
		}		
		fail();
	}
	
	@Test
	public void testDrawFromSingleDeck() {

		Deck deck = new Deck(1);
		Card kingOfSpades = new Card(Suit.Spades, Rank.King);
		try {
			Card card = deck.draw();
			assertEquals(0, card.compareTo(kingOfSpades));
		} catch (Deck.EmptyDeckException e) {
			fail();
		}
	}
	
	@Test
	public void testAddAndDrawFromEmptyDeck() {

		Deck deck = new Deck(0);
		Card queenOfHearts = new Card(Suit.Hearts, Rank.Queen);

		deck.add(queenOfHearts);
		try {
			assertSame(queenOfHearts, deck.draw());
		} catch (Deck.EmptyDeckException e) {
			fail();
		}
	}
	
	@Test
	public void testAddAndDrawFromSingleDeck() {

		Deck deck = new Deck(1);
		Card queenOfHearts = new Card(Suit.Hearts, Rank.Queen);

		deck.add(queenOfHearts);
		try {
			assertSame(queenOfHearts, deck.draw());
		} catch (Deck.EmptyDeckException e) {
			fail();
		}
	}
	
	@Test
	public void testMoveNoneFromEmptyDeck() {

		Deck deck1 = new Deck(0);
		Deck deck2 = new Deck(0);
		
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
	public void testMoveNoneFromSingleDeck() {

		Deck deck1 = new Deck(1);
		Deck deck2 = new Deck(0);
		
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
		Deck deck2 = new Deck(0);
		
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
			assertSame(c2, deck2.draw());
			assertSame(c1, deck2.draw());
			
		} catch (Deck.EmptyDeckException e) {
			fail(); 
		}
	}
}
//
