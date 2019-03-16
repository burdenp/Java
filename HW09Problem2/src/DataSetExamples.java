// Assignment 9 Problem 2
// Partner Patrick Burden
// partner1username pburden
// Partner Seydi Sy
// partner2username seydi
// 20 March 2012
import java.util.ArrayList;

import tester.Tester;

public class DataSetExamples {
	DataSetExamples(){}
	ArrayList<Integer> al1 = new ArrayList<Integer>();
	Qlist<Integer> que1 = new Qlist<Integer>();
	
	public void initData(){
		this.al1.clear();
		this.al1.add(1);
		this.al1.add(2);
		this.al1.add(3);
		this.al1.add(4);
	}
	//tests all of the functions in the Stack class
	public void testStack(Tester t){
		this.initData();
		Stack<Integer> s1 = new Stack<Integer>(al1);
		t.checkExpect(s1.size(), 4);
		t.checkExpect(s1.current(), 1);
		s1.add(5);
		t.checkExpect(s1.current(), 5);
		t.checkExpect(s1.remove(), 5);
	}
	//tests all of the functions in the Queue class
	public void testQueue(Tester t){
		this.initData();
		Queue<Integer> q1 = new Queue<Integer>(al1);
		t.checkExpect(q1.size(), 4);
		t.checkExpect(q1.current(), 1);
		q1.add(5);
		t.checkExpect(q1.current(), 1);
		t.checkExpect(q1.remove(), 1);
	}
	//tests all of the functions in the Qlist class
	public void testQlist(Tester t){
		this.que1.add(1);
		
		t.checkExpect(que1.current(), 1);
		t.checkExpect(que1.size(), 1);
		this.que1.add(2);
		t.checkExpect(que1.current(), 1);
		t.checkExpect(que1.size(), 2);
		this.que1.remove();
		t.checkExpect(que1.current(), 2);
		t.checkExpect(que1.size(), 1);
	}
}
