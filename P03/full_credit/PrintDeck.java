import java.util.Stack;

public class PrintDeck{
	public static void main(String[] args) {
		Stack<Card> deck = new Stack<Card>();

		Deck.shuffle(deck);

		//Deck.printdeck(deck);
		for(Deck i: Deck.deck)
		{
			System.out.print(" " + deck);
		}

	}
}