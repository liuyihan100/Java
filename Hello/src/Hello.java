
import java.util.Scanner;

public class Hello {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		System.out.println("hello,world");
		Scanner in = new Scanner(System.in);
		//System.out.println("2+3="+(2+3));
		//System.out.println(in.nextLine());
		System.out.print("������Ʊ�棺");
		int amount = in.nextInt();
		System.out.print("�������");
		int price = 0;
		price = in.nextInt();
		System.out.println(amount + "-" + price+ "=" + (100 - price));
	}
}