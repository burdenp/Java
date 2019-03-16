
	// Assignment 7 Problem 2
	// Partner James Kandebo
	// partner1username Kandebo
	// Partner Patrick Burden
	// partner2username PBurden
	// 27 February 2012

	//class Deque
	public class Deque{
	  AbstNode head;
	  AbstNode tail;
	  
	  Deque(){
	   this.head =  new Head(this.tail);
	   this.tail =  new Tail(this.head);
	   this.head.next = this.tail;
	    }
	  
		/*FIELDS:
		 * ...this.head... --AbstNode
		 * ...this.tail... --AbstNode
		 * METHODS:
		 *...this.addToHeadNode... --AbstNode
		 *...this.addToTailNode... --AbstNode
		 * ...this.addAtHead... 
		 * ...this.addAtTail...
		 * ...this.size...   --int
		 * ...this.removeFromHead... --String
		 * ...this.removeFromTail... --String
		 * ...this.insertSorted... 
		 * ...this.removeSorted...
		 * ...this.toLowerCase...  --String
		 * METHODS FOR FIELDS:
		 * 
		 */
	  
	  //Helper method for addAtHead
	  public AbstNode addToHeadNode(AbstNode n){
		  n.next = this.head.next;
		  n.prev = this.head;
		  this.head.next.prev = n;
		  this.head.next = n;
		  return this.head;
	  }
	  //Helper method for AddAtTail
	  public AbstNode addToTailNode(AbstNode n){
		  n.prev = this.tail.prev;
		  n.next = this.tail;
		  this.tail.prev.next = n;
		  this.tail.prev = n;		 
		  return this.head;
	  }
	  //adds a node to the Deque after the head node
	  public void addAtHead(String st){
		  addToHeadNode(new Node(st, null, null));
	  }
	// adds a node to the Deque before the tail node
	  public void addAtTail(String st){
		  addToTailNode(new Node(st, null, null));
	  }
	  //reutrns an integer equal to the size of the Deque
	  public int size(){
		  return head.size();
	  }
	  // removes a node from the beginning of the Deque
	  public String removeFromHead(){
		  if(this.head.next.data.equals("")){
			  throw new RuntimeException("Can not remove from empty List");
		  }else{
		  this.head.next = this.head.next.next;
		  this.head.next.next.prev = head;
		  return this.head.next.data;
		  }
	  }
	// removes a node from the end of the Deque
	  public String removeFromTail(){
		  if(this.head.next.data.equals("")){
			  throw new RuntimeException("Can not remove from empty List");
		  }else{
		  this.tail.prev = this.tail.prev.prev;
		  this.tail.prev.prev.next = tail;
		  return this.tail.prev.data;
		  }
	  }
	  	//inserts a node into a sorted list
	  public void insertSorted(String s){
		  if(this.head.next.data.compareTo(s) == 0){
			  this.addAtHead(s);
		  }else{
			  this.head.next.insertSorted(s);
		  }
	  }
	  //removes a node from a sorted list
	  public void removeSorted(String s){
		  if(this.head.next.data.compareTo(s) == 0){
			  this.removeFromHead();
		  }else{
			  this.head.next.removeSorted(s);
		  }
	  }
	  //Returns a string of all data from the list in lowercase letters
	  public String toLowerCase(){
		return head.dataList().toLowerCase();
	  }
}
