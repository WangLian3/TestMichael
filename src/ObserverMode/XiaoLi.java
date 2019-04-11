package ObserverMode;

public class XiaoLi implements Person{
	public String name;
	
	public XiaoLi() {}
	
	@Override
	public void getMessage(String m) {

		System.out.println(name+"接收到的消息是："+m);
	}

}
