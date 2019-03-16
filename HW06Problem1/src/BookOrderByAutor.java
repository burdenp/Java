// Assignment 6 Problem 1
// Partner James Kandebo
// partner1username Kandebo
// Partner Patrick Burden
// partner2username PBurden
// 20 February 2012

public class BookOrderByAutor implements ICompareBooks{
		public boolean compare(Book b1, Book b2){
			return (b1.author.compareTo(b2.author) <= 0);
		}
		/*
		 * Template
		 * FIELDS
		 * METHODS:
		 * ...this.compare... boolean
		 * METHODS FOR FIELDS:
		 */
}