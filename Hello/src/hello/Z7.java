package hello;

public class Z7 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		boolean[] number = new boolean[100];
		for(int i = 2;i < number.length;i++)
			number[i] = true;
		for(int i = 2;i < number.length;i++)
		{
			if(number[i])
			{
				for(int j = 2;i * j < number.length;j++)
				{
					number[i*j] = false;
				}
			}
		}
		for(int i = 0;i < number.length;i++)
		{
			if(number[i])
				System.out.print(i+" ");
		}
		System.out.println();
	}

}