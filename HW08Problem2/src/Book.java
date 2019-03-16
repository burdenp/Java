// Assignment 8 Problem 2
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012

//copied code from problem one that inclueds answer to problem 2
//since they are both from the same lab and use
//all the same classess

// Represents a Book
public class Book implements IValue, MakeString{
    String title;
    String author;
    Integer price;     // in dollars
    
    public Book(String title, String author, Integer price){
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    /* Template
     *   Fields
     *     ... this.title ...       -- String
     *     ... this.author ...      -- String
     *     ... this.price ...       -- Integer
     *
     *   Methods 
     *     ... this.value() ...       -- int
     *     ... this.makeString() ...  -- String
     *     ... authorName() ...       -- String
     */
    
    // Compute the value of this Book, i.e., its price
    public int value(){
        return this.price;
    }
    public String makeString(){
    	return "Book: ".concat(this.title.concat(" by ").concat(this.author)
    			.concat("\ncosts: $").concat(this.price.toString()));
    }
 // produce the author of this book
 // throw an exception if no name is known
 public String authorName() throws NoSuchElementException{
   if (this.author.equals(""))
     throw new NoSuchElementException(
               "No author for the book " + this.title);
   else
     return this.author;
 }
}