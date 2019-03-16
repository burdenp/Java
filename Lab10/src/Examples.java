import java.util.*;
import tester.*;
import colors.*;

/**
 * The client class for the parametrized list classes, 
 * a <code>Traversal</code> wrapper for the <code>ArrayList</code>,
 * an <code>Algorithms</code> class that also uses the predicates that
 * implement the <code>ISelect</code> interface and examples of
 * these lists and methods using as data <code>Balloon</code> objects
 * 
 * @author Viera K. Proulx 
 * @since 17 March 2012
 */
public class Examples{
  
  public Examples(){}
  
  /** a big red <code>Balloon</code> */
  Balloon b1 = new Balloon(100, 200, 25, new Red());

  /** a small blue <code>Balloon</code> */
  Balloon b2 = new Balloon(200, 100, 20, new Blue());
  
  /** a big green <code>Balloon</code> */
  Balloon b3 = new Balloon(200, 150, 30, new Green());
  
  /** a small red <code>Balloon</code> */
  Balloon b4 = new Balloon(200, 120, 22, new Red());

  IList<Balloon> mtb = new MTList<Balloon>();
  
  /** a list with two red balloons and two small balloons */
  IList<Balloon> blist = new ConsList<Balloon>(this.b1,
      new ConsList<Balloon>(this.b2,
          new ConsList<Balloon>(this.b3,
              new ConsList<Balloon>(this.b4, this.mtb))));

  /** a list with no red balloons */
  IList<Balloon> blistNoRed = new ConsList<Balloon>(this.b2,
      new ConsList<Balloon>(this.b3, this.mtb));
 
  /** a list with no small balloons */
  IList<Balloon> blistNoSmall = new ConsList<Balloon>(this.b1,
      new ConsList<Balloon>(this.b3, this.mtb));
  
  /**
   * A method to construct an <code>ArrayList</code>
   * with four <code>Balloon</code>s 
   * 
   * @return an <code>ArrayList</code> with four <code>Balloon</code>s
   */
  public ArrayList<Balloon> makeArrBlist(){
    ArrayList<Balloon> arrlist = new ArrayList<Balloon>();
    arrlist.add(this.b1);
    arrlist.add(this.b2);
    arrlist.add(this.b3);
    arrlist.add(this.b4);
    return arrlist;
  }
  
  /**
   * A method to construct an <code>ArrayList</code>
   * with no red <code>Balloon</code>s 
   * 
   * @return an <code>ArrayList</code> with no red <code>Balloon</code>s
   */
  public ArrayList<Balloon> makeArrBlistNoRed(){
    ArrayList<Balloon> arrlist = new ArrayList<Balloon>();
    arrlist.add(this.b2);
    arrlist.add(this.b3);
    return arrlist;
  }
 
  /**
   * A method to construct an <code>ArrayList</code>
   * with no small <code>Balloon</code>s 
   * 
   * @return an <code>ArrayList</code> with no small <code>Balloon</code>s
   */
  public ArrayList<Balloon> makeArrBlistNoSmall(){
    ArrayList<Balloon> arrlist = new ArrayList<Balloon>();
    arrlist.add(this.b1);
    arrlist.add(this.b3);
    return arrlist;
  }
  
  /** a <code>Traversal</code> for <code>ArrayList</code>
   * with four <code>Balloon</code>s */
  WrapAL<Balloon> arrblist = 
    new WrapAL<Balloon>(this.makeArrBlist());

  /** a <code>Traversal</code> for <code>ArrayList</code>
   * with no red <code>Balloon</code>s */
  WrapAL<Balloon> arrblistNoRed = 
    new WrapAL<Balloon>(this.makeArrBlistNoRed());

  /** a <code>Traversal</code> for <code>ArrayList</code>
   * with no small <code>Balloon</code>s */
  WrapAL<Balloon> arrblistNoSmall = 
    new WrapAL<Balloon>(this.makeArrBlistNoSmall());

  
  /** Balloon class tests: equality */
  public void testEquality(Tester t){
    t.checkExpect(this.b2, new Balloon(200, 100, 20, new Blue()),
        "the same balloons OK");
    t.checkExpect(this.b2, this.b2, "the same balloons OK");
  }
  
  /** Balloon class tests: the distanceFromTop method */
  public void testDistanceFromTop(Tester t){
    t.checkExpect(this.b1.distanceFromTop(), 200 - 25, "distanceFromTop 1");
    t.checkExpect(this.b2.distanceFromTop(), 80, "distanceFromTop 2");
  }
  
  /** A predicate function object for red <code>Balloon</code>s */
  Predicate<Balloon>  redBalloon = new RedBalloon();
  
  /** A predicate function object for red <code>Balloon</code>s */
  Predicate<Balloon> smallBalloon = new SmallBalloon(23);
  
  /** ISelect classes tests: RedBalloon and SmallBalloon */ 
  public void testSelectors(Tester t){
    t.checkExpect(this.redBalloon.apply(this.b1), true, "red balloon - true");
    t.checkExpect(this.redBalloon.apply(this.b2), false, "red balloon - false");
    
    t.checkExpect(this.smallBalloon.apply(this.b2), true, "small balloon - true");
    t.checkExpect(this.smallBalloon.apply(this.b1), false, "small balloon - false");
  }
  
  /** An instance of the <code>Algorithms</code> class */
  Algorithms algo = new Algorithms();
  
  /** Algorithms methods tests: contains */ 
  public void testContains(Tester t){
    t.checkExpect(this.algo.orMapBasic(this.blist, this.redBalloon), true);
    t.checkExpect(this.algo.orMapBasic(this.blistNoRed, this.redBalloon), false);
    t.checkExpect(this.algo.orMapBasic(this.blist, this.smallBalloon), true);
    t.checkExpect(this.algo.orMapBasic(this.blistNoSmall, this.smallBalloon), false);


    t.checkExpect(this.algo.orMapBasic(this.arrblist, this.redBalloon), true);
    t.checkExpect(this.algo.orMapBasic(this.arrblistNoRed, this.redBalloon), false);
    t.checkExpect(this.algo.orMapBasic(this.arrblist, this.smallBalloon), true);
    t.checkExpect(this.algo.orMapBasic(this.arrblistNoSmall, this.smallBalloon), false);
  }

  /** Algorithms methods tests: countSuch */ 
  public void testCountSuch(Tester t){
    t.checkExpect(this.algo.countSuch(this.blist, this.redBalloon), 2);
    t.checkExpect(this.algo.countSuch(this.blist, this.smallBalloon), 2);

    t.checkExpect(this.algo.countSuch(this.arrblist, this.redBalloon), 2);
    t.checkExpect(this.algo.countSuch(this.arrblist, this.smallBalloon), 2);
  }
  
  /** The update method function class for selecting a balloon */
  class ContainsRedBalloon implements ITS2S<Balloon, Boolean>{
    Predicate<Balloon> pick;

    ContainsRedBalloon(Predicate<Balloon> pick){
      this.pick = pick;
    }

    public Boolean update(Balloon b, Boolean acc){
      if (this.pick.apply(b))
        return true || acc;
      else
        return acc;
    }
  }

  /** An instance of update function for selecting red balloons */
  ITS2S<Balloon, Boolean> containsRedBalloon 
    = new ContainsRedBalloon(this.redBalloon);

  /** An instance of the ForEach loop methods class for 'contains red balloon' problem */
  ForEach<Balloon, Boolean> containsRedBalloonBlist =
    new ForEach<Balloon, Boolean>((Boolean)false,
                                  this.containsRedBalloon,
                                  (Traversal<Balloon>)this.blist);

  /** An instance of the ForEach loop methods class 
   *  for 'contains small balloon' problem */
  ForEach<Balloon, Boolean> containsSmallBalloonBlist =
    new ForEach<Balloon, Boolean>(
        (Boolean)false,
        new ITS2S<Balloon, Boolean>(){
          public Boolean update(Balloon b, Boolean acc){
            if (smallBalloon.apply(b))
              return true || acc;
            else
              return acc;
          }
        },
        (Traversal<Balloon>)this.blist);
 
  /** An instance of the ForEach loop methods class
   *  for 'contains small balloon' problem */
  ForEach<Balloon, Boolean> containsSmallBalloonArrlist =
    new ForEach<Balloon, Boolean>(
        (Boolean)false,
        new ITS2S<Balloon, Boolean>(){
          public Boolean update(Balloon b, Boolean acc){
            if (smallBalloon.apply(b))
              return true || acc;
            else
              return acc;
          }
        },
        (Traversal<Balloon>)this.arrblistNoSmall);


  /** Algorithms methods tests: contains */
  public void testContainsForEach(Tester t){
    t.checkExpect(this.containsRedBalloonBlist.compute1(), true);
    t.checkExpect(this.containsRedBalloonBlist.compute2(), true);
    t.checkExpect(this.containsRedBalloonBlist.compute3(), true);

    t.checkExpect(this.containsSmallBalloonBlist.compute1(), true);
    t.checkExpect(this.containsSmallBalloonBlist.compute2(), true);
    t.checkExpect(this.containsSmallBalloonBlist.compute3(), true);

    t.checkExpect(this.containsSmallBalloonArrlist.compute1(), false);
    t.checkExpect(this.containsSmallBalloonArrlist.compute2(), false);
    t.checkExpect(this.containsSmallBalloonArrlist.compute3(), false);
}




  /**
   * Run all tests
   * 
   * @param t the <CODE>{@link Tester Tester}</CODE> that performs the tests
   */
  
  /*
  public void tests(Tester t){

    testEquality(t);
    testDistanceFromTop(t);
    testSelectors(t);
    testContains(t);
    testCountSuch(t);
    testContainsForEach(t);
  }
  */

}