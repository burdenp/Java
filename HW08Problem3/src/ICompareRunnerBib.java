import java.util.Comparator;


// Assignment 8 Problem 3
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012

public class ICompareRunnerBib implements Comparator<Runner>{
	ICompareRunnerBib(){}
	
	public int compare(Runner r1, Runner r2){
		if(r1.bib == r2.bib){
			return 0;
		}else if(r1.bib < r2.bib){
			return 1;
		}
		else{
			return -1;
		}
	}
}
