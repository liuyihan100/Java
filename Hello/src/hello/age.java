package hello;

import java.util.Scanner;

public class age {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		final int Minor = 35;
		System.out.print("������������䣺");
		Scanner in = new Scanner(System.in);
		int age = in.nextInt();
		System.out.println("���������" + age);
		if (age < Minor)
		{
			System.out.print("���������õģ�");
		}
		System.out.println("�����������ľ��񾳽磬�ú���ϧ�ɡ�");
		in.close();
	}
	
}