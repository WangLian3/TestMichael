package Test;

import java.util.Calendar;
import java.util.Date;

public class Online {
	
	public void test() {
        Calendar c = Calendar.getInstance();

        c.set(2016,5,4);
        Date before =c.getTime();

        c.set(2016,5,5);
        Date now=c.getTime();

        c.set(2016,5,6);
        Date after=c.getTime();

        //before����now�����ظ������������жϻ��ʼʱ���Ƿ���
        int compareToBefore=before.compareTo(now);
        System.out.println("compareToBefore = "+compareToBefore);

        int compareToIntNow=now.compareTo(now);
        System.out.println("compareToIntNow = "+compareToIntNow);

        //after����now�������������������жϻ����ʱ���Ƿ���
        int compareToIntAfter=after.compareTo(now);
        System.out.println("compareToIntAfter = "+compareToIntAfter);
    }

	
	public static void main(String[] args) {
		Online o = new Online();
		o.test();
	}
}
