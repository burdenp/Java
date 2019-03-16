// Assignment 10 Problem 1
// Partner Patrick Burden
// partner1username pburden
// Partner Name2 Seydi Sy
// partner2username seydi
// 27 March 2012

import java.util.ArrayList;
import tester.Tester;

public class PermutationExamples {
		PermutationExamples(){}
		
		PermutationCode pc1 = new PermutationCode();
		ArrayList<Character> sampleCode = new ArrayList<Character>();
		ArrayList<Character> randomCode = pc1.codeList();
		public void initData(){
			sampleCode.clear();
			sampleCode.add('z');
			sampleCode.add('y');
			sampleCode.add('x');
			sampleCode.add('w');
			sampleCode.add('v');
			sampleCode.add('u');
			sampleCode.add('t');
			sampleCode.add('s');
			sampleCode.add('r');
			sampleCode.add('q');
			sampleCode.add('p');
			sampleCode.add('o');
			sampleCode.add('n');
			sampleCode.add('m');
			sampleCode.add('l');
			sampleCode.add('k');
			sampleCode.add('j');
			sampleCode.add('i');
			sampleCode.add('h');
			sampleCode.add('g');
			sampleCode.add('f');
			sampleCode.add('e');
			sampleCode.add('d');
			sampleCode.add('c');
			sampleCode.add('b');
			sampleCode.add('a');
		}
		
		public void testPermutation(Tester t){
			initData();
			PermutationCode pc2 = new PermutationCode(sampleCode);
			t.checkExpect(pc2.encode("abcde"), "zyxwv");
			t.checkExpect(pc2.decode("zyxwv"), "abcde");
		}
}
