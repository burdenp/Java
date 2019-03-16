	// Assignment 7 Problem 1
	// Partner James Kandebo
	// partner1username Kandebo
	// Partner Patrick Burden
	// partner2username PBurden
	// 27 February 2012

	// class tail
	public class Tail extends AbstNode{
	 String data;
	 AbstNode next;
	 AbstNode prev;
	  
	  Tail(AbstNode prev){
		  super("", null, prev);
	    }
	  
		/*FIELDS:
		 * ...this.data... --String
		 * ...this.next... --AbstNode
		 * ...this.prev... --AbstNode
		 * METHODS:
		 * ...this.dataList... --String
		 * METHODS FOR FIELDS:
		 * 
		 */
	  
	  // returns the data from the rest of the Deque as a string
	  public String dataList(){
		  return this.data;
	  }

}
