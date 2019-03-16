
// Represents a Book
public class Book implements IValue, MakeString, ITransform{
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
    public Object transform(ITransform T){
    	return this.title;
    }
}