package constractXML;

import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import com.google.gson.JsonObject;

public class EloanMessageB {
	public static void main(String[] args) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dbd = dbf.newDocumentBuilder();
			Document paraDom = dbd.parse(new FileInputStream("E:\\Program Files\\feiq\\Recv Files\\step1_takedown.xml"));
			EloanMessageB mb = new EloanMessageB(); 
			mb.process(paraDom);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Document process(Document paraDom) {
		Document domRet = XMLManager.createDocument();
		domRet.appendChild(domRet.importNode(paraDom.getElementsByTagName("message").item(0),true));
		JsonObject paraJson = new JsonObject();
		String lstrcompId = GapiConvJson.convertHeader(paraDom, paraJson);
		return domRet;
		
	}
}
