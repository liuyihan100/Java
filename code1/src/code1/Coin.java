package code1;

import java.util.HashMap;
import java.util.Scanner;

public class Coin {
	private HashMap<Integer, String> coinnames = new HashMap<Integer, String>();
	
	public Coin() {
		coinnames.put(1, "penny");
		coinnames.put(10, "dime");
		coinnames.put(25, "quarter");
		coinnames.put(50, "half-dollar");
	}
	
	public String getName(int amount) {
		if(coinnames.containsKey(amount))
			return coinnames.get(amount);
		else
			return "NOT FOUND";
	}
	
	public void list() {
		for(int k : coinnames.keySet()) {
			String s = coinnames.get(k);
			System.out.println(s);
		}
		System.out.println(coinnames);
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in);
		Coin coin = new Coin();
		coin.list();
		int amount = in.nextInt();
		String s = coin.getName(amount);
		System.out.println(s);
		in.close();
	}

}