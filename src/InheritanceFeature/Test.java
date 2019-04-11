package InheritanceFeature;


public class Test {
	public static void main(String[] args) {
		Person p = new Person();
		Father f = new Father(p.max());
	}
}
