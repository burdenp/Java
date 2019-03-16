// Assignment 10 Problem 2
// Partner Patrick Burden
// partner1username pburden
// Partner Name2 Seydi Sy
// partner2username seydi
// 27 March 2012

import java.util.ArrayList;
import java.util.Comparator;

import tester.Tester;

public class InsertionExamples {
	ArrayList<String> arlistString = new ArrayList<String>();
	ArrayList<String> unsortStr = new ArrayList<String>();
	ArrayList<Integer> unsortInt = new ArrayList<Integer>();
	ArrayList<Integer> arlistInt = new ArrayList<Integer>();
	IntegerCompare intComp = new IntegerCompare();
	StringCompare stringComp = new StringCompare();
	Insertion<String> stringInsert = new Insertion<String>();
	Insertion<Integer> intInsert = new Insertion<Integer>();
	public void initData(){
		this.arlistString.clear();
		this.arlistInt.clear();
		this.unsortStr.clear();
		this.unsortInt.clear();
		this.arlistString.add("bye");
		this.arlistString.add("hey");
		this.arlistString.add("meh");
		this.arlistInt.add(1);
		this.arlistInt.add(2);
		this.arlistInt.add(3);
		this.unsortStr.add("hey");
		this.unsortStr.add("bye");
		this.unsortStr.add("meh");
		this.unsortInt.add(3);
		this.unsortInt.add(1);
		this.unsortInt.add(2);
	}
	public void testSortedInsert(Tester t){
		this.initData();
		intInsert.sortedInsert(arlistInt, intComp, 0);
		t.checkExpect(arlistInt.get(0), 0);
		stringInsert.sortedInsert(arlistString, stringComp, "aa");
		t.checkExpect(arlistString.get(0), "aa");
		intInsert.sortedInsert(arlistInt, intComp, 5);
		t.checkExpect(arlistInt.get(4), 5);
		stringInsert.sortedInsert(arlistString, stringComp, "zz");
		t.checkExpect(arlistString.get(4), "zz");
		
	}
	public void testInsertionSort(Tester t){
		this.initData();
		t.checkExpect(intInsert.insertionSort(unsortInt, intComp), arlistInt);
		t.checkExpect(stringInsert.insertionSort(unsortStr, stringComp), arlistString);
	}
	public void testinsertionSortInPlace(Tester t){
		this.initData();
		t.checkExpect(intInsert.insertionSortInPlace(unsortInt, intComp), arlistInt);
		t.checkExpect(stringInsert.insertionSortInPlace(unsortStr, stringComp), arlistString);
		
	}
}
