package XML;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test2 {
	public static void main(String[] args){
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbl = dbf.newDocumentBuilder();
			Document doc = dbl.parse(new FileInputStream("E:/eloanEclipse2018/practice/bookstore.xml"));
			
			XPathFactory xpf = XPathFactory.newInstance();
			XPath xpath = xpf.newXPath();
			NodeList webTitle  = (NodeList) xpath.evaluate("/bookstore/book[@category='WEB']/title/text()",doc,XPathConstants.NODESET);
			System.out.println(webTitle);
			System.out.println("==================================");
			
			String webTitleLang = (String) xpath.evaluate(
				    "/bookstore/book[@category='WEB']/title/@lang", doc,
				    XPathConstants.STRING);
			System.out.println(webTitleLang);
			System.out.println("==================================");
			
			Node bookWeb = (Node) xpath.evaluate(
				    "/bookstore/book[@category='WEB']", doc,
				    XPathConstants.NODE);
			System.out.println(bookWeb.getNodeName());
			System.out.println("===================================");
			
			NodeList books = (NodeList) xpath.evaluate("/bookstore/book", doc,
				    XPathConstants.NODESET);
				  for (int i = 0; i < books.getLength(); i++) {
				   Node book = books.item(i);
				   System.out.println(xpath.evaluate("@category", book,
				     XPathConstants.STRING));
				  }
			System.out.println("====================================");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
