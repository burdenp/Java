
import geometry.Posn;
import impsoundworld.*;

//Assignment 13 Final Project
//Partner Patrick Burden
//partner1username pburden
//Partner Name2 Seydi Sy
//partner2username seydi
//18 April 2012

public class Frog {
	int x;
	int y;
	String dir;
	Frog(int x, int y, String dir){
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	//Moves the frog in the given direction
	public Frog move(){
		if(this.dir.equals("right")){
			this.x = this.x +50;
		}else if(this.dir.equals("left")){
			this.x = this.x - 50;
		}else if(this.dir.equals("up")){
			this.y = this.y - 50;
		}else if(this.dir.equals("down")){
			this.y = this.y + 50;
		}
		return this;
	}
	//produce an image of this apple at this apples' location
	WorldImage makeImage(){
		if(this.y < 550 && this.y > 300){
			if(this.dir.equals("up")){
				return new FromFileImage(new Posn(this.x, this.y), "frog black top.png");
			}else if(this.dir.equals("down")){
				return new FromFileImage(new Posn(this.x, this.y), "frog black bottom.png");
			}else if(this.dir.equals("left")){
				return new FromFileImage(new Posn(this.x, this.y), "frog black left.png");
			}else {
				return new FromFileImage(new Posn(this.x, this.y), "frog black right.png");
			}
		}else if(this.y < 300 && this.y > 100){
			if(this.dir.equals("up")){
				return new FromFileImage(new Posn(this.x, this.y), "frog blue top.png");
			}else if(this.dir.equals("down")){
				return new FromFileImage(new Posn(this.x, this.y), "frog blue bottom.png");
			}else if(this.dir.equals("left")){
				return new FromFileImage(new Posn(this.x, this.y), "frog blue left.png");
			}else {
				return new FromFileImage(new Posn(this.x, this.y), "frog blue right.png");
			}
		}else{
			if(this.dir.equals("up")){
				return new FromFileImage(new Posn(this.x, this.y), "frog green top.png");
			}else if(this.dir.equals("down")){
				return new FromFileImage(new Posn(this.x, this.y), "frog green bottom.png");
			}else if(this.dir.equals("left")){
				return new FromFileImage(new Posn(this.x, this.y), "frog green left.png");
			}else {
				return new FromFileImage(new Posn(this.x, this.y), "frog green right.png");
			}
		}
		
	}
	//is the frog on screen
	public boolean onScreen(){
		return this.x <= 600 && this.x >= 0;
	}
	//the frog moves with the lily pad
	public void lilymove(Lilypads lp){
		if(lp.dir.equals("right")){
			this.x = this.x + lp.speed;
		}else{
			this.x = this.x - lp.speed;
		}
	}
	//replaces the equals function
	public boolean equals(Object obj){
		Frog temp = (Frog) obj;
		return (this.y == temp.y && this.x == temp.x && 
				 this.dir == temp.dir);
	}
}

