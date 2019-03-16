// Assignment 8 Problem 1
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012

// An interface for classes that can compute their value
interface IValue{
    // Compute the value of this instance
    public int value();
}

// An interface for classes that can represent their values as a String
interface MakeString{
  // produce a String that represents this object
  public String makeString();
}


// Represents a list of items of type T
interface ILo<T>{
  
    // Compute the total size (length) of this list
    public int size();
   
    // Compute the total value of the items in this list
    public int totalValue();
    
    // produce a String that represents this object
    public ILo<String> makeStrings();

    // accept the visitor that produces the result of the type R
    public <R> R accept(ILoVisitor<R, T> ilov);
    
    // Produce a list with items of type S from this
    //  list  of items of type T by applying the
    //  given function to every item in this list
    public < S> ILo< S> map(ITransform< T, S> tr);
    
    public  ILo filter(ISelect se);
    
    public Object findItem(Object obj);
}                                

// Represents an empty list of items of type T
class MtLo<T> implements ILo<T>{
    MtLo(){}
  
    // Compute the total size (length) of this empty list
    public int size(){
        return 0;
    }
   
    // Compute the total value of this empty list
    public int totalValue(){
        return 0;
    }

    public ILo<String> makeStrings(){
    	return new MtLo<String>();
    }

    // accept the visitor that produces the result of the type R
    public <R> R accept(ILoVisitor<R, T> ilov){
      return ilov.forMt();
    }
    // Produce a list with items of type S from this
    //  list  of items of type T by applying the
    //  given function to every item in this list
    public < S> ILo< S> map(ITransform< T, S> transform){
    	return new MtLo<S>();
    }
    public  ILo filter(ISelect se){
    	return new MtLo();
    }
    public Object findItem(Object obj){
    	 throw new NoSuchElementException(
                 "No such Object in List");
    }
}                                              

// Represents a nonempty list of items of type T
class ConsLo<T> implements ILo<T>{
    T first;
    ILo<T> rest;
  
    ConsLo(T first, ILo<T> rest){
        this.first = first;
        this.rest = rest;
    }
  
    /* Template:
     *   Fields:
     *     ... this.first ...    -- T
     *     ... this.rest ...     -- ILo<T>
     *
     *   Methods:
     *     ... this.size() ...            -- int
     *     ... this.totalValue() ...      -- int
     *     ...this.makeStrings()...       --ILo<String>
     *     ...this.map(ITransform< T,S> tr) --ILo<S>
     *     ...this.filter(ISelect se) --ILo
     *     ...this.findItem(Object obj)  --Object
     *   Methods for Fields:
     *     ... this.rest.size() ...       -- int
     *     ... this.rest.totalValue() ... -- int
     *     ...this.rest.makeStrings()...       --ILo<String>
     *     ...this.rest.map(ITransform< T,S> tr) --ILo<S>
     *     ...this.rest.filter(ISelect se) --ILo
     *     ...this.rest.findItem(Object obj)  --Object
     */
  
    // Compute the total size (length) of this nonempty list
    public int size(){
        return 1 + this.rest.size();
    }
   
    // Compute the total value of this nonempty list
    public int totalValue(){
        return ((IValue)this.first).value() + this.rest.totalValue();
    }
    
    public ILo<String> makeStrings(){
    	return new ConsLo<String>(((MakeString)this.first).makeString(), this.rest.makeStrings());
    }
    // Produce a list with items of type S from this
    //  list  of items of type T by applying the
    //  given function to every item in this list
    public <S> ILo<S> map(ITransform< T, S> tr){
    	return new ConsLo<S>(tr.transform(this.first), this.rest.map(tr));
    }
    
    public  ILo filter(ISelect se){
    	if(se.select(this.first)){
    	return new ConsLo (this.first, this.rest.filter(se));
    	}else{
    		return this.rest.filter(se);
    	}
    }
    
    public Object findItem(Object obj){
    	 if (this.first.equals(obj))
    		   return this;
    		  else
    		    return this.rest.findItem(obj);
    }
    // accept the visitor that produces the result of the type R
    public <R> R accept(ILoVisitor<R, T> ilov){
      return ilov.forCons(this.first, this.rest);
    }
}            

