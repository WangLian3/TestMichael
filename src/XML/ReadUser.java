package XML;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.cs.config.client.ConfigLogException;
import com.cs.config.client.ConfigureClient;

public class ReadUser {
	public static void main(String[] args) {
		ArrayList<String> tableSchemaList = new ArrayList<String>();
		Document document;
		try {
			document = ConfigureClient.getFileAsDom("D:\\eloanFile\\baseConfig\\conf\\getdata\\user.xml");
			Element element = document.getDocumentElement();
			List<Map<String,String>> list = new LinkedList<>();
			NodeList tableNodeList = element.getElementsByTagName("users").item(0).getChildNodes();
			for(int i=0;i<tableNodeList.getLength();i++) {
				Node field = tableNodeList.item(i);
				if(field.getNodeType() == Node.ELEMENT_NODE) {
					NamedNodeMap attrMap = field.getAttributes();
					tableSchemaList.add(attrMap.getNamedItem("username").getNodeValue());
					tableSchemaList.add(attrMap.getNamedItem("password").getNodeValue());
//					tableSchemaList.add(field.getTextContent());
				}
			}
			System.out.println(tableSchemaList);
		} catch (ConfigLogException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
