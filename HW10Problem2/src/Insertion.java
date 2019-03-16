// Assignment 10 Problem 2
// Partner Patrick Burden
// partner1username pburden
// Partner Name2 Seydi Sy
// partner2username seydi
// 27 March 2012


import java.util.ArrayList;
import java.util.Comparator;


public class Insertion<T>{

	//Inserts the given elements into the already sorted list
	public void sortedInsert(ArrayList<T> list, Comparator<T> comp, T t){
		if(list.isEmpty()){
			list.add(t);
		}else{
		for(int index = 0; index < list.size(); index = index +1)
			if (comp.compare(t, list.get(index)) <= 0){
				list.add(index, t);
				index = list.size();
			}else if(index + 1 == list.size()){
				list.add(t);
				index = list.size();
			}
		}
	}
	//creates a new sorted list using sortedInsert from the given list
	//by creating a new list
	public ArrayList<T> insertionSort(ArrayList<T> list, Comparator<T> comp){
		ArrayList<T> temp = new ArrayList<T>();
		
		for(int loop = 0; loop < list.size(); loop = loop +1)
			this.sortedInsert(temp, comp, list.get(loop));
		
		return temp;
	}
	//creates a new sorted list using sortedInsert from the given list without
	//creating a new list
	public ArrayList<T> insertionSortInPlace(ArrayList<T> list, Comparator<T> comp){
		for(int index = 1; index < list.size(); index = index +1)
			if(this.moveLeft(list.get(index -1),list.get(index), comp)){
				list.add(index -1, list.get(index));
				list.remove(index + 1);
				if(index > 1){
					index = index - 2;
				}
			}
		return list;
	}
	//a boolean to help insertionSortInPlace
	//it checks to see if the first element comes before
	//the second element in a list
	public boolean moveLeft(T t1, T t2, Comparator<T> comp){
		return (comp.compare(t1, t2) >= 0);
	}
}