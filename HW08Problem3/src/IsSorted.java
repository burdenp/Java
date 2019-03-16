import java.util.Comparator;

// Assignment 8 Problem 3
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012
public class IsSorted<T, S> implements IBTVisitor<T, Boolean>{
	Comparator<T> comp;
	public IsSorted(Comparator<T> comp){
		this.comp = comp;
	}
	public Boolean visitNode(T val, IBT<T> left, IBT<T> right){
		return left.accept(new IsSortedAccLeft<T>(comp, val)) 
				&& right.accept(new IsSortedAccRight<T>(comp, val));
	}
	public  Boolean visitLeaf(){
		return true;
	}
}
