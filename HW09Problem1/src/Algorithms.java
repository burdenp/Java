// Assignment 9 Problem 1
// Partner Patrick Burden
// partner1username pburden
// Partner Seydi Sy
// partner2username seydi
// 20 March 2012
import java.util.ArrayList;
import java.util.Comparator;


public class Algorithms {
	Algorithms(){}
	
	//searches for the object using a binary search
	public <T> int binarySearch(int lower, int upper, ArrayList<T> list, 
			Comparator<T> comp, T object){
		if(lower == upper){
			throw
			new RuntimeException("Object is not in list");
		}else if(comp.compare(list.get((lower + upper) / 2), object) == 0){
			return ((lower + upper)/ 2);
		}else if(comp.compare(list.get((lower + upper)/ 2), object) == 1 ){
			return 
					this.binarySearch(lower,
							((lower + upper)/ 2), list, comp, object);
		}else{
			return 
					this.binarySearch(((lower + upper)/ 2),
							upper, list, comp, object);
		}
	}
}
