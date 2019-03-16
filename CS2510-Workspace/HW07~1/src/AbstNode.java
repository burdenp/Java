
	// Assignment 7 Problem 2
	// Partner James Kandebo
	// partner1username Kandebo
	// Partner Patrick Burden
	// partner2username PBurden
	// 27 February 2012
public abstract class AbstNode {
		  String data;
		  AbstNode next;
		  AbstNode prev;
		  AbstNode(String data, AbstNode next, AbstNode prev){
			   this.data = data;
			   this.next = next;
			   this.prev = prev;
			    }
		  
			/*FIELDS:
			 * ...this.data... --String
			 * ...this.next... --AbstNode
			 * ...this.prev... --AbstNode
			 * METHODS:
			 * ...this.addAfterNode... 
			 *...this.size... --int
			 * ...this.insertSorted...
			 * ...this.removeSorted...
			 * ...this.dataList... --String
			 * METHODS FOR FIELDS:
			 * 
			 */
		  
		//reutrns an integer equal to the size of the Deque
		  public int size(){
			  return 0;
		  }
		//inserts a node into a sorted list
		  public void insertSorted(String s){
			 this.prev.addAfterNode(new Node(s, null, null));
			  }
		  //adds a node after the given node
		 public AbstNode addAfterNode(AbstNode n){
			 n.next = this.next.next;
		     n.prev = this.next;
		     this.next.next.prev = n;
		     this.next = n;			 
				 return this;
			 }
		 //returns a string of all the data from the Deque
		 public String dataList(){
			  return this.toString().concat(this.next.dataList());
		  }
		//removes a node from a sorted list
		 public void removeSorted(String s){
			  throw new RuntimeException("Node does not exist");
		  }
	}


