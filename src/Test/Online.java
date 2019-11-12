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

        //before早于now，返回负数，可用于判断活动开始时间是否到了
        int compareToBefore=before.compareTo(now);
        System.out.println("compareToBefore = "+compareToBefore);

        int compareToIntNow=now.compareTo(now);
        System.out.println("compareToIntNow = "+compareToIntNow);

        //after晚于now，返回正数，可用于判断活动结束时间是否到了
        int compareToIntAfter=after.compareTo(now);
        System.out.println("compareToIntAfter = "+compareToIntAfter);
    }

	
	public static void main(String[] args) {
		Online o = new Online();
		Online o2 = new Online();
		o.test();
	}
}
