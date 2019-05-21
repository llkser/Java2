public class BaccaratCard extends Card
{
	public BaccaratCard(char rank, char suit) {
		super(rank,suit);
	}
	public BaccaratCard(String code) {
		super(code);
	}
	public int value() {
	    return super.value()%10;
	}
}