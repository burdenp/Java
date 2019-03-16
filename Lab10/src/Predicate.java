/** 
 * Interface to represent a predicate
 * 
 * @author Viera K. Proulx
 */
public interface Predicate<T> {
  
	/** 
	 * Return true if the given object should be selected 
	 *
	 * @param t the object to consider
	 */
	public boolean apply(T t);
}
