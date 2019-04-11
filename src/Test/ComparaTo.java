package Test;

import java.util.Date;
import java.util.Iterator;

public class ComparaTo {
	public static void main(String[] args) {
		Date d1 =new Date();
		Date d2 = CalendarUtils.addSubMonth(d1, 1);
//		System.out.println(d1);
//		System.out.println(d2);
		
//		System.out.println(d1.compareTo(d1));
		
		String eventNo1 = "Michael.wang0031"; 
		String eventNo2 = "Michael.wang002"; 
		
		System.out.println(eventNo1.compareTo(eventNo2));
		
		
//		Iterator<Object> it = iterator();
	}
	
}
