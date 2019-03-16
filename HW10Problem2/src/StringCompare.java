// Assignment 10 Problem 2
// Partner Patrick Burden
// partner1username pburden
// Partner Name2 Seydi Sy
// partner2username seydi
// 27 March 2012

import java.util.Comparator;

public class StringCompare implements Comparator<String>{
	StringCompare(){}
	
	//compares the 2 elements
	public int compare(String s1, String s2){
		return s1.compareTo(s2);
	}
}
