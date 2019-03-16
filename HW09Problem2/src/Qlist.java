// Assignment 9 Problem 2
// Partner Patrick Burden
// partner1username pburden
// Partner Seydi Sy
// partner2username seydi
// 20 March 2012

public class Qlist<T> implements DataSet<T>{
	Head<T> front;
	Tail<T> tail;
	int count;
	Qlist(){
		this.front = new Head<T>(null, null);
		this.tail = new Tail<T>(null, front);
		this.count = 0;
		this.front.next = tail;
	}
	 /**
	   * Add the given item to this data set
	   * 
	   * @param t the given data item
	   */
	public void add(T t){
		Node<T> tNode = new Node<T>(t, tail);
		this.tail.next.next = tNode;
		this.tail.next = tNode;
		this.count = this.count + 1;
	}
	/**
	   * EFFECT: remove an item from this data set
	   * 
	   * @return the item that has been removed
	   * @throws a RuntimeException if this data set is empty
	   */
	public T remove(){
		Node<T> tNode = this.front.next;
		this.front.next = this.front.next.next;
		this.count = this.count - 1;
		return tNode.data;
	}
	/**
	   * Produce the number of items in this queue
	   * @return the the number of items in this data set
	   */
	public int size(){
		return this.count;
		
	}
	 /**
	   * Produce the 'next to be removed' item in this data set
	   * @return the desired item
	   */
	public T current(){
		return this.front.next.data;
	}
}
