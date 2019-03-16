import java.awt.Color;
import java.util.Random;
import java.lang.Math.*;
import tester.*;
import funworld.*;
import geometry.*;
import colors.*;
//Assignment 5 Problem 1
//Partner James Kandebo
//partner1username: Kandebo
//Partner Patrick Burden
//partner2username: PBurden
//14 February 2012


//Apple Picker
//Try to catch as many good apples(red) as you can in your basket without 
//catching a bad one(black). The more apples you catch, the higher your score.

//A basket is a new basket(Integer, Bushel)
//Interp: new basket(x) represents basket at length x in graphics coordinates
class basket {
Integer x;
Bushel acc;
WorldImage basketImage;

basket(Integer x, Bushel acc) {
 this.x = x;
 this.acc = acc;
 this.basketImage = new FromFileImage(new CartPt(x, 250), "basket.png");
		}
/*
 * Template
 * FIELDS
 * ...this.x... integer
 * ...this.acc.. Bushel
 * ...this.basketImage... WorldImage
 * METHODS:
 * ...this.Catch... basket
 * METHODS FOR FIELDS:
 *..this.acc.makeApplesImage().. ...WorldImage...
 *..this.acc.onTick().. ...Bushel...
 *..this.acc.contains().. ...Boolean...
 *..this.acc.closeTo().. ...Boolean...
 *..this.acc.hasCaught().. ...Apple...
 *..this.acc.removeApples().. ...Bushel...
 */


//This basket catches an apple from the bushel
public basket Catch(apple a) {
//this.x this.acc
return new basket (this.x, new ConsBushel( a, this.acc));
}

	}

//An apple hangs in an orchard and can be caught by the basket when it falls 
//off the tree
class apple {
CartPt p;          // the current position of this apple
Boolean good;    // Whether or not this apple is good. If bad and caught the 
				//game will end

// make a new apple
apple(CartPt p, Boolean good) {
 this.p = p;
 this.good = good;
	}
/*
 * FIELDS:
 *..this.p .... CartPt
 *..this.good... Boolean
 * METHODS:
 *..this.moveDown().. ...apple...
 *..closeByHuh().. ...basket...
 *..makeAppleImage().. ...WorldImage...
 *..METHODS FOR FIELDS:
 *...This.p.moveDown().. ...CartPt...
 */

// Drop this apple down from a tree in the orchard.
public apple moveDown() {
 return new apple(this.p.moveDown(5), this.good);
	}

// Is this apple close to being caught in the basket
 public basket closeByHuh(basket that) {
	 if ((this.p.x < that.x + 50 && (this.p.x > that.x - 50))
		 && (this.p.y >= 206)) {
		 return new basket(that.x, new ConsBushel(this, that.acc));
	 } else {
		 return that;
	 }
 }

//produce an image of this apple at this apples' location
WorldImage makeAppleImage(){
	if (this.good){
		return new FromFileImage(this.p, "good.png");
	} else {
		return new FromFileImage(this.p, "bad.png");
	}
	}
}

//a CartPt extends the Posn class that represents the (x,y) 
//in graphics coordinates and allows for adding new methods
class CartPt extends Posn {

// the super constructor does the job
CartPt(Integer x, Integer y) {
 super(x, y);
}
/*
 * FIELDS:
 * ...This.x...   ...int...
 * ...This.y...   ...int...
 * METHODS:
 * ...This.moveDown... ...CartPt...
 */
// Move this posn down dy units.
public CartPt moveDown(Integer dy) {
  return new CartPt(this.x, this.y + dy);
	}
}

//A Bushel is one of:
//- new EmptyBushel()
//- new ConsBushel(Apple, Bushel)

//to represent a bushel of apples
interface Bushel {
// To check if the bushel contains a bad apple. True means it does have a bad 
	//apple, false means it doesn't
public Boolean contains();
// produce an image of these apples at this their locations
public WorldImage makeApplesImage();
//moves the bushel of apples five down on tic
public Bushel onTick();
// Helper method to check if any apples in the Bushel are close to the basket
public Boolean closeTo(basket b);
//Helper method to return which apple was caught
public apple hasCaught(basket b);
//removes caught apples and returns the list with new apples generated
public Bushel removeApples(basket b);
}

//to represent an empty bushel of apples (no apples)
class EmptyBushel implements Bushel {
EmptyBushel() {}

/*
 * METHODS:
 *..this.makeApplesImage().. ...WorldImage...
 *..onTick().. ...Bushel...
 *..contains().. ...Boolean...
 *..closeTo().. ...Boolean...
 *..hasCaught().. ...Apple...
 *..removeApples().. ...Bushel...
 */

// produce an image of these apples at their locations
public WorldImage makeApplesImage(){
 return new RectangleImage(new Posn(0, 0), 0, 0, new White());
}
//returns an empty Bushel on tic
public Bushel onTick(){
	  return this;
}
//To check if the bushel contains a bad apple. True means it does have a bad 
//apple, false means it doesn't
public Boolean contains(){
	return false;
}
//Helper method to check if any apples in the Bushel are close to the basket
public Boolean closeTo(basket b){
	return false;
}
//Helper method to return which apple was caught, this can't happen
public apple hasCaught(basket b){
	return new apple(new CartPt(-500,-500), true);
}
//removes caught apples and returns the list with new apples generated
public Bushel removeApples(basket b){
	return new EmptyBushel();
}
}

//to represent a bushel with at least one apple
class ConsBushel implements Bushel {
apple first;
Bushel rest; 

/*
 * FIELDS:
 * ...this.first...   ...Apple...
 * ...this.rest...    ...Bushel...
 * ...this.random...  ...Random...
 * METHODS:
 *..this.makeApplesImage().. ...WorldImage...
 *..this.onTick().. ...Bushel...
 *..this.contains().. ...Boolean...
 *..this.closeTo().. ...Boolean...
 *..this.hasCaught().. ...Apple...
 *..removeApples().. ...Bushel...
 *METHODS FOR FIELDS:
 *..this.first.moveDown().. apple
 *..this.first.closeByHuh().. basket
 *..this.first.makeAppleImage().. WorldImage
 *...this.rest.makeApplesImage().. ...WorldImage...
 *..this.rest.onTick().. ...Bushel...
 *..this.rest.contains().. ...Boolean...
 *..this.rest.closeTo().. ...Boolean...
 *..this.rest.hasCaught().. ...Apple...
 *..this.rest.removeApples().. ...Bushel...
 */

//Create a new random number generator
Random random = new Random();

ConsBushel (apple first, Bushel rest) {
 this.first = first;
 this.rest = rest;
}


// produce an image of this Bushel of apples at their locations
public WorldImage makeApplesImage(){
 return this.first.makeAppleImage().overlayImages(
        this.rest.makeApplesImage());
}
//returns the new position of a consBushel on tick
public Bushel onTick(){
	  if(this.first.p.y > 300){
		  return new ConsBushel(new apple(new CartPt(random.nextInt(600), 
				  20), this.first.good), this.rest.onTick());
	  } else{
	  return new ConsBushel(this.first.moveDown(), this.rest.onTick());
}
}
//To check if the bushel contains a bad apple. True means it does have a bad 
//apple, false means it doesn't
public Boolean contains(){
	if (this.first.good){
	return this.rest.contains();
			} else{
			return true;
}
}
//Helper method to check if any apples in the Bushel are close to the basket
public Boolean closeTo(basket b){
	if((this.first.p.x < b.x + 50 && (this.first.p.x > b.x - 50)
			 && (this.first.p.y >= 206))) {
		return true;
	} else {
		return this.rest.closeTo(b);
	}
}
//Helper method to return which apple was caught
public apple hasCaught(basket b){
	if((this.first.p.x < b.x + 50 && (this.first.p.x > b.x - 50)
			 && (this.first.p.y >= 206))) {
		return new apple (new CartPt(this.first.p.x, this.first.p.y),
				this.first.good);
	} else {
		return this.rest.hasCaught(b);
	}
}
//removes caught apples and returns the list with new apples generated
public Bushel removeApples(basket b){
	if((this.first.p.x < b.x + 50 && (this.first.p.x > b.x - 50)
			 && (this.first.p.y >= 206))) {
		return new ConsBushel(new apple(new CartPt(this.random.nextInt(600),
				20), this.first.good), this.rest.removeApples(b));
	} else {
		return new ConsBushel(new apple(new CartPt(this.first.p.x, 
				this.first.p.y), this.first.good), this.rest.removeApples(b));
	}
	}
}

//the world of a game where the fish swim left to right and the shark on the 
//right is trying to eat as many as possible to keep alive
class OrchardWorld extends World{
int WIDTH = 600;   // constant values, never change
int HEIGHT = 300;  // constant values, never change
basket basket;       // the basket in the game
Bushel apples;    // the apples in the game
Integer score;
OrchardWorld(basket basket, Bushel apples, int score){
 this.basket = basket;
 this.apples = apples;
 this.score = score;
}

/*
 * FIELDS:
 * ...this.WIDTH...   ...int...
 * ...this.HEIGHT...    ...int...
 * ...this.basket...  ...basket...
 * ...this.apples...  ...Bushel...
 * ...this.score...   ...Integer...
 * METHODS:
 *...this.makeImage().. ...WorldImage...
 *...this.WorldEnd().. ...WorldEnd...
 *...this.closeBy()... ...OrchardWorld...
 *...this.onTick()...  ...OrchardWorld...
 *...this.onKeyEvent()... ...OrchardWorld...
 *METHODS FOR FIELDS:
 * *..this.apples.makeApplesImage().. ...WorldImage...
 *..this.apples.onTick().. ...Bushel...
 *..this.apples.contains().. ...Boolean...
 *..this.apples.closeTo().. ...Boolean...
 *..this.apples.hasCaught().. ...Apple...
 *..this.apples.removeApples().. ...Bushel...
 *...this.basket.Catch()... ...basket...
 */


// produce the image of this world with the basket and apples...
public WorldImage makeImage(){
 return new FromFileImage(new CartPt(300,150), "Orchard.png").
 overlayImages(this.apples.makeApplesImage(),
		 this.basket.basketImage);
}
public WorldEnd worldEnds(){
	 if(basket.acc.contains()){
		 return 
		new WorldEnd(true, this.makeImage().overlayImages
				( new TextImage(new Posn(300, 150), Integer.toString
						(this.score), 50, 3, new Red())));
	 } else{
		 return
		new WorldEnd (false, this.makeImage());
	 }
}
//Is an apple close to being caught in the basket
public OrchardWorld closeByHuh() {
	 if (this.apples.closeTo(this.basket)){
		 return new OrchardWorld(new basket(this.basket.x, new ConsBushel
				 (this.apples.hasCaught(this.basket), this.basket.acc)),
				 this.apples.removeApples(this.basket), this.score + 1);
	 } else {
		 return this;
	 }
	}
//returns the new position of a consBushel on tick
public OrchardWorld onTick(){
	 return new OrchardWorld(new basket(this.basket.x, this.basket.acc), 
			 this.apples.onTick(), this.score).closeByHuh();
}

//move this basket left or right on screen depending on the key
public OrchardWorld onKeyEvent(String ke){
	if (ke.equals("left") && (this.basket.x > 0))
		return new OrchardWorld(new basket(this.basket.x - 5, this.basket.acc),
				this.apples, this.score);
	else if (ke.equals("right") && (this.basket.x < 600)){
	      return 
	       new OrchardWorld(new basket(this.basket.x + 5, this.basket.acc),
	    		   this.apples, this.score);
	    }
	    else
	      return this;
					}
					
}
class ExamplesGame{
	ExamplesGame(){}
	
	CartPt CartPt1 = new CartPt(120, 20);
	CartPt CartPt2 = new CartPt(230, 40);
	CartPt CartPt3 = new CartPt(50, 20);
	basket basket1 = new basket(50, new EmptyBushel());
	basket basket2 = new basket(55, new EmptyBushel());
	Bushel empty = new EmptyBushel();
	apple apple1 = new apple(CartPt1, true);
	apple apple2 = new apple(CartPt2, true);
	apple apple3 = new apple(CartPt3, true);
	apple badApple = new apple(CartPt3, false);
	Bushel bushel1 = new ConsBushel(apple1, empty);
	Bushel bushel2 = new ConsBushel(apple2, bushel1);
	Bushel bushel3 = new ConsBushel(apple3, bushel2);
	Bushel badbushel = new ConsBushel(badApple, bushel2);
	basket basket3 = new basket(20, bushel1);
	OrchardWorld OW1 = new OrchardWorld(basket1,badbushel, 0);
	OrchardWorld OW2 = new OrchardWorld(basket2, bushel3, 0);
	Bushel badbushel2 = new ConsBushel(badApple, empty);
	Bushel bushel4 = new ConsBushel(new apple
				(new CartPt(49, 206), true), empty);
	
	boolean testOnKeyEvent(Tester t)
	{
		return t.checkExpect(this.OW1.onKeyEvent("right"), OW2) &&
				t.checkExpect(this.OW2.onKeyEvent("left"), OW1);
	}
	boolean testCatch(Tester t){
		return t.checkExpect(this.basket1.Catch(apple1), new basket(50,
				bushel1)) &&
				t.checkExpect(this.basket2.Catch(apple1), new basket(55,
						bushel1));
	}
	boolean testMoveDown(Tester t){
		return t.checkExpect(this.apple1.moveDown(), new apple(new CartPt(120,
				25), true)) &&
				t.checkExpect(this.apple3.moveDown(), new apple(new CartPt(50,
						25), true));
	}
	boolean testCloseByHuh(Tester t){
		return t.checkExpect(this.apple3.closeByHuh(basket1), basket1) &&
				t.checkExpect(this.apple2.closeByHuh(basket2), basket2);
	}
	boolean testOnTick(Tester t){
		return t.checkExpect(this.badbushel2.onTick(),
				new ConsBushel(new apple(new CartPt(50,25), false), empty));
	}
	boolean testContains(Tester t){
		return t.checkExpect(this.bushel3.contains(), false) &&
				t.checkExpect(this.badbushel.contains(), true);
	}
	boolean testCloseTo(Tester t){
		return t.checkExpect(this.bushel2.closeTo(basket1), false)&&
				t.checkExpect(this.bushel3.closeTo(basket2), false);
	}
	boolean testHasCaught(Tester t){
		return t.checkExpect(this.bushel4.hasCaught(basket3), 
				new apple( new CartPt(49, 206), true));
	}
	//boolean testRemoveApples(Tester t){
		//Can not test due to random number generation
	//}
	boolean testWholeWorld(Tester t){
		return this.OW1.bigBang(600, 300, 0.1);
	}
	
public static void main(String[]argv){
	ExamplesGame ett = new ExamplesGame();
	
	OrchardWorld OW1 = new OrchardWorld(ett.basket1, ett.badbushel, 0);
	OW1.bigBang(600, 300, 0.1);
}
}

