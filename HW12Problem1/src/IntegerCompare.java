// Assignment 12 Problem 1
// Partner Patrick Burden
// partner1username pburden
// Partner Name2 Seydi Sy
// partner2username seydi
// 10 April 2012

import java.util.Comparator;

public class IntegerCompare implements Comparator<Integer>{
	IntegerCompare(){}
	
	//compares the 2 elements
	public int compare(Integer s1, Integer s2){
		if(s1 < s2){
			return -1;
		}else if(s1 == s2){
			return 0;
		}else{
			return 1;
		}
	}
}
