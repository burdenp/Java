// Assignment 8 Problem 1
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012

public class BookTitle implements ITransform<Book, String>{
	public BookTitle(){}
	public String transform(Book b){
		return b.title;
	}
	/* Template
     *   Fields
     *   Methods 
     *     ... this.transform(Book b) ...       -- String
     */
}
