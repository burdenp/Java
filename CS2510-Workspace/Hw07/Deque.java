
	// Assignment 7 Problem 2
	// Partner James Kandebo
	// partner1username Kandebo
	// Partner Patrick Burden
	// partner2username PBurden
	// 27 February 2012
public class Deque{
	  AbstNode head;
	  AbstNode tail;
	  
	  Deque(){
	   this.head =  new Head(this.tail);
	   this.tail =  new Tail(this.head);
	    }
	  public AbstNode addToHeadNode(AbstNode n){
		  this.head.next = n;
		  this.head.next.prev = n;
		  n.next = this.head.next;
		  n.prev = this.head;
		  return this.head;
	  }
	  public AbstNode addToTailNode(AbstNode n){
		  this.tail.prev = n;
		  this.tail.prev.next = n;
		  n.prev = this.tail.prev;
		  n.next = this.tail;
		  return this.head;
	  }
	  public void addAtHead(String st){
		  addToHeadNode(new Node(st, null, null));
	  }
	  public void addAtTail(String st){
		  addToTailNode(new Node(st, null, null));
	  }
}
