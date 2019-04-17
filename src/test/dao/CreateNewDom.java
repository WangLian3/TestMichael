package test.dao;

import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.crimson.tree.XmlDocument;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateNewDom {
	/**
     * ����xml�ĵ�
     * */
    public static void createDom(){
        Document doc;
        Element school,student;
        Element name = null;
        Element num = null;
        Element classes = null;
        Element address = null;
        Element tel = null;
        try{
            //�õ�DOM�������Ĺ���ʵ��
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            //��DOM�����л��DOM������
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            //�����ĵ���ģ�Ͷ���
            doc = dbBuilder.newDocument();
            if(doc != null){
                //����schoolԪ��
                school = doc.createElement("School");
                //����studentԪ��
                student = doc.createElement("Student");
                //����Ԫ��Student������ֵΪ231
                student.setAttribute("examId", "23");
                //��������ΪName��Ԫ��
                name = doc.createElement("Name");
                //��������Ϊ ���� ���ı��ڵ㲢��Ϊ�ӽڵ���ӵ�nameԪ����
                name.appendChild(doc.createTextNode("����"));
                //��name��Ԫ����ӵ�student��
                student.appendChild(name);
                /**
                 * �����Ԫ�����μ��뼴��
                 * */
                num = doc.createElement("Num");
                num.appendChild(doc.createTextNode("1006010066"));
                student.appendChild(num);
                
                classes = doc.createElement("Classes");
                classes.appendChild(doc.createTextNode("���ӹ�5"));
                student.appendChild(classes);
                
                address = doc.createElement("Address");
                address.appendChild(doc.createTextNode("�㽭����"));
                student.appendChild(address);
                
                tel = doc.createElement("Tel");
                tel.appendChild(doc.createTextNode("123890"));
                student.appendChild(tel);
                
                //��student��Ϊ��Ԫ����ӵ����ĸ��ڵ�school
                school.appendChild(student);
                //��ӵ��ĵ�����
                doc.appendChild(school);
                //���ڴ��е��ĵ�ͨ���ļ�������insertSchool.xml,XmlDocumentλ��crison.jar��
                ((XmlDocument)doc).write(new FileOutputStream("D:\\hemaProject\\test.xml"));
                System.out.println("�����ɹ�");
            }
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        CreateNewDom.createDom();
    }
}
