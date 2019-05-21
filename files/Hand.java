public class Hand extends CardCollection
{
	public String toString() {
		String str="";
		if(!super.isEmpty())
		{
			str+=cards.get(0).toString();
			for(int i=1;i<super.size();i++)
			{
				str+=" ";
				str+=cards.get(i).toString();
			}
			return str;
		}
		else
			return "";
	}
	public int value(){
		if(!super.isEmpty())
		{
			int flag=0;
			for(int i=0;i<super.size();i++)
				flag+=cards.get(i).value();
			return flag%10;
		}
		else
			return 0;
	}
}