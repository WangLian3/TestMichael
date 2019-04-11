package ObserverMode;

public class Test {
	public static void main(String[] args) {
		XiaoWang xw = new XiaoWang();
		XiaoLi xl = new XiaoLi();
		xw.name = "小王";
		xl.name = "小李";
		
		XiaoMei xm = new XiaoMei();
		xm.person.add(xw);
		xm.person.add(xl);
		
		xm.setMessage();
	}
}
