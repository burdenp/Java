import java.util.*;
import tester.*;


public class Examples {

	public void test(Tester t){
		
		HashMap<String, Person> people = new HashMap<String, Person>();
		
		Person bob = new Person("Bob", 19);
		Person jim = new Person ("Jim", 23);
		
		NameCheck ncheck = new NameCheck();
		
		people.put("Bob", bob);
		people.put("Jim", jim);
		
		// Test basic hash map stuff
		t.checkExpect(people.get("Bob").age, 19);
		t.checkExpect(people.containsKey("Sarah"), false);
		
		t.checkExpect(ncheck.compare(bob, jim), -8);
		t.checkExpect(ncheck.compare(bob, bob), 0);
		t.checkExpect(ncheck.compare(jim, bob), 8);
		
		// Testing IBT
		IBT<Integer> ints = new Node<Integer>(5, new Leaf<Integer>(),
					new Node<Integer>(6, new Leaf<Integer>(), new Leaf<Integer>()));
		
		IVisitorBT<Integer, Integer> summer = new SumBT();
		
		t.checkExpect(ints.accept(summer), 11);
	}
	
	public void testForWhile(Tester t) {
		ArrayList<String> names = new ArrayList<String>();
		names.add("David");
		names.add("Viera");
		names.add("Trevor");
		names.add("Scott");
		
		// For loop example
		String allnames = "";
		for (int i = 0; i < names.size(); i++) {
			allnames = allnames + names.get(i);
		}
		t.checkExpect(allnames, "DavidVieraTrevorScott");
		
		// While loop example
		allnames = "";
		int i = 0;
		while (i < names.size()) {
			allnames = allnames + names.get(i);
			i++;
		}
		t.checkExpect(allnames, "DavidVieraTrevorScott");
		
		// For each example
		allnames = "";
		for (String s : names) {
			allnames = allnames + s;
			i++;
		}
		t.checkExpect(allnames, "DavidVieraTrevorScott");
		
		// Iterator example
		Iterator<String> it = names.iterator();
		allnames = "";
		while (it.hasNext()) {
			allnames = allnames + it.next();
		}
		t.checkExpect(allnames, "DavidVieraTrevorScott");

	}
}
