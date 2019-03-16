// Assignment 8 Problem 3
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012
public class Leaf<T> implements IBT<T>{
	 Leaf(){}
	 public <S> S accept(IBTVisitor<T, S> v){
		 return v.visitLeaf();
	 }
}
