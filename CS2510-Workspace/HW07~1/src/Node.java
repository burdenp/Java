	
// Assignment 7 Problem 1
	// Partner James Kandebo
	// partner1username Kandebo
	// Partner Patrick Burden
	// partner2username PBurden
	// 27 February 2012

	//Node Class
	public class Node extends AbstNode{
	  String data;
	  Node next;
	  Node prev;
	  
	Node(String data, AbstNode next, AbstNode prev){
			  super(data, next, prev);
	    }
	
	
	/*FIELDS:
	 * ...this.data... --String
	 * ...this.next... --Node
	 * ...this.prev... --Node
	 * METHODS:
	 * ...this.addAfterNode... 
	 *...this.removeNode...
	 *...this.size... --int
	 * ...this.insertSorted...
	 * ...this.removeSorted...
	 * ...this.dataList... --String
	 * METHODS FOR FIELDS:
	 * 
	 */
	
	
	
	
	
		//adds a node after the given node
	 public void addAfterNode(Node n){
		  n.next = this.next.next;
		  n.prev = this.next.next;
		  this.next.next.prev = n;
		  this.next = n;		
	  }
	 //removes a node
	 public void removeNode(){
		 this.next.prev = this.prev;
		 this.prev.next = this.next;
	 }
	//checks the size of the Deque
	  public int size(){
		  return + 1 + this.next.size();
	  }
	//inserts a node into a sorted list
	  public void insertSorted(String s){
		  if(this.next.data.compareTo(s) == 0){
			  this.addAfterNode(new Node(s, null, null));
		  }
		  if(this.next.data.compareTo(s) == -1){
				  this.prev.addAfterNode(new Node(s, null, null));
		  }else{
			  this.next.insertSorted(s);
		  }
	  }
	  //removes a node from the sorted list
	  public void removeSorted(String s){
		  if(this.next.data.compareTo(s) == 0){
			  this.next.removeNode();
		  }else{
			  this.next.removeSorted(s);
		  }
	  }
	  // returns a string containing the data from all the nodes
	  public String dataList(){
		  return this.data.concat(this.next.dataList());
	  }
}
