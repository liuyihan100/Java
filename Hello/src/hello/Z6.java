package hello;

import java.util.Scanner;

public class Z6 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] a = {3,6,8,12,15};
		System.out.print("������Ҫ���ҵ����֣�");
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
			System.out.println("�ҵ���");
		else
			System.out.println("δ�ҵ�");
		in.close();
	}

}