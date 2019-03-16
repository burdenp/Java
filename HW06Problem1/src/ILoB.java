// Assignment 6 Problem 1
// Partner James Kandebo
// partner1username Kandebo
// Partner Patrick Burden
// partner2username PBurden
// 20 February 2012

// to represent a list of books
interface ILoB{
	public ILoB sort(ICompareBooks ICB);
	public ILoB sortHelp(Book book, ICompareBooks ICB);
	public boolean isSorted(ICompareBooks ICB);
	public Book oneSortHelper(Book book, ICompareBooks ICB);
}

/*
 * Template
 * FIELDS
 * METHODS:
 * ...this.sort... --ILoB
 * ...this.sortHelp... --ILoB
 * ...this.isSorted... --boolean
 * ...this.oneSortHelper... --Book
 * METHODS FOR FIELDS:
 */