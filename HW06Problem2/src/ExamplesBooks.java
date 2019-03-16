// Assignment 6 Problem 2
// Partner James Kandebo
// partner1username Kandebo
// Partner Patrick Burden
// partner2username PBurden
// 20 February 2012

import tester.*;

// examples and tests for lists of books
class ExamplesBooks{
  ExamplesBooks(){}
  
  Book eh1 = new Book("Old Man and the Sea", "EH", 5);
  Book eh2 = new Book("Snows on Killimanjaro", "EH", 8);
  Book eh3 = new Book("SAR", "EH", 10);
  Book eh4 = new Book("AQOTWF", "EH", 12);
  Book htdp = new Book("HtDP", "FFFK", 100);
  Book sn = new Book("Shipping News", "EAP", 20);
  Book dvc = new Book("DVC", "DB", 25);
 ICompareBooks ICB1 = new BookOrderByAutor();
 ICompareBooks ICB2 = new BookOrderByTitleLength();
 ICompareBooks ICB3 = new BookOrderByPrice();
  Leaf leaf1 = new Leaf(ICB1);
  Node node1 = new Node(ICB1, eh1, leaf1, leaf1);
  Node node2 = new Node(ICB1, eh2, node1, leaf1);
  ILoB empty = new MtLoB();
  ILoB list1 = new ConsLoB(eh1, empty);
  
  boolean testInsert(Tester t)
 	{
 		return t.checkExpect(node1.insert(node1, ICB1), new Node(ICB1, node1.Data, node1, leaf1)) &&
 			   t.checkExpect(node2.insert(node1, ICB1), new Node(ICB1, node2.Data, new Node(ICB1, node1.Data, node1, leaf1), leaf1));
 	}
  boolean testGetFirst(Tester t)
	{
		return t.checkExpect(node1.getFirst(ICB1), eh1); 
	}
  boolean testCheckException(Tester t)
  {
	  	return t.checkException(new RuntimeException("No First In An Empty Tree"), this.leaf1, "getFirst", ICB1);
  }
  boolean testGetRest(Tester t)
 	{
 		return t.checkExpect(node1.getRest(ICB1), leaf1); 
 	}
   boolean testCheckException2(Tester t)
   {
 	  	return t.checkException(new RuntimeException("No Rest Of An Empty Tree"), this.leaf1, "getRest", ICB1);
   }
   boolean testSameTree(Tester t)
  	{
  		return t.checkExpect(node1.sameTree(node1), true) &&
  				t.checkExpect(node1.sameTree(node2), false);
  	}
   boolean testIsLeaf(Tester t)
 	{
 		return t.checkExpect(leaf1.isLeaf(), true) &&
 				t.checkExpect(node1.isLeaf(), false);
 	}
   boolean testSameData(Tester t)
   {
	   return t.checkExpect(node1.sameData(node1), true) &&
			   t.checkExpect(node2.sameData(node2), true) &&
			   t.checkExpect(node1.sameData(node2), true);
   }
   boolean testSameAsList(Tester t){
	   return t.checkExpect(node1.sameAsList(list1));
   }
}



