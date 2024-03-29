import tester.Traversal;

/**
 * Encapsulate a function that consumes a data item
 * and an accumulator and produces a new value of the accumulator
 */
interface ITS2S<T, S>{
  S update(T t, S s);
}

/**
 * Encapsulate three implementations of loops traversing over
 * a data set generated by the functional <code>Traversal</code>
 * iterator and performing accumulator update specified by the
 * <code>ITS2S</code> function object
 */
class ForEach<T, S>{
  S acc;
  ITS2S<T, S> apply;
  Traversal<T> tr;
  
  ForEach(S acc, ITS2S<T, S> apply, Traversal<T> tr){
    this.acc = acc;
    this.apply = apply;
    this.tr = tr;
  }
  
  S compute1(){
    if (this.tr.isEmpty())
      return this.acc;
    else
      return (new ForEach<T, S>(this.apply.update(this.tr.getFirst(), this.acc),
          this.apply, this.tr.getRest())).compute1();
  }
  
  S compute2(){
    while (!this.tr.isEmpty()){
      this.acc = this.apply.update(this.tr.getFirst(), this.acc);
      this.tr = this.tr.getRest();
    }
    return this.acc;
  }
  
  S compute3(){
    for (; !this.tr.isEmpty(); this.tr = this.tr.getRest()){
      this.acc = this.apply.update(this.tr.getFirst(), this.acc);     
    }
    return this.acc;
  }
}

