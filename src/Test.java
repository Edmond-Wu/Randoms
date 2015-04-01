
public class Test 
{
	public static void main(String[] args) 
	{
		String friend = "sam|y|rutgers";
		String name = friend.substring(0, friend.indexOf('|'));
		friend = friend.substring(friend.indexOf('|') + 1);
		String school = friend.substring(friend.indexOf('|') + 1);
		System.out.println(name + " " + school);
		
		String friendship = "sam|jane";
		String friend1 = friendship.substring(0, friendship.indexOf('|'));
		String friend2 = friendship.substring(friendship.indexOf('|') + 1);
		System.out.println(friend1 + ", " + friend2);
	}
}
