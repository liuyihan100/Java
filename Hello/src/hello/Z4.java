package hello;

import java.util.Scanner;

public class Z4 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in);
		int number[] = new int[100];
		int cnt = 0;
		double sum = 0;
		number[cnt] = in.nextInt();
		while(number[cnt] != -1)
		{
			sum += number[cnt];
			cnt ++;
			number[cnt] = in.nextInt();
		}
		double avg = sum / number.length;
		for(int i = 0;i < number.length;i++)
		{
			if(number[i] > avg)
				System.out.println(number[i]);
		}
		System.out.print(avg);
	}

}