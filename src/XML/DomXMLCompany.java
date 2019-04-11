package XML;

import java.io.File;
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

public class DomXMLCompany {
	public static void main(String[] args) {
		try {
//			GetDataDao dataDao = new GataDataDao();
			ArrayList<String> tableSchemaList = new ArrayList<String>();
			Document document = ConfigureClient.getFileAsDom("D:\\eloanFile\\baseConfig\\conf\\getdata\\GetData-AccountType.xml");
			Element element = document.getDocumentElement();
			NodeList tableNodeList = element.getElementsByTagName("TABLES").item(0).getChildNodes();
			for (int i=0;i<tableNodeList.getLength();i++) {
				Node field = tableNodeList.item(i);
				if(field.getNodeType() == Node.ELEMENT_NODE) {
					NamedNodeMap attrMap = field.getAttributes();
					for(int j=0;j<attrMap.getLength();j++) {
						if("EXIMSYS".equals(attrMap.getNamedItem("SCHEMA").getNodeValue())) {
							tableSchemaList.add("IASYS");
						}else {
							tableSchemaList.add("IATRX");
						}
					}
					tableSchemaList.add(field.getTextContent());
				}
			}
			System.out.println(tableSchemaList);
			
			List<Map<String,String>> list = new LinkedList<>();
			NodeList fieldNodeList = element.getElementsByTagName("FIELDS").item(0).getChildNodes();
			for(int j=0; j<fieldNodeList.getLength();j++) {
				Node field = fieldNodeList.item(j);
				if(field.getNodeType() == Node.ELEMENT_NODE) {
					Map<String,String> fieldMap = new HashMap<>();
					fieldMap.put("FieldName",field.getNodeName());
					fieldMap.put("RtnField",field.getTextContent());
					list.add(fieldMap);
				}
			}
			System.out.println(list);
			
			NodeList clauseNodeList = element.getElementsByTagName("CLAUSE").item(0).getChildNodes();
			List<String> list1 = new LinkedList<>();
			if(clauseNodeList != null) {
				StringBuilder builder = new StringBuilder();
				for(int k=0; k<clauseNodeList.getLength();k++) {
					Node field = clauseNodeList.item(k);
					if(field.getNodeType() == Node.ELEMENT_NODE){
						NamedNodeMap attrMap = field.getAttributes();
						if(null != attrMap.getNamedItem("TYPE")
								&& "FLD".equals(attrMap.getNamedItem("TYPE").getNodeValue())) {
							builder.append("?");
							list1.add(field.getTextContent());
						}else {
							builder.append(field.getTextContent());
						}
					}																										
				}
			}
			System.out.println(list1);
			
		} catch (ConfigLogException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
