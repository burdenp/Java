// Assignment 8 Problem 3
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012
import tester.*;

class IBTVExamples{
	IBTVExamples(){}
	
	IBT<Integer> leaf = new Leaf<Integer>();
	IBT<Integer> n1 = new Node<Integer>(1, leaf, leaf);
	IBT<Integer> n6 = new Node<Integer>(6, leaf, leaf);
	IBT<Integer> n2 = new Node<Integer>(2, n1, leaf);
	IBT<Integer> n5 = new Node<Integer>(5, leaf, n6);
	IBT<Integer> n4 = new Node<Integer>(4, leaf, n5);
	IBT<Integer> n3 = new Node<Integer>(3, n2, n4);
	
	LeftMostVisitor<Integer> leftMost = new LeftMostVisitor<Integer>();
	LeftMostAcc<Integer> acc = new LeftMostAcc<Integer>(0);
	RightMostVisitor<Integer> rightMost = new RightMostVisitor<Integer>();
	RightMostAcc<Integer> rightAcc = new RightMostAcc<Integer>(0);
	
	ICompareStringLeftRight compString = new ICompareStringLeftRight();
	IBTVisitor<String, Boolean> IS1 = new IsSorted<String, Boolean>(compString);
	
	IBT<String> stringLeaf = new Leaf<String>();
	IBT<String> a = new Node<String>("a", stringLeaf, stringLeaf);
	IBT<String> f = new Node<String>("f", stringLeaf, stringLeaf);
	IBT<String> b = new Node<String>("b", a, stringLeaf);
	IBT<String> e = new Node<String>("e", stringLeaf, f);
	IBT<String> d = new Node<String>("d", stringLeaf, e);
	IBT<String> c = new Node<String>("c", b, d);
	IBT<String> changedB = new Node<String>("b", stringLeaf, stringLeaf);
	IBT<String> changedA = new Node<String>("a", changedB, stringLeaf);
	
	IBST<String> BST1 = new BST<String>(compString, c);
	IBST<String> BST2 = new BST<String>(compString, a);

	
	void testLeftMostVisitor(Tester t){
		t.checkExpect(n3.accept(leftMost), 1);
		t.checkException("Testing having a leaf on the left",
			    new RuntimeException("There is no left most Node on a Leaf"), 
			    this.leaf,
			    "accept",
			    leftMost);
		
	}
	void testRightMostVisitor(Tester t){
		t.checkExpect(n3.accept(rightMost), 6);
		t.checkException("Testing having a leaf on the left",
			    new RuntimeException("There is no left most Node on a Leaf"), 
			    this.leaf,
			    "accept",
			    rightMost);
	}
	void testIsSorted(Tester t){
		t.checkExpect(c.accept(IS1), true);
	}
	void testMin(Tester t){
		t.checkExpect(BST1.min(), "a");
	}
	void testMax(Tester t){
		t.checkExpect(BST1.max(), "f");
	}
	void testInsertVisitor(Tester t){
		t.checkExpect(BST2.insert("b"),new BST<String>(compString, changedA));
	}
}
