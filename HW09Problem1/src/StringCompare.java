// Assignment 9 Problem 1
// Partner Patrick Burden
// partner1username pburden
// Partner Seydi Sy
// partner2username seydi
// 20 March 2012
import java.util.Comparator;

public class StringCompare implements Comparator<String>{
	StringCompare(){}
	
	//compares the 2 elements
	public int compare(String s1, String s2){
		return s1.compareTo(s2);
	}
}
