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
        //读取XML文件，获得document对象
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("D:\\hemaProject\\user.xml"));
        
        //获得某个节点的属性对象
        Element rootElem = document.getRootElement();
        //获取根节点属性对象
//        Attribute rootAttr = rootElem.attribute("Users");    
        
        //获取指定节点属性对象
        Element contactElem = rootElem.element("Users");
//        Attribute contactAttr = contactElem.attribute("username");
        
        //遍历某个节点的所有属性
        for (Iterator it = contactElem.attributeIterator();it.hasNext();){
            Attribute  conAttr= (Attribute)it.next();
            String conTxt = conAttr.getValue();
            String conAttrName = conAttr.getName();
            System.out.println(conAttrName+" = "+conTxt);
        }
        //设置某节点的属性和值
        contactElem.addAttribute("username", "zhangsan");
        
        //设置(更改)某属性的值
//        Attribute nameAttr = contactElem.attribute("name");
//        nameAttr.setValue("lisi");
        
        //删除某节点的指定属性
//        contactElem.remove(nameAttr);
        //将某节点的属性和值写入xml文档中
        XMLWriter writer = new XMLWriter(new FileWriter("D:\\hemaProject\\user.xml"));
        writer.write(document);
        writer.close();
        
        /**
         * 如果文档中有中文需要设置字符编码
         * 用如下语句:
         * OutputFormat format = OutputFormat.createPrettyPrint();
         * format.setEncoding("GBK");
         * XMLWriter writer = new XMLWriter(new FileWriter("./src/contact.xml"),format);
         */
        //获取指定对象的属性名
//        System.out.println(rootAttr.getName());
//        System.out.println(contactAttr.getName());
        //获取指定对象的属性值
//        System.out.println(contactAttr.getValue());
//        System.out.println(rootAttr.getValue());
    }
}
