// Assignment 8 Problem 3
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012
public class Node<T> implements IBT<T>{
	T val;
	IBT<T> left;
	IBT<T> right;
	public Node(T val, IBT<T> left, IBT<T> right){
		this.val = val;
		this.left = left;
		this.right = right;
	}
	public <S> S accept(IBTVisitor<T, S> v){
		return v.visitNode(val, left, right);
	}
}
