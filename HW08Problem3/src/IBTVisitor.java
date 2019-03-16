// Assignment 8 Problem 3
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012
public interface IBTVisitor<T, S> {
	 S visitNode(T val, IBT<T> left, IBT<T> right);
	 S visitLeaf();
}