package constractXML;

import org.apache.xerces.dom.DocumentImpl;
import org.w3c.dom.Document;

public class XMLManager {
	public static Document createDocument() {
		return new DocumentImpl();
	}
}
