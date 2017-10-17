import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Deck {

	public class EmptyDeckException extends Exception {
		private static final long serialVersionUID = 1L;
		private final int n;
		
		public EmptyDeckException(int n) {
			this.n = n;
		}
		
		public int getNumberOfMissingCards() {
			return n;
		}
	}
	
	protected final List<Card> cards = new ArrayList<>();
	
	/**
	 * constructs a new deck with each possible card
	 * 
	 * @param n each possible card will be n times in the new deck
	 */
	public Deck(int n) {
	}
	
	/**
	 * adds a card to the current deck
	 * 
	 * @param c card to add to the top of the deck
	 */
	public void add(Card c) {
	
	}
	
	/**
	 * draws a card from the current deck
	 * 
	 * @return card from the top of the deck
	 * @throws EmptyDeckException when the deck is empty and no card can be drawn
	 */
	public Card draw() throws EmptyDeckException {
		
	}

	/**
	 * moves cards one by one from the current deck to the target deck
	 * 
	 * @param d target deck
	 * @param n number of cards which should be moved
	 * @throws EmptyDeckException when no more cards can be moved because the deck is empty
	 */
	public void move(Deck d, int n) throws EmptyDeckException {
		
	}

	/**
	 * shuffles the cards in the deck
	 */
	public void shuffle() {
		
	}
	
	/**
	 * sorts the cards in the deck
	 */
	public void sort() {
		
	}
}
//
