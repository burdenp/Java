
public interface IList<T> {

}

class MT<T> implements IList<T> {

}

class Cons<T> implements IList<T> {
	T first;
	IList<T> rest;
	
	public Cons(T first, IList<T> rest) {
		this.first = first;
		this.rest = rest;
	}
}
