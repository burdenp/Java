
// A visitor for the ILo<T> classes that 
// and produces the result of the type R
interface ILoVisitor<R, T>{
  // method for the empty list
  public R forMt(); 
  
  // method for the nonempty list
  public R forCons(T first, ILo<T> rest);
}

// A visitor that computes the total download time for all files 
// in the list of image files
class ILoImageDownloadTimeVisitor 
  implements ILoVisitor<Integer, Image>{
  
  int speed;
  ILoImageDownloadTimeVisitor(int speed){
    this.speed = speed;
  }

  // method for the empty list
  public Integer forMt(){
    return 0;
  }
  
  // method for the nonempty list
  public Integer forCons(Image first, ILo<Image> rest){
    return 
        first.fileSize / speed + rest.accept(this);
  }
}
