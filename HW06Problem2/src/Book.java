// Assignment 6 Problem 2
// Partner James Kandebo
// partner1username Kandebo
// Partner Patrick Burden
// partner2username PBurden
// 20 February 2012

// to represent a book
class Book{
  String title;
  String author;
  int price;
  
  Book(String title, String author, int price){
    this.title = title;
    this.author = author;
    this.price = price;
  }
  //Compares two books to check if their data is the same
  public boolean sameDataHelper(Book b1){
		return (this.title.equals(b1.title)) &&
				(this.author.equals(b1.author)) &&
						(this.price == (b1.price));
	}
  /*
	 * Template
	 * FIELDS
	 * ...this.title... --String
	 * ...this.author... --String
	 * ...this.price... --int
	 * METHODS:
	 *...this.sameDataHelper... --- Boolean
	 * METHODS FOR FIELDS:
	 */
}