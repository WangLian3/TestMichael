package XML;

import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Read {
	public void parseXMLWithJDK() {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbd = dbf.newDocumentBuilder();
			Document doc = dbd.parse(new FileInputStream("E:\\eloanEclipse2018\\practice\\readxml.xml"));
			
			XPathFactory f = XPathFactory.newInstance();
			XPath path = f.newXPath();
			NodeList authors = (NodeList) path.evaluate("book/authors/author",doc,XPathConstants.NODESET);
			System.out.println(authors.getLength());
			
			if(authors!=null) {
				for(int i=0;i<authors.getLength();i++) {
					Node author = authors.item(i);
					int n = i+1;
					System.out.println(n+".名字：" +author.getNodeName());
					System.out.println();
				}
			}
			
			Node author = (Node) path.evaluate("book/authors/author", doc, XPathConstants.NODE);
			System.out.println("名称："+author.getNodeName());
			System.out.println("内容："+author.getTextContent());
			
			NamedNodeMap attr = author.getAttributes();
			System.out.println("该节点的属性个数"+attr.getLength());
			
			if(attr!=null) {
				for(int i=0;i<attr.getLength();i++) {
					int n = i+1;
					System.out.println("属性"+n+"名称："+attr.item(i).getNodeName());
					System.out.println("值："+attr.item(i).getNodeName());
					System.out.println("类型："+attr.item(i).getNodeType());
					System.out.println();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new Read().parseXMLWithJDK();
	}
}
