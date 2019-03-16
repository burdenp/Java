import geometry.Posn;
import impsoundworld.FromFileImage;
import impsoundworld.WorldImage;

//Assignment 13 Final Project
//Partner Patrick Burden
//partner1username pburden
//Partner Name2 Seydi Sy
//partner2username seydi
//18 April 2012

public class Lilypads {
	int row;
	int x;
	int speed;
	String dir;
	Lilypads(int row, int x, int speed, String dir){
		this.row = row;
		this.x = x;
		this.speed = speed;
		this.dir = dir;
	}
	//produces the lilypad image
	public WorldImage makeImage(){
		return new FromFileImage(new Posn(this.x, this.row * 50 ), "frogger-lilypad.png");
	}
	//moves the lilypad
	public void move(){
		if(this.onScreen()){
			if(this.dir.equals("left")){
				this.x = this.x - speed;
			}else{
				this.x = this.x + speed;
			}
		}else{
			if(this.dir.equals("left")){
				this.x = 600;
			}else{
				this.x = 0;
			}
		}
	}
	//boolean for if the lilypad is on screen
	public boolean onScreen(){
		return this.x <= 600 && this.x >= 0;
	}
	//replaces the equals function
	public boolean equals(Object obj){
		Lilypads temp = (Lilypads) obj;
		return (this.row == temp.row && this.x == temp.x && 
				this.speed == temp.speed && this.dir == temp.dir);
	}
}
