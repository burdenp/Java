package student;
// Assignment 12 Problem 1
// Partner Patrick Burden
// partner1username pburden
// Partner Name2 Seydi Sy
// partner2username seydi
// 10 April 2012

import java.util.ArrayList;
import java.util.Comparator;

public class PriorityQueue<T> {
	ArrayList<T> list;
	Comparator<T> comp;
	
	PriorityQueue(ArrayList<T> list, Comparator<T> comp){
		this.list = list;
		this.comp = comp;
	}
	//returns true if the given index for a node is a leaf or false if not
	public boolean isLeaf(int i){
		if(i * 2 > list.size()){
			return true;
		}else return false;
	}
	//returns the index of the highest priority child
	//that a node at index i has
	public int higherPriorityChild(int i){
		if(i * 2 <= list.size()){
			return i * 2;
		}else{
			throw new RuntimeException("No children");
		}
	}
	//inserts an element into an already sorted list
	public void insert(T var){
		list.add(var);
		int loc = list.size() -1;
		while(loc > 1 && comp.compare(var, list.get(loc/2))  > 0){
			T temp = list.get(loc/2);
			list.set(loc/2, var);
			list.set(loc, temp);
			loc = loc/2;
			}
	}
	//removes the top element in the list and then resorts the list.
	public void remove(){
		ArrayList<T> temp = (ArrayList<T>) list.clone();
		temp.remove(0);
		temp.remove(0);
		list.clear();
		list.add(null);
		for(int index = 0; index < temp.size(); index = index +1)
			this.insert(temp.get(index));
		
	}
	
}
