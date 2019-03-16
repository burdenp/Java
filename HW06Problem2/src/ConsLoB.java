// Assignment 6 Problem 2
// Partner James Kandebo
// partner1username Kandebo
// Partner Patrick Burden
// partner2username PBurden
// 20 February 2012

// to represent a nonempty list of books
class ConsLoB implements ILoB{
  Book first;
  ILoB rest;
  
  ConsLoB(Book first, ILoB rest){
    this.first = first;
    this.rest = rest;
  }
  
/* TEMPLATE:
   FIELDS:
   ... this.first ...    -- Book
   ... this.rest ...     -- ILoB
   
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
  public ILoB sort(ICompareBooks ICB){
	 return rest.sortHelp(first, ICB);
  }
  public ILoB sortHelp(Book book, ICompareBooks ICB){
	  if (ICB.isBefore(book, this.first))
	  return new ConsLoB(book, this.sort(ICB));
	  else{ 
		  return new ConsLoB(this.first, this.rest.sortHelp(book, ICB));
	  }
		  
  }
  public Book oneSort(ICompareBooks ICB){
	  return rest.oneSortHelper(first, ICB);
  }
  public Book oneSortHelper(Book book, ICompareBooks ICB){
  	if (ICB.isBefore(book, this.first))
	  return book;
	  else{ 
		  return this.first;
	  }
  }
  public boolean isSorted(ICompareBooks ICB){
	  return this.sameListHelp(this.oneSort(ICB), ICB);
  }
  
  public boolean sameListHelp(Book book, ICompareBooks ICB){
	  if (this.first.equals(book))
			  return this.rest.isSorted(ICB);
	  else{
		  return false;
	  }
  }
  public boolean listHelper(Book book){
	  return this.first.sameDataHelper(book);
  }
  public boolean sameList(ABST n1){
	  return n1.sameAsList(this.rest);
  }
 // public ILoB bstSort(ICompareBooks ICB){
	  
//  }
}