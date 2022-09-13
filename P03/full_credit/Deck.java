import java.util.Stack;
import java.util.*;

public class Deck{

	private Stack<Card> deck;

	public Deck (){
		deck = new Stack<Card>();
		for(Suit i : Suit.values())
		{
			for(int j = 0 ; j < 10  ; j++)
			{
				deck.push(new Card (new Rank(j),i));
			}
		}
		Shuffle(deck);
	}


 //@Override
 public static void Shuffle(Stack<Card> deck)
 {
 	Collections.shuffle(deck);
 }
 public Card deal(){
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
 public boolean isEmpty()
 {
 	return deck.empty();
 }
}