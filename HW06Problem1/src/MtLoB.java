// Assignment 6 Problem 1
// Partner James Kandebo
// partner1username Kandebo
// Partner Patrick Burden
// partner2username PBurden
// 20 February 2012

// to represent an empty list of books
class MtLoB implements ILoB{
  MtLoB(){}
  
  public ILoB sort(ICompareBooks ICB){
	  return this;
  }
  public boolean isSorted(ICompareBooks ICB){
	  return true;
  }
  public Book oneSortHelper(Book book, ICompareBooks ICB){
	  return book;
  }
  public ILoB sortHelp(Book book, ICompareBooks ICB){
	  return new ConsLoB(book, this);
  }
  /*
   * Template
   * FIELDS
   
   * METHODS:
   * ...this.sort... --ILoB
   * ... this.isSorted... --boolean
   * ... this.oneSortHelper.... --Book
   * ... this.sortHelp... --ILoB
   * METHODS FOR FIELDS:
   
   */
}