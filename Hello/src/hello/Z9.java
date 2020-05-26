package hello;

import java.util.Scanner;

public class Z9 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in);
		String a = new String("hello,world");
		a = in.next();
		System.out.println(a);
		System.out.println(a.equals("point"));
		System.out.println(a.compareTo("abc"));
		System.out.println(a.length());
		System.out.println(a.charAt(2));
		/* 字符串不能用for-each循环 */
		String b = "hello world";
		System.out.println(b.substring(3));
		System.out.println(b.substring(3,5));
		int loc = b.indexOf('o');
		System.out.println(b.indexOf('o',loc+1));
	}

}