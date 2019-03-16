import java.util.Comparator;

// Assignment 8 Problem 3
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012

public class ICompareString implements Comparator<String>{
	ICompareString(){}
	
	public int compare(String s1, String s2){
		if(s1.compareTo(s2) == 0){
			return 0;
		}else if(s1.compareTo(s2) < 0){
			return 1;
		}
		else{
			return -1;
		}
	}
}
