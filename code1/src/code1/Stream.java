package code1;

import java.io.IOException;

public class Stream {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("hello,world");
		byte[] buffer = new byte[1024];
		try {
			int len = System.in.read(buffer);
			String s = new String(buffer,0,len);
			//int a = System.in.read();
			//System.out.println(a);
			System.out.println(len);
			System.out.println(s);
			System.out.println(s.length());
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}