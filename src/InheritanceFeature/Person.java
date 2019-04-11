package InheritanceFeature;

public class Person {
	String name;
	int age;
	String gener;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGener() {
		return gener;
	}
	public void setGener(String gener) {
		this.gener = gener;
	}
	
	public Person max() {
		return new Person();
	}
	
	
	
}
