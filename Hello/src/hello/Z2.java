package hello;

import java.util.Scanner;

public class Z2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int number;
		int sum = 0;
		int count = 0;
		Scanner in = new Scanner(System.in);
		do {
			number = in.nextInt();
			if(number != -1) {
				sum += number;
				count ++;
			}
		}while(number != -1);
		if(count != 0)
				System.out.println("avg="+(double)sum/count);
	}

}