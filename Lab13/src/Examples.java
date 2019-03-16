import java.awt.Color;
import java.util.*;
import tester.*;

/**
 * A sample of tests for the classes that handle user interactions
 * with the <code>Balloon</code> data.
 * 
 * @author Viera K. Proulx
 * @since 4 April 2008
 */
public class Examples implements IExamples{

  public Examples(){}

  /** sample Balloon instance */
  Balloon b1 = new Balloon(100, 200, 25, Color.red);
  
  /** another sample Balloon instance */
  Balloon b2 = new Balloon(200, 100, 25, Color.blue);

  /**
   * The test suite for the class <code>Balloon</code>
   * @param t The instance of the <code>Tester</code> that manages the tests
   */
  public void tests(Tester t){
    // test the methods 'equal' in the class Balloon
    t.checkExpect(new Balloon(200, 100, 25, Color.blue), b2, "equal");

    // test the methods 'hashCode' in the class Balloon
    t.checkExpect((new Balloon(200, 100, 25, Color.blue)).hashCode(), 
        b2.hashCode(), "hashCode");	

    // test the methods 'getDiameter' in the class Balloon
    t.checkExpect(b2.getDiameter(), 50, "getDiameter");

    // test the methods 'moveBalloon' in the class Balloon
    t.checkExpect(b1.moveBalloon(50, -50), new Balloon(150, 150, 25, Color.red),
    "moveBalloon");

    // test the methods 'distanceFromTop' in the class Balloon
    t.checkExpect(b1.distanceFromTop(), 200 - 25, "distanceFromTop");

    // test the methods 'isHigherThan' in the class Balloon
    t.checkExpect(b1.isHigherThan(b2), false, "isHigherThan");

    /*
     t.checkExpect(b2.paintBalloon(window), b1.paintBalloon(window),
     "paintBalloon");
     */
    
    //Tests the method "erase" in the class Balloon
    t.checkExpect(b1.erase(), new Balloon(100, 200, 25, Color.white));
    
  }
  
  /**
   * Start the run of the test suite here
   * @param argv unused
   */
  public static void main(String argv[]){
    Examples ue = new Examples();
    Tester.run(ue);
  }
}