package ObserverMode;

public class XiaoLi implements Person{
	public String name;
	
	public XiaoLi() {}
	
	@Override
	public void getMessage(String m) {

		System.out.println(name+"���յ�����Ϣ�ǣ�"+m);
	}

}
