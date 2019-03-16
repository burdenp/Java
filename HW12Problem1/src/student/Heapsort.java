package student;

import java.util.ArrayList;
import java.util.Comparator;

public class Heapsort<T> extends SortingHeapSort<T>{
  
  public ArrayList<T> heapsort(ArrayList<T> alist, Comparator<T> comp) {
    // TODO Auto-generated method stub
	  ArrayList<T> tempList = new ArrayList<T>();
	  tempList.add(null);
	  PriorityQueue<T> temp = new PriorityQueue<T>(tempList, comp);
	  for(int index = 0; index < alist.size(); index = index +1)
		  temp.insert(alist.get(index));
	  
    return temp.list;
  }
  
}