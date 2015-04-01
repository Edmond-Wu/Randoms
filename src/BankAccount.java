
public class BankAccount 
{
	private double balance;
	private double fees;
	private String name;
	
	public BankAccount(String n, double b)
	{
		balance = b;
		name = n;
		fees = 0;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public double getFees()
	{
		return fees;
	}
	
	public void deposit(double amt)
	{
		balance += amt;
	}
	
	public void withdraw(double amt)
	{
		if (balance >= amt)
		{
			balance -= amt;
		}
		else
		{
			balance -= (amt + 5);
			fees += 5;
		}
	}
	
	public static void main(String[] args)
	{
		BankAccount my_account = new BankAccount("Edmond", 10);
		my_account.withdraw(5);
		my_account.deposit(10);
		my_account.withdraw(5);
		my_account.withdraw(15);
		my_account.deposit(20);
		my_account.withdraw(5);
		my_account.deposit(10);
		my_account.deposit(20);
		my_account.withdraw(15);
		my_account.deposit(30);
		my_account.withdraw(10);
		my_account.withdraw(15);
		my_account.deposit(10);
		my_account.withdraw(50); 
		my_account.deposit(30);
		my_account.withdraw(15);
		my_account.deposit(10);
		my_account.withdraw(5);
		my_account.deposit(20);
		my_account.withdraw(15);
		my_account.deposit(10);
		my_account.deposit(30);
		my_account.withdraw(25); 
		my_account.withdraw(5);
		my_account.deposit(10);
		my_account.withdraw(15);
		my_account.deposit(10);
		my_account.withdraw(10); 
		my_account.withdraw(15);
		my_account.deposit(10);
		my_account.deposit(30);
		my_account.withdraw(25); 
		my_account.withdraw(10);
		my_account.deposit(20);
		my_account.deposit(10);
		my_account.withdraw(5);
		my_account.withdraw(15);
		my_account.deposit(10);
		my_account.withdraw(5);
		my_account.withdraw(15);
		my_account.deposit(10);
		my_account.withdraw(5);
		
		System.out.println(my_account.getBalance() + " " + my_account.getFees());
	}
}
