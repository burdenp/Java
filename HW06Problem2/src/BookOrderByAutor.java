
public class BookOrderByAutor implements ICompareBooks {
	 // does b1 come before b2 in this tree?
	public boolean isBefore(Book b1, Book b2){
		return (b1.author.compareTo(b2.author) <= 0);
	}
	  /*
		 * Template
		 * FIELDS:
		 * METHODS:
		 *...this.isBefore... --- Boolean
		 * METHODS FOR FIELDS:
		 */
}
