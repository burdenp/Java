// Assignment 6 Problem 1
// Partner James Kandebo
// partner1username Kandebo
// Partner Patrick Burden
// partner2username PBurden
// 20 February 2012

import tester.*;

// examples and tests for lists of books
class ExamplesBooks{
  ExamplesBooks(){}
  
  Book eh1 = new Book("Old Man and the Sea", "EH", 1950);
  Book eh2 = new Book("Snows on Killimanjaro", "EH", 1954);
  Book eh3 = new Book("SAR", "EH", 1952);
  Book eh4 = new Book("AQOTWF", "EH", 1952);
  Book htdp = new Book("HtDP", "FFFK", 2001);
  Book sn = new Book("Shipping News", "EAP", 2000);
  Book dvc = new Book("DVC", "DB", 2000);
  ILoB empty = new MtLoB();
  ILoB list1 = new ConsLoB(eh1, empty);
  ILoB list2 = new ConsLoB(eh2, list1);
  ILoB list3 = new ConsLoB(eh3, list2);
  ILoB list4 = new ConsLoB(eh4, list3);
  ILoB list5 = new ConsLoB(htdp, list4);
  ILoB sortByTitle = new ConsLoB(eh1, new ConsLoB(eh2, empty));
  ILoB sortByAutor = new ConsLoB(eh2, new ConsLoB(eh1, empty));
  ILoB sortByYear = new ConsLoB(eh1, new ConsLoB(eh2, empty));
  ICompareBooks autor = new BookOrderByAutor();
  ICompareBooks year = new BookOrderByYear();
  ICompareBooks title = new BookOrderByTitleLength();
  
  boolean testSort(Tester t)
	{
		return t.checkExpect(list2.sort(title), sortByTitle) &&
				t.checkExpect(list2.sort(autor), sortByAutor) &&
				t.checkExpect(list2.sort(year), sortByYear);
	}
  boolean testSortHelp(Tester t)
  {
   return	t.checkExpect(new ConsLoB(eh2, empty).sortHelp(eh1, title), eh1) &&
		    t.checkExpect(new ConsLoB(eh2, empty).sortHelp(eh1, autor), eh1) &&
			t.checkExpect(new ConsLoB(eh2, empty).sortHelp(eh1, year), eh2);
  }
  boolean testIsSorted(Tester t)
  {
	  	return t.checkExpect(list2.isSorted(title), false) &&
		t.checkExpect(list2.isSorted(autor), true) &&
		t.checkExpect(list2.isSorted(year), false);
  }
  boolean testOneSortHelper(Tester t)
  {
	  return t.checkExpect(new ConsLoB(eh2, empty).oneSortHelper(eh1, title), eh1) &&
			  t.checkExpect(new ConsLoB(eh2, empty).oneSortHelper(eh1, autor), eh1) &&
			  t.checkExpect(new ConsLoB(eh2, empty).oneSortHelper(eh1, year), eh1);
  }
}