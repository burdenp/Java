import java.util.Comparator;

// Assignment 8 Problem 3
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012

public class ICompareRunnerAge implements Comparator<Runner>{
	ICompareRunnerAge(){}
	
	public int compare(Runner r1, Runner r2){
		if(r1.age == r2.age){
			return 0;
		}else if(r1.age < r2.age){
			return -1;
		}
		else{
			return 1;
		}
	}
}
