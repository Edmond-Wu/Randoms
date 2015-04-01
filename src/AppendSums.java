import java.util.ArrayList;

public class AppendSums 
{
	public static void main(String[] args) 
	{
		ArrayList<Integer> sumThree = new ArrayList<Integer>();
		sumThree.add(0);
		sumThree.add(1);
		sumThree.add(2);
		appendSums(sumThree);
		System.out.println(sumThree.get(10));
		System.out.println(sumThree.get(20));
	}
	
	public static void appendSums(ArrayList<Integer> list)
	{
		for (int i = 0; i < 25; i++)
		{
			int appended = list.get(list.size() - 1) + list.get(list.size() - 2) + list.get(list.size() - 3);
			list.add(appended);
		}
	}
}
