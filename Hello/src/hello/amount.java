package hello;

import java.util.Scanner;

public class amount {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner in = new Scanner(System.in);
		System.out.print("��Ͷ�ң�");
		int amount = in.nextInt();
		System.out.println(amount >= 10);
		System.out.println("*************************");
		System.out.println("*    Java�Ǽ���·ר��       *");
		System.out.println("*       ��ָ����ϯ            *");
		System.out.println("*        Ʊ��10Ԫ              *");
		System.out.println("*************************");
		System.out.println("���㣺" + (amount - 10));
	}
}