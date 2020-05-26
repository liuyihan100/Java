package code1;

public class Machine {
	int price = 80;
	int balance;
	int total;
	
	void showPrompt()
	{
		System.out.println("Welcome");
	}
	
	void insertMoney(int amount)
	{
		balance = balance + amount;
	}
	
	void showBalance()
	{
		System.out.println(balance);
	}
	
	void getFood()
	{
		if(balance >= price)
		{
			System.out.println("Here you are");
			balance = balance - price;
			total = total + price;
		}
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Machine vm = new Machine();
		vm.showPrompt();
		vm.insertMoney(100);
		vm.getFood();
		vm.showBalance();
	}

}