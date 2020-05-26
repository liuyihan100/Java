package hello;

import java.util.Scanner;

public class Amount2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int amount = 0;
		int balance = 0;
		while(true)
		{
			System.out.print("请投币：");
			Scanner in = new Scanner(System.in);
			amount = in.nextInt();
			balance += amount;
			if(balance >= 10)
			{
				System.out.println("*************************");
				System.out.println("*    Java城际铁路专线       *");
				System.out.println("*       无指定坐席            *");
				System.out.println("*        票价10元              *");
				System.out.println("*************************");
				System.out.println("找零：" + (balance - 10));
				balance = 0;
			}
		}
	}

}