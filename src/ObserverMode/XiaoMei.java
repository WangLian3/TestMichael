package ObserverMode;

import java.util.ArrayList;
import java.util.List;

public class XiaoMei {
	private XiaoMei name;
	
	public XiaoMei() {}
	
	List<Person> person = new ArrayList<Person>();
	
	public void setMessage() {
		for(Person p : person) {
			p.getMessage("你们谁先到，我就和谁玩");
		}
	}
}
