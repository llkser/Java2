import java.util.Scanner;

public class Game extends Shoe
{
	public Game(int numDecks) {
		super(numDecks);
		super.shuffle();
	}
	public static void main(String[] args) {
		/* 3.1.1 test1
		BaccaratCard a=new BaccaratCard("AD");
		BaccaratCard b=new BaccaratCard('8','H');
		BaccaratCard c=new BaccaratCard("JS");
		System.out.printf("a=%d,b=%d,c=%d\n",a.value(),b.value(),c.value());
		*/
		
		/* 3.1.2 test2
		Hand ob1=new Hand();
		System.out.println("Input1:");
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		BaccaratCard ob2=new BaccaratCard(str);
		System.out.println("Input2:");
		str=sc.next();
		BaccaratCard ob3=new BaccaratCard(str);
		ob1.add(ob2);
		ob1.add(ob3);
		System.out.printf("Hand has %s. ", ob1.toString());
		System.out.printf("Hand's value = %d.\n", ob1.value());
		if(ob1.value()>=6)
			System.out.println("No more cards for player.");
		else {
			System.out.println("Input3:");
			str=sc.next();
			BaccaratCard ob4=new BaccaratCard(str);
			ob1.add(ob4);
			System.out.printf("Hand has %s. ", ob1.toString());
			System.out.printf("Hand's value = %d.\n", ob1.value());
		}
		*/
		
		/* 3.3.1 A test for function play()
		Scanner sc=new Scanner(System.in);
		System.out.println("Input a deck number:");
		int numDecks=sc.nextInt();
		Game newGame=new Game(numDecks);
		newGame.play();
		*/
		
		/* 3.3.2 A test for function playWithPrompt()
		Scanner sc=new Scanner(System.in);
		System.out.println("Input a deck number:");
		int numDecks=sc.nextInt();
		Game newGame=new Game(numDecks);
		newGame.playWithPrompt();
		*/
	}
	public int playRound() {
		Hand player=new Hand();
		Hand banker=new Hand();
		if(super.cards.size()<6)
			return -1;
		else {
			player.add(super.deal());
			player.add(super.deal());
			System.out.printf("Player: %s = %d\n", player.toString(),player.value());
			banker.add(super.deal());
			banker.add(super.deal());
			System.out.printf("Banker: %s = %d\n", banker.toString(),banker.value());
			if(player.value()<8&&banker.value()<8)
			{
				if(player.value()>=6)
				{
					if(banker.value()<6)
					{
						Card a=super.deal();
						banker.add(a);
						System.out.printf("Dealing third card to banker: %s\n",a.toString());
						System.out.printf("Player: %s = %d\n", player.toString(),player.value());
						System.out.printf("Banker: %s = %d\n", banker.toString(),banker.value());
					}
				}
				else {
					Card b=super.deal();
					player.add(b);
					System.out.printf("Dealing third card to player: %s\n",b.toString());
					switch (banker.value()) {
					case 7:	break;
					case 6:
						if(b.getRank()==6||b.getRank()==7)
						{
							b=super.deal();
							banker.add(b);
							System.out.printf("Dealing third card to banker: %s\n",b.toString());
						}
						break;
					case 5:
						if(b.getRank()<=7&&b.getRank()>=4)
						{
							b=super.deal();
							banker.add(b);
							System.out.printf("Dealing third card to banker: %s\n",b.toString());
						}
						break;
					case 4:
						if(b.getRank()<=7&&b.getRank()>=2)
						{
							b=super.deal();
							banker.add(b);
							System.out.printf("Dealing third card to banker: %s\n",b.toString());
						}
						break;
					case 3:
						if(b.getRank()!=8)
						{
							b=super.deal();
							banker.add(b);
							System.out.printf("Dealing third card to banker: %s\n",b.toString());
						}
						break;
					default:
						b=super.deal();
						banker.add(b);
						System.out.printf("Dealing third card to banker: %s\n",b.toString());
						break;
					}
					System.out.printf("Player: %s = %d\n", player.toString(),player.value());
					System.out.printf("Banker: %s = %d\n", banker.toString(),banker.value());
				}
			}
			if(player.value()>banker.value()){
				System.out.println("Player wins!");
				return 1;
			}
			else if(player.value()<banker.value())
			{
				System.out.println("Banker wins!");
				return 2;
			}
			else {
				System.out.println("Tie!");
				return 0;
			}
		}
	}
	public void play() {
		int a,b,c,j;
		int i=1;
		a=b=c=0;
		do{
			System.out.printf("Round %d:\n",i);
			j=this.playRound();
			i++;
			if(j==-1)
			{
				System.out.println("No enough cards in shoe! Game end!\n");
				break;
			}
			else if(j==0)
				c++;
			else if(j==1)
				a++;
			else 
				b++;
			System.out.println();
		}while(true);
		System.out.printf("%d rounds played\n",i);
		System.out.printf("%d player wins\n",a);
		System.out.printf("%d banker wins\n",b);
		System.out.printf("%d tie\n",c);
	}
	public void playWithPrompt() {
		int i,j,a,b,c;
		String flag;
		Scanner sc=new Scanner(System.in);
		i=1;
		a=b=c=0;
		while(true)
		{
			System.out.printf("Round %d:\n",i);
			j=this.playRound();
			if(j==-1)
			{
				System.out.println("No enough cards in shoe! Game end!\n");
				break;
			}
			else if(j==0)
				c++;
			else if(j==1)
				a++;
			else 
				b++;
			System.out.println("Another round? (y/n):");
			flag=sc.next();
			if(flag.equals("n"))
				break;
			i++;
		}
		System.out.printf("%d rounds played\n",i);
		System.out.printf("%d player wins\n",a);
		System.out.printf("%d banker wins\n",b);
		System.out.printf("%d tie\n",c);
	}
}




