package code1;

import java.util.Scanner;

public class Exception {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] a = new int[10];
		Scanner in = new Scanner(System.in);
		int index = in.nextInt();
		try {
			a[index] = 10;
			System.out.println("hello,world");
		} catch(ArrayIndexOutOfBoundsException w) {
			System.out.println("Sorry");
			System.out.println(w.getMessage());
			System.out.println(w);
			w.printStackTrace();
			//throw w;
		}
		System.out.println("誰ですか");
	}

}