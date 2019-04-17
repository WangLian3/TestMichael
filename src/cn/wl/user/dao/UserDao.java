package cn.wl.user.dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.crimson.tree.XmlDocument;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import cn.wl.user.domain.User;

public class UserDao {
	private String path = "D:\\hemaProject\\user.xml";
	
//	public User findByUsername() throws SAXException, IOException {
//		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder builder;
//		List<String> tableSchemaList = new ArrayList<String>();
//		try {
//			builder = builderFactory.newDocumentBuilder();
//			Document document = builder.parse(path);
//			Element element = document.getDocumentElement(); 
//			NodeList tableNodeList = element.getElementsByTagName("users").item(0).getChildNodes();
////			System.out.println(tableNodeList.getLength());
//			for(int i=0;i<tableNodeList.getLength();i++) {
//				Node field = tableNodeList.item(i);
//				if(field.getNodeType() == Node.ELEMENT_NODE) {
//					NamedNodeMap attrMap = field.getAttributes();
//					tableSchemaList.add(attrMap.getNamedItem("username").getNodeValue());
//					tableSchemaList.add(attrMap.getNamedItem("password").getNodeValue());
//				}
//			}
//			System.out.println(tableSchemaList);
//		} catch (ParserConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return null;
//	}
	
	public User findByUsernameB() {
		
		
		return null;
	}
	
	public void add(User user) throws SAXException, IOException {
				 
		SAXReader reader = new SAXReader();
		try {
			Document doc = (Document) reader.read(path);
			Element root = doc.getRootElement();
			Element userEle = root.addElement("user");
			userEle.addAttribute("username",user.getUsername());
			userEle.addAttribute("password",user.getPassword());
			
			/**
			 * 保存文档
			 */
			//创建输出格式化
			OutputFormat format = new OutputFormat("\t",true);//缩进使用\t,是否换行，使用是！
			format.setTrimText(true);//清空原有的换行和缩进
			
			//创建XmlWriter
			XMLWriter writer;
			writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(path),"UTF-8"),format);
			writer.write(doc);
			writer.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws SAXException, IOException {
		UserDao u = new UserDao();
//		u.findByUsername();
		User  user = new User();
		user.setUsername("李四");
		user.setPassword("lisi");
		u.add(user);
	}
}


