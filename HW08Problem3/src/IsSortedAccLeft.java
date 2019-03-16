import java.util.Comparator;

// Assignment 8 Problem 3
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012
public class IsSortedAccLeft<T> implements IBTVisitor<T, Boolean>{
	Comparator<T> comp;
	T acc;
	public IsSortedAccLeft(Comparator<T> comp, T acc){
	this.acc = acc;
	this.comp = comp;
	}
	public Boolean visitNode(T val, IBT<T> left, IBT<T> right){
		if(comp.compare(acc, val) == 1){
			return left.accept(new IsSortedAccLeft<T>(comp, val)) 
					&& right.accept(new IsSortedAccRight<T>(comp, val));
		}else{
			return false;
		}
	 }
	public Boolean visitLeaf(){
		 return true;
	 }

}