
import java.util.Scanner;

public class Hello {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("hello,world");
		Scanner in = new Scanner(System.in);
		//System.out.println("2+3="+(2+3));
		//System.out.println(in.nextLine());
		System.out.print("请输入票面：");
		int amount = in.nextInt();
		System.out.print("请输入金额：");
		int price = 0;
		price = in.nextInt();
		System.out.println(amount + "-" + price+ "=" + (100 - price));
	}
}