import tester.*;

/**
 * to represent a list of objects
 */
interface IList<T> extends Traversal<T>{

  /**
   * Is this an empty list?
   */
  public boolean isEmpty();  

  /**
   * Produce the first item in this list
   */
  public T getFirst();

  /** 
   * Produce a <code>Traversal</code> for the rest of this list
   */
  public Traversal<T> getRest();
}      


