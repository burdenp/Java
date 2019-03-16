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
  public boolean sameList(ABST n1){
	  return true;
  }
  public boolean listHelper(Book book){
	  return false;
  }
//  public ILoB bstSort(ICompareBooks ICB){
//	  return this;
 // }
  /* TEMPLATE:
	FIELDS:
	METHODS:
sort               ILoB 
oneSort  ---       Book 
oneSortHelper      Book 
isSorted           boolean 
sameListHelp       boolean 
listHelper         boolean 
sameList           boolean 
	METHODS FOR FIELDS:

	*/
}