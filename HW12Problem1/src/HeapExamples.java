// Assignment 12 Problem 1
// Partner Patrick Burden
// partner1username pburden
// Partner Name2 Seydi Sy
// partner2username seydi
// 10 April 2012


import java.util.ArrayList;
import java.util.Comparator;

import tester.Tester;



public class HeapExamples {

	
	ArrayList<Integer> myheap = new ArrayList<Integer>();
	ArrayList<Integer> heap1 = new ArrayList<Integer>();
	ArrayList<Integer> heap2 = new ArrayList<Integer>();
	ArrayList<Integer> heap3 = new ArrayList<Integer>();
	ArrayList<Integer> heap4 = new ArrayList<Integer>();
	ArrayList<Integer> unsortedHeap = new ArrayList<Integer>();
	ArrayList<Integer> testHeap = new ArrayList<Integer>();
	Comparator<Integer> intComp = new IntegerCompare();
	PriorityQueue<Integer> PQ1 = new PriorityQueue<Integer>(heap1, intComp);
	PriorityQueue<Integer> PQ2 = new PriorityQueue<Integer>(heap2, intComp);
	PriorityQueue<Integer> PQ3 = new PriorityQueue<Integer>(heap3, intComp);
	PriorityQueue<Integer> PQ4 = new PriorityQueue<Integer>(heap4, intComp);
	PriorityQueue<Integer> unsortedPQ = new PriorityQueue<Integer>(unsortedHeap, intComp);
	
	void initHeap(){
	  myheap.clear();
	  this.myheap.add(null); // the unused first item
	  this.myheap.add(70);
	  this.myheap.add(60);
	  this.myheap.add(40);
	  this.myheap.add(35);
	  this.myheap.add(50);
	}
	void initHeap1(){
		this.heap1.clear();
		this.heap1.add(null);// the unused first item
		this.heap1.add(80);
		this.heap1.add(50);
		this.heap1.add(40);
	    this.heap1.add(45);
	    this.heap1.add(20);
	    this.heap1.add(30);
	}
	void initHeap2(){
		this.heap2.clear();
		this.heap2.add(null);// the unused first item
		this.heap2.add(50);
		this.heap2.add(45);
		this.heap2.add(40);
	    this.heap2.add(30);
	    this.heap2.add(20);
	}
	void initHeap3(){
		this.heap3.clear();
		this.heap3.add(null);// the unused first item
		this.heap3.add(70);
		this.heap3.add(45);
		this.heap3.add(50);
	    this.heap3.add(30);
	    this.heap3.add(20);
	    this.heap3.add(40);
	}
	void initHeap4(){
		this.heap4.clear();
		this.heap4.add(null);// the unused first item
		this.heap4.add(50);
		this.heap4.add(45);
	    this.heap4.add(30);
	    this.heap4.add(20);
	    this.heap4.add(40);
	    
		this.unsortedHeap.add(45);
		this.unsortedHeap.add(50);
	    this.unsortedHeap.add(30);
	    this.unsortedHeap.add(20);
	    this.unsortedHeap.add(40);
	}
	void testHeap(){
		this.testHeap.clear();
		this.testHeap.add(null);// the unused first item
		this.testHeap.add(50);
		this.testHeap.add(45);
		this.testHeap.add(47);
	    this.testHeap.add(30);
	    this.testHeap.add(20);
		this.testHeap.add(40);
	}
	void testPQ(Tester t){
		initHeap();
		initHeap1();
		initHeap2();
		initHeap3();
		initHeap4();
		PriorityQueue<Integer> PQ1 = new PriorityQueue<Integer>(heap1, intComp);
		t.checkExpect(PQ1.isLeaf(3), false);
		t.checkExpect(PQ1.isLeaf(1), false);
		t.checkExpect(PQ1.higherPriorityChild(1), 2);
		t.checkExpect(PQ1.higherPriorityChild(2), 4);
		ArrayList<Integer> tempHeap = heap1;
		tempHeap.add(10);
		PriorityQueue<Integer> temp1 = new PriorityQueue<Integer>(tempHeap, intComp);
		PQ1.insert(10);
		t.checkExpect(PQ1, temp1);
		this.testHeap();
		PriorityQueue<Integer> temp2 = new PriorityQueue<Integer>(testHeap, intComp);
		PQ2.insert(47);
		t.checkExpect(PQ2, temp2);
		PQ3.remove();
		t.checkExpect(PQ3, PQ4);
		t.checkExpect(unsortedPQ.heapsort(unsortedHeap, intComp), heap4);
	}
}
