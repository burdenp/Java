// Assignment 8 Problem 3
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012

import tester.*;

public class ICompareExamples {
	ICompareExamples(){}
	
	ICompareRunnerAge compAge = new ICompareRunnerAge();
	ICompareRunnerBib compBib = new ICompareRunnerBib();
	ICompareString compString = new ICompareString();
	
	Runner r1 = new Runner("Tom", 21, 1, 80);
	Runner r2 = new Runner("Bob", 22, 2, 120);
	Runner r3 = new Runner("Ann", 23, 54, 110);
	
	void testCompare(Tester t){
		t.checkExpect(compAge.compare(r1, r2), -1);
		t.checkExpect(compAge.compare(r2, r2), 0);
		t.checkExpect(compAge.compare(r3, r1), 1);
		t.checkExpect(compBib.compare(r1, r2), 1);
		t.checkExpect(compBib.compare(r2, r2), 0);
		t.checkExpect(compBib.compare(r3, r1), -1);
		t.checkExpect(compString.compare("z", "a"), -1);
		t.checkExpect(compString.compare("m", "m"), 0);
		t.checkExpect(compString.compare("q", "s"), 1);
	}

}
