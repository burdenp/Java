
	// Assignment 7 Problem 1
	// Partner James Kandebo
	// partner1username Kandebo
	// Partner Patrick Burden
	// partner2username PBurden
	// 27 February 2012

//Head class
public class Head extends AbstNode{
	 String data;
	 AbstNode next;
	 AbstNode prev;
	  
	  Head(AbstNode next){
	   super("", next, null);
	    }
	  
		/*FIELDS:
		 * ...this.data... --String
		 * ...this.next... --AbstNode
		 * ...this.prev... --AbstNode
		 * METHODS:
		 *...this.size... --int
		 *...this.nextNodeData... --String
		 * ...this.dataList... --String
		 * METHODS FOR FIELDS:
		 * 
		 */
	  
	  //checks the size of the Deque
	  public int size(){
		  return 0  + next.size();
	  }
	  //returns the data from the next node
	  public String nextNodeData(){
		  return this.next.data;
	  }
	  //returns a string of all the data from the Deque
	  public String dataList(){
		  return this.data.concat(this.next.dataList());
	  }
}
