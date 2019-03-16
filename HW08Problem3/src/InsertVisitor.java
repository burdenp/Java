import java.util.Comparator;

// Assignment 8 Problem 3
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012

public class InsertVisitor<T> implements IBTVisitor<T, IBT<T>>{
	T elem;
	Comparator<T> comp;
	InsertVisitor(T elem, Comparator<T> comp){
		this.elem = elem;
		this.comp = comp;
	}
	 public IBT<T> visitNode(T val, IBT<T> left, IBT<T> right){
		 if(comp.compare(val, this.elem) == -1){
				return new Node(val, left.accept(new InsertVisitorAcc<T>(elem, comp, val)), right);
		} else if(comp.compare(val, this.elem) == 1){
			return new Node(val ,left, right.accept(new InsertVisitorAcc<T>(elem, comp, val)));
		}else{
			return new Node(elem, new Leaf<T>(), new Node(val, left, right));
		}
	 }
	 public IBT<T> visitLeaf(){
		 return new Node(elem, new Leaf<T>(), new Leaf<T>());
	 }
}
