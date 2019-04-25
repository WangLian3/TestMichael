package constractXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.gson.JsonObject;

public class GapiConvJson {
	public static String convertHeader(Document paraDom, JsonObject paraJson) {
		Element eMessage = paraDom.getDocumentElement();
		return convertHeader(eMessage,paraJson);
	}
	
	public static String convertHeader(Element eMessage, JsonObject paraJson) {
		String lstrcompId = null;
		JsonObject headerJson = new JsonObject();
		headerJson.addProperty("serviceName", "EE");
		headerJson.addProperty("relationNo", "123465798");
		headerJson.addProperty("dateTime", "123456789");
		
		JsonObject extendHeaderJson = new JsonObject();
		headerJson.add("extendHeader", extendHeaderJson);
		
		Element eHeader = (Element) eMessage.getElementsByTagName("header").item(0);
		NodeList nlChildNode = eHeader.getChildNodes();
		for(int i=0;i<nlChildNode.getLength();i++) {
			Node node = nlChildNode.item(i);
			if(node.getNodeType() != Node.ELEMENT_NODE) {
				continue;
			}
			String strName = node.getNodeName();
			if(strName == null) {
				continue;
			}
			if("bank-grp".equalsIgnoreCase(strName) || "country".equalsIgnoreCase(strName)
					|| "function-id".equalsIgnoreCase(strName) || "function-name".equalsIgnoreCase(strName)
					|| "trx-type".equalsIgnoreCase(strName) || "C_DS_ID".equalsIgnoreCase(strName)
					|| "event-name".equalsIgnoreCase(strName) || "parent-unit-code".equalsIgnoreCase(strName)
					|| "unit-code".equalsIgnoreCase(strName)) {
				extendHeaderJson.addProperty(strName, XMLManager.getNodeValue(node,true));
			}
		}
		return null;
	}
}
