import java.util.Stack;
import java.util.Collections;

public class Deck{

	public Stack<Card> deck;

	public Deck (Stack<Card> deck){
		this.deck = deck;
		for(Suit i : Suit.values())
		{
			for(int j = 0 ; j < 10  ; j++)
			{
				deck.push(new Card (new Rank(j),i));
			}
		}
	}


 //@Override
 public static void shuffle(Stack<Card> deck)
 {
 	Collections.shuffle(deck);
 }
 public Card deal(Stack<Card> deck){
 	if(deck.empty() == true)
 	{
 		try{
 			System.out.println("The deck is empty" );

 		}catch (Exception e){
 			System.err.println(e.getMessage());
 			System.exit(-1);
 		}
 	}
 	return deck.pop();
 }
 public boolean isEmpty(Stack<Card> deck)
 {
 	return deck.empty();
 }
}