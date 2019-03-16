// Assignment 9 Problem 1
// Partner Patrick Burden
// partner1username pburden
// Partner Seydi Sy
// partner2username seydi
// 20 March 2012

import java.util.ArrayList;
import tester.*;

public class AlgorithmsExamples {
	AlgorithmsExamples(){}
	
	/** A sample <code>ArrayList</code> */
	ArrayList<String> arlistString = new ArrayList<String>();
	ArrayList<Integer> arlistInt = new ArrayList<Integer>();
	Algorithms al = new Algorithms();
	IntegerCompare intComp = new IntegerCompare();
	StringCompare stringComp = new StringCompare();
	
	public void initData(){
		this.arlistString.clear();
		this.arlistInt.clear();
		this.arlistString.add("bye");
		this.arlistString.add("hey");
		this.arlistString.add("meh");
		this.arlistInt.add(1);
		this.arlistInt.add(2);
		this.arlistInt.add(3);
	}
	//tests BinarySearch in Algorithms class
	public void testBinarySearch(Tester t){
		this.initData();
		t.checkExpect(this.al.binarySearch(0, 2, arlistInt, intComp, 2), 1);
	}
}
