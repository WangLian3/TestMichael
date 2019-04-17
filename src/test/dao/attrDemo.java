package test.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.jupiter.api.Test;

public class attrDemo {
	@Test
    public void exmple() throws Exception{
        //��ȡXML�ļ������document����
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("D:\\hemaProject\\user.xml"));
        
        //���ĳ���ڵ�����Զ���
        Element rootElem = document.getRootElement();
        //��ȡ���ڵ����Զ���
//        Attribute rootAttr = rootElem.attribute("Users");    
        
        //��ȡָ���ڵ����Զ���
        Element contactElem = rootElem.element("Users");
//        Attribute contactAttr = contactElem.attribute("username");
        
        //����ĳ���ڵ����������
        for (Iterator it = contactElem.attributeIterator();it.hasNext();){
            Attribute  conAttr= (Attribute)it.next();
            String conTxt = conAttr.getValue();
            String conAttrName = conAttr.getName();
            System.out.println(conAttrName+" = "+conTxt);
        }
        //����ĳ�ڵ�����Ժ�ֵ
        contactElem.addAttribute("username", "zhangsan");
        
        //����(����)ĳ���Ե�ֵ
//        Attribute nameAttr = contactElem.attribute("name");
//        nameAttr.setValue("lisi");
        
        //ɾ��ĳ�ڵ��ָ������
//        contactElem.remove(nameAttr);
        //��ĳ�ڵ�����Ժ�ֵд��xml�ĵ���
        XMLWriter writer = new XMLWriter(new FileWriter("D:\\hemaProject\\user.xml"));
        writer.write(document);
        writer.close();
        
        /**
         * ����ĵ�����������Ҫ�����ַ�����
         * ���������:
         * OutputFormat format = OutputFormat.createPrettyPrint();
         * format.setEncoding("GBK");
         * XMLWriter writer = new XMLWriter(new FileWriter("./src/contact.xml"),format);
         */
        //��ȡָ�������������
//        System.out.println(rootAttr.getName());
//        System.out.println(contactAttr.getName());
        //��ȡָ�����������ֵ
//        System.out.println(contactAttr.getValue());
//        System.out.println(rootAttr.getValue());
    }
}
