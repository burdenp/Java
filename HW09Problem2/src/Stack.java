// Assignment 9 Problem 2
// Partner Patrick Burden
// partner1username pburden
// Partner Seydi Sy
// partner2username seydi
// 20 March 2012
import java.util.ArrayList;


public class Stack<T> implements DataSet<T>{
	ArrayList<T> list;
	Stack(ArrayList<T> list){
		this.list = list;
	}
	/**
	   * EFFECT: remove an item from this data set
	   * 
	   * @return the item that has been removed
	   * @throws a RuntimeException if this data set is empty
	   */
	public T remove(){
		T first = list.get(0);
		list.remove(0);
		return first;
	}
	/**
	   * Produce the number of items in this queue
	   * @return the the number of items in this data set
	   */
	 public int size(){
		 return list.size();
	 }
	 /**
	   * Produce the 'next to be removed' item in this data set
	   * @return the desired item
	   */
	 public T current(){
		return list.get(0); 
	 }
	 /**
	   * Add the given item to this data set
	   * 
	   * @param t the given data item
	   */
	 public void add(T t){
		 list.add(0, t);
	 }
}
