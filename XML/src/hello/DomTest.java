package hello;

import java.io.File;
import java.util.Iterator;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DomTest {

	public static void main(String[] args) throws DocumentException {
		// TODO 自动生成的方法存根
		SAXReader reader = new SAXReader();
		org.dom4j.Document doc = reader.read(new File("src/first.xml"));
		Element root = doc.getRootElement();
		Iterator<Element> it = root.elementIterator();
		while(it.hasNext()) {
			Element e = it.next();
			System.out.println(e.getName());
		}
	}
	
}
