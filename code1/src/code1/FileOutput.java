package code1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.InputStreamReader;

public class FileOutput {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("hello,world");
		byte[] buf = new byte[11];
		for(int i = 0;i < buf.length;i++) {
			buf[i] = (byte)i;
		}
		try {
			FileOutputStream out1 = new FileOutputStream("a.dat");
			out1.write(buf);
			out1.close();
		} catch (FileNotFoundException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			DataOutputStream out2 = new DataOutputStream(
					new BufferedOutputStream(
							new FileOutputStream("b.dat")));
			int k = 0x8a1e;
			out2.writeInt(k);
			out2.close();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			PrintWriter out3 = new PrintWriter(
					new BufferedWriter(
							new OutputStreamWriter(
									new FileOutputStream("c.txt"))));
			int j = 123456;
			out3.println(j);
			out3.close();
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("src/code1/FileOutput.java")));
			String line;
			while((line = in.readLine()) != null){
					System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (java.lang.Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();}
	}

}