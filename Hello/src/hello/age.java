package hello;

import java.util.Scanner;

public class age {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		final int Minor = 35;
		System.out.print("请输入你的年龄：");
		Scanner in = new Scanner(System.in);
		int age = in.nextInt();
		System.out.println("你的年龄是" + age);
		if (age < Minor)
		{
			System.out.print("年轻是美好的，");
		}
		System.out.println("年龄决定了你的精神境界，好好珍惜吧。");
		in.close();
	}
	
}