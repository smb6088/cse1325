public class Card{

	private Rank rank;
	private Suit suit;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	//@Overrride
	public String toString(){
		return rank + "" + suit;
	}
}