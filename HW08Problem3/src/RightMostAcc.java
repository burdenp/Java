// Assignment 8 Problem 3
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012
public class RightMostAcc<T> implements IBTVisitor<T, T>{
	T acc;
	public RightMostAcc(T acc){
	this.acc = acc;
	}
	public T visitNode(T val, IBT<T> left, IBT<T> right){
		return right.accept(new RightMostAcc<T>(val));
	 }
	public T visitLeaf(){
		 return acc;
	 }

}
