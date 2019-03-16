import java.util.Comparator;

// Assignment 8 Problem 3
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012
public class BST<T> implements IBST<T>{
	Comparator<T> comp;
	IBT<T> bt;
	public BST(Comparator<T> comp, IBT<T> bt){
		this.comp = comp;
		if(bt.accept(new IsSorted(comp))){
			this.bt = bt;
		}else{
			new RuntimeException("This is not a BST");
		}
	}
	public T min(){
		return bt.accept(new LeftMostVisitor<T>());
	}
	public T max(){
		return bt.accept(new RightMostVisitor<T>());
	}
	public IBST<T> insert(T elem){
		return new BST<T>(comp, bt.accept( new InsertVisitor<T>(elem, comp)));
	}
	public <S> S accept(IBTVisitor<T, S> v){
		return bt.accept(v);
	}
}
