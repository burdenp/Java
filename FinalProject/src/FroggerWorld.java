import geometry.Posn;
import impsoundworld.*;
import impsoundworld.FromFileImage;
import impsoundworld.TextImage;
import impsoundworld.World;
import impsoundworld.WorldEnd;
import impsoundworld.WorldImage;
import java.util.ArrayList;

import tunes.Note;

import colors.Red;

//Assignment 13 Final Project
//Partner Patrick Burden
//partner1username pburden
//Partner Name2 Seydi Sy
//partner2username seydi
//18 April 2012



public class FroggerWorld extends World{
	Frog f;
	ArrayList<Car> listC;
	ArrayList<Lilypads> listL;
	int width;
	int height;

	FroggerWorld(Frog f, ArrayList<Car> listC, ArrayList<Lilypads> listL){
		this.f = f;
		this.listL = listL;
		this.listC = listC;
		this.width = 600;
		this.height = 600;
	}
	//makes the images of the world
	public WorldImage makeImage(){
		WorldImage basicWorld = new FromFileImage(new Posn(300, 300), "Froggerworld.png");
		for(int index = 0; index < listC.size(); index = index +1){
				basicWorld = basicWorld.overlayImages(this.f.makeImage(), 
						 this.listC.get(index).makeImage());
		 }
		 for(int index = 0; index < listL.size(); index = index +1){
			 basicWorld = basicWorld.overlayImages(this.f.makeImage(), 
					 this.listL.get(index).makeImage());
		 }
		 return basicWorld;
		}
	
		//move this basket left or right on screen depending on the key
		public void onKeyEvent(String ke){
			if (ke.equals("left") && (this.f.x > 0)){
				f.dir = "left";
				f.move();
			}else if (ke.equals("right") && (this.f.x < 600)){
			      f.dir = "right";
			      f.move();
			}else if (ke.equals("up") && (this.f.y > 0)){
			      f.dir = "up";
			      f.move();
			}else if (ke.equals("down") && (this.f.y < 600)){
			      f.dir = "down";
			      f.move();
			}

		}
	    //moves a list of cars
	    public void MoveAllCars(){ 
	        for (int index = 0; index < listC.size(); index = index + 1){
	        this.listC.get(index).move();
	        }
	    }
	    //moves a list of Lillypads
	    public void MoveAllLillypads(){ 
	        for (int index = 0; index < listL.size(); index = index + 1){
	        listL.get(index).move();
	        }
	    }
	    /** index of the currently playing note in the scale */
	    public int currentNote = 0;
	    
	    /** the notes in the C-major scale */
	    public ArrayList<Note> upScale = new ArrayList<Note>();
	    
	    /**
	     * Initialize the C-major scale
	     */
	    //background music
	    public void initScales(){
	    	this.upScale.clear();
	      this.upScale.add(new Note(noteA));
	      this.upScale.add(new Note(noteB));
	      this.upScale.add(new Note(noteC));
	      this.upScale.add(new Note(noteD));
	      this.upScale.add(new Note(noteE));
	      this.upScale.add(new Note(noteF));
	      this.upScale.add(new Note(noteG));
	      this.upScale.add(new Note(noteUpC));
	    }
	    //losing sound
	    public void BadScales(){
	    	  this.upScale.clear();
		      this.upScale.add(new Note(noteC));
		      this.upScale.add(new Note(noteD));
		      this.upScale.add(new Note(noteE));
		      this.upScale.add(new Note(noteF));
		      this.upScale.add(new Note(noteG));
		      this.upScale.add(new Note(noteA));
		      this.upScale.add(new Note(noteB));
		      this.upScale.add(new Note(noteUpC));
	    }
	    //victory sound
	    public void GoodScales(){
	    	  this.upScale.clear();
		      this.upScale.add(new Note(noteA));
		    	this.upScale.add(new Note(000));
		      this.upScale.add(new Note(noteUpA));
		    	this.upScale.add(new Note(000));
		      this.upScale.add(new Note(noteA));
		    	this.upScale.add(new Note(000));
		      this.upScale.add(new Note(noteUpA));
		    	this.upScale.add(new Note(000));
		      this.upScale.add(new Note(noteC));
		    	this.upScale.add(new Note(000));
		      this.upScale.add(new Note(noteB));
		    	this.upScale.add(new Note(000));
		      this.upScale.add(new Note(noteUpA));
		    	this.upScale.add(new Note(000));
		      this.upScale.add(new Note(noteUpA));
	    }
	    /**
	     * Produce the next note to be played in the current direction
	     * 
	     * @return the note to be played on the next tick
	     */
	    //plays the next note
	    public Note nextNote(){
	    	this.initScales();
	      this.currentNote = (this.currentNote +1) % 8;
	      return this.upScale.get(this.currentNote);
	    }
	    //plays the next sound, moves all cars, moves all lilypads.
	    public void onTick(){
	    	this.tickTunes.addNote(PIANO, this.nextNote());
	    	this.MoveAllCars();
	    	this.MoveAllLillypads();
	    	if(this.onlilypad()){
	    		this.f.lilymove(this.whichLilypad());
	    	}

	    }
	    //ends the game either win or lose
	    public WorldEnd worldEnds(){
	    	if(this.f.y < 100){
	    		return this.victory();
	    	}else{ 
	    		return this.lose();
	    	}
	    }
	    //checks to see if the frog is on a lilypad
	    public boolean onlilypad(){
	    	for(int index = 0; index < listL.size(); index = index +1){
	    		if(this.f.y == (listL.get(index).row *50) 
	    				&& (this.f.x < listL.get(index).x + 25 
	    						&& this.f.x > listL.get(index).x - 25)){
	    			return true;
	    		}
	    	}
	    	return false;
	    }
	    //is the frog dead? aka hit by car or drowned in river.
	    public boolean isDead(Car car){
	    	if(this.f.y > 100 && this.f.y < (height /2) && ! this.onlilypad()){
	    		return true;
	    	}
	    	if(this.f.y == (car.row *50)
	    			&& (this.f.x < car.x + 26 && this.f.x > car.x - 26)){
	    		return true;
	    	}else return false;
	       
	    }
	    //Ends the world with a "you win" string on it
	    //means you made it to the end/won
	    public WorldEnd victory(){
	    	//victory
	    		this.GoodScales();
	    		for(int sound = 0; sound < 8; sound = sound +1){
	    			this.tickTunes.addNote(PIANO, this.nextNote());
	    		}
	    		return new WorldEnd(true, this.makeImage().overlayImages
	    				(new TextImage(new Posn(300, 150),
	    						"You Win", 50, 3, new Red())));
	    }
	    //checks to see if you lost the game
	    public WorldEnd lose(){
	    	for(int index = 0; index < listC.size(); index = index +1){
	    		if(this.isDead(listC.get(index))){
	    			//call to sound for lose
	    			for(int sound = 0; sound < 8; sound = sound +1){
	    				this.tickTunes.addNote(PIANO, this.nextNote());
	    			}
	    			return new WorldEnd(true, this.makeImage().overlayImages
	    					(new TextImage(new Posn(300, 150),
	    							"You Lose", 50, 3, new Red())));
	    		}
	    	}
	    		return new WorldEnd (false, this.makeImage());
	    }
	    //returns whichLilypad the frog is on
	    //is only called when frog is on a lilypad
	    public Lilypads whichLilypad(){
	    	//checks to see if the frog is on a lilypad
	    	for(int index = 0; index < listL.size(); index = index +1){
	    		if(this.f.y == (listL.get(index).row *50) 
	    				&& (this.f.x < listL.get(index).x + 25 
	    						&& this.f.x > listL.get(index).x - 25)){
	    			return listL.get(index);
	    		}
	    	}
	    	//should never happen it is only called when frog is on a lilypad
	    	return new Lilypads(0,0,0,"left");
	    }
}

