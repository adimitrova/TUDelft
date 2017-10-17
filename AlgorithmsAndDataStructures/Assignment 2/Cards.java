enum Rank { Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King; }
enum Suit { Clubs, Diamonds, Hearts, Spades; }

class Card implements Comparable<Card> {

	private final Suit suit;
	private final Rank rank;
	
	public Card(Suit suit, Rank rank) {
	  
	}

	@Override
	public int compareTo(Card c) {
	
	}
}//
