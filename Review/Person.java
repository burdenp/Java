
public class Person {

	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public int hashCode() {
		return (name + age).hashCode();
	}
	
	// Remember -- if two objects are equal, their hashcodes should be the same
	// But, the reverse may not be true!
	public boolean equals(Object obj) {
		if (!(obj instanceof Person))
			return false;
		Person p = (Person)obj;
		
		return (this.hashCode() == p.hashCode()) &&
		(this.name.equals(p.name)) && this.age == p.age;
	}
}


