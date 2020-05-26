package hello;

import java.util.Scanner;

public class Z6 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] a = {3,6,8,12,15};
		System.out.print("请输入要查找的数字：");
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		boolean index = false;
		for(int i : a)
		{
			if(i == x)
			{
				index = true;
				break;
			}
		}
		if(index)
			System.out.println("找到了");
		else
			System.out.println("未找到");
		in.close();
	}

}