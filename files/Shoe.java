import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

public class Shoe extends CardCollection{
	public Shoe(int numDecks) {
		ArrayList<Character> ranks=new ArrayList<Character>(Card.getRanks());
		ArrayList<Character> suits=new ArrayList<Character>(Card.getSuits());
		for(int k=0;k<numDecks;k++)
		{
			for(int i=0;i<ranks.size();i++)
				for(int j=0;j<suits.size();j++)
				{
					Card a=new Card(ranks.get(i),suits.get(j));
					super.add(a);
				}
		}
	}
	public Card deal() {
		return super.cards.remove(0);
	}
	public void shuffle() {
		Collections.shuffle(super.cards);
	}
}