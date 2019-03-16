// Assignment 8 Problem 3
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012

//add constructor in the regular visitor

public class LeftMostVisitor<T> implements IBTVisitor<T, T>{
	LeftMostVisitor(){}
	 public T visitNode(T val, IBT<T> left, IBT<T> right){
		 return  left.accept(new LeftMostAcc<T>(val));
	 }
	 public T visitLeaf(){
		 throw new RuntimeException("There is no left most Node on a Leaf");
	 }
}
