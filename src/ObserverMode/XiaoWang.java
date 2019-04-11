package ObserverMode;

public class XiaoWang implements Person{
	public String name;
	
	public XiaoWang() {}

	@Override
	public void getMessage(String m) {
		System.out.println(name+"接收到的信息是："+m);
	}
}
