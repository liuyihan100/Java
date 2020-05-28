package hello;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class DomTest5 {
	
	public static void main(String[] args) {
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("books");
		Element book = root.addElement("book");
		book.addAttribute("id", "15");
		Element name = book.addElement("name");
		Element author = book.addElement("author");
		name.addText("hello,world");
		author.addText("刘毅晗");
		XMLWriter xmlWriter = null;
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("src/hello.xml")),"utf-8"));
			OutputFormat format = OutputFormat.createPrettyPrint();
			xmlWriter = new XMLWriter(writer, format);
			xmlWriter.write(doc);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				xmlWriter.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
