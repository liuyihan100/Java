package hello;

import java.util.Scanner;

public class amount {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in);
		System.out.print("请投币：");
		int amount = in.nextInt();
		System.out.println(amount >= 10);
		System.out.println("*************************");
		System.out.println("*    Java城际铁路专线       *");
		System.out.println("*       无指定坐席            *");
		System.out.println("*        票价10元              *");
		System.out.println("*************************");
		System.out.println("找零：" + (amount - 10));
	}
}