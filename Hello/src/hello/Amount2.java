package hello;

import java.util.Scanner;

public class Amount2 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int amount = 0;
		int balance = 0;
		while(true)
		{
			System.out.print("��Ͷ�ң�");
			Scanner in = new Scanner(System.in);
			amount = in.nextInt();
			balance += amount;
			if(balance >= 10)
			{
				System.out.println("*************************");
				System.out.println("*    Java�Ǽ���·ר��       *");
				System.out.println("*       ��ָ����ϯ            *");
				System.out.println("*        Ʊ��10Ԫ              *");
				System.out.println("*************************");
				System.out.println("���㣺" + (balance - 10));
				balance = 0;
			}
		}
	}

}