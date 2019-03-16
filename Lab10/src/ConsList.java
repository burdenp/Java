import tester.*;

/**
 * to represent a nonempty list of objects
 */
class ConsList<T> implements IList<T>{

  T first;
  IList<T> rest;

  ConsList(T first, IList<T> rest){
    this.first=first;
    this.rest=rest;
  }
  

  /**
   * Is this an empty list?
   */
  public boolean isEmpty(){ return false; }  

  /**
   * Produce the first item in this list
   */
  public T getFirst(){
    return this.first;
  }

  /** 
   * Produce a <code>Traversal</code> for the rest of this list
   */
  public Traversal<T> getRest(){
    return this.rest;
  }
} 
