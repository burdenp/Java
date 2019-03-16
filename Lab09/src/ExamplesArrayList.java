import tester.*;
import java.util.*;

/**
 * A class designed to explore and validate the methods defined in the 
 * <code>ArrayList</code> class.
 * 
 * @since 13 March 2012
 */
public class ExamplesArrayList{
	ExamplesArrayList(){}
	
	/** A sample <code>ArrayList</code> */
	ArrayList<Person> arlist = new ArrayList<Person>();
	ArrayList arlistSame = this.arlist;
	ArrayList arlistOther; 
	
	Person pete = new Person("Pete", 23);
	Person jill = new Person("Jill", 19);
	Person kim = new Person("Kim", 20);
	Person pat = new Person("Pat", 21);
	Person bob = new Person("Bob", 20);
	
	/**
	 * Test the method newAge for the class Person
	 *
	 * @param t The tester that runs the tests and reports the results
	 */
	public void testNewAge(Tester t){
		t.checkExpect(this.jill.newAge(25), new Person("Jill", 25));
	}
	
	/**
	 * Test the method birthday for the class Person
	 *
	 * @param t The tester that runs the tests and reports the results
	 */
	public void testBirthday(Tester t){
		// invoke the method
		this.jill.birthday();
		
		// verify the effects
		t.checkExpect(this.jill, new Person("Jill", 20));
	}
	public void testEmptyList(Tester t){
		t.checkExpect(arlist.isEmpty());
	}
	/**
	 * EFFECT:
	 * Initialize the array list with four data items
	 */
	public void initList(){
		this.arlist.clear();
		this.arlist.add(this.pete);
		this.arlist.add(this.jill);
		this.arlist.add(this.kim);
		this.arlist.add(this.pat);
		this.arlistOther = new ArrayList(this.arlist); 
	}
	/**
	 * EFFECT:
	 * Swaps the elements at locations I and J
	 */
	public void swapAtIndices(int i, int j){
		Person I = this.arlist.get(i);
		this.arlistOther.set(i, this.arlist.get(j));
		this.arlistOther.set(j, I);
	}
	
	public void testSize(Tester t){
		this.initList();
		t.checkExpect(this.arlistOther.size(), 4);
	}
	
	public void testAdd(Tester t){
		this.initList();
		t.checkExpect(this.arlistOther.contains(pete), true);
		t.checkExpect(this.arlistOther.contains(jill), true);
		t.checkExpect(this.arlistOther.contains(kim), true);
		t.checkExpect(this.arlistOther.contains(pat), true);
	}
	
	public void testRemove(Tester t){
		this.initList();
		this.arlistOther.remove(1);
		t.checkExpect(this.arlistOther.contains(jill), false);
	}
	
	public void testSet(Tester t){
		this.initList();
		this.arlistOther.set(0, bob);
		t.checkExpect(this.arlistOther.contains(pete), false);
		t.checkExpect(this.arlistOther.contains(bob), true);
		t.checkExpect(this.arlistOther.get(0), bob);
	}

	public void testSwapAtIndices(Tester t){
		this.initList();
		this.swapAtIndices(1, 2);
		t.checkExpect(this.arlistOther.get(1), kim);
		t.checkExpect(this.arlistOther.get(2), jill);
	}
	
	/**
	 * EFFECT:
	 * Run the tests to validate the design of the <code>ArrayList</code> class.
	 * 
	 * @param t The tester that runs the tests and reports the results
	 */
	public void testArrayList(Tester t){
		this.initList();
		t.checkExpect(this.arlistOther.size(), 4);		
	}
	
	/**
	 * Run the tests defined in the <code>ExamplesArrayList</code> class.
	 * 
	 * @param argv unused
	 */
	public static void main(String[] argv){
		ExamplesArrayList e = new ExamplesArrayList();
		// run tests and report the results: print all test results, print all data
		Tester.runReport(e, true, true);
	}
}

/**
 * A class of objects to include in the sample ArrayList
 */
class Person{
	
	/** the name of this person */
	String name;
	
	/** the age of this person */
	int age;
	
	/**
	 * The full constructor
	 * @param name the name of this person
	 * @param age the age of this person
	 */
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	/**
	 * Produce a new person with the same name as this one, 
	 * but with the given age
	 * 
	 * @param age the given age
	 * @return a new pesron with the same name as this one, but with the given age
	 */
	public Person newAge(int age){
		return new Person(this.name, age);
	}
	
	/**
	 * EFFECT:
	 * change this person's age to one year older when she reached her birthday 
	 */
	public void birthday(){
		this.age = this.age + 1;
	}
}