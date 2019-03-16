
public class BookOrderByPrice implements ICompareBooks{
	public boolean isBefore(Book b1, Book b2){
		return (b1.price <= b2.price);
	}
	  /*
		 * Template
		 * FIELDS:
		 * METHODS:
		 *...this.isBefore... --- Boolean
		 * METHODS FOR FIELDS:
		 */
}
