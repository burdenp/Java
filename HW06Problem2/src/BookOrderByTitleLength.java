
public class BookOrderByTitleLength implements ICompareBooks {
	public boolean isBefore(Book b1, Book b2){
		return (b1.title.length() <= b2.title.length());
	}
	  /*
		 * Template
		 * FIELDS:
		 * METHODS:
		 *...this.isBefore... --- Boolean
		 * METHODS FOR FIELDS:
		 */
}
