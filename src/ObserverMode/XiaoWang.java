package ObserverMode;

public class XiaoWang implements Person{
	public String name;
	
	public XiaoWang() {}

	@Override
	public void getMessage(String m) {
		System.out.println(name+"���յ�����Ϣ�ǣ�"+m);
	}
}
