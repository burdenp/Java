import java.util.ArrayList;
import tester.Tester;

//Assignment 13 Final Project
//Partner Patrick Burden
//partner1username pburden
//Partner Name2 Seydi Sy
//partner2username seydi
//18 April 2012

public class Examples {
	Frog f1 = new Frog(300, 600, "up");
	Car c1 = new Car(10, 599, 40,"left");
	Car c2 = new Car(9, 1, 40,"right");
	Car c5 = new Car(10, 200, 40,"left");
	Car c6 = new Car(9, 500, 40,"right");
	Car c7 = new Car(8, 599, 30,"left");
	Car c8 = new Car(7, 1, 50,"right");
	Car c9 = new Car(8, 200, 30,"left");
	Car c10 = new Car(7, 300, 50,"right");
	ArrayList<Car> carList = new ArrayList<Car>();
	Lilypads lp1 = new Lilypads(5, 1, 20, "right");
	Lilypads lp2 = new Lilypads(4, 450, 20, "left");
	Lilypads lp3 = new Lilypads(5, 50, 20, "right");
	Lilypads lp4 = new Lilypads(4, 400, 20, "left");
	Lilypads lp5 = new Lilypads(5, 200, 20, "right");
	Lilypads lp6 = new Lilypads(4, 250, 20, "left");
	Lilypads lp7 = new Lilypads(5, 250, 20, "right");
	Lilypads lp8 = new Lilypads(4, 200, 20, "left");
	Lilypads lp9 = new Lilypads(5, 400, 20, "right");
	Lilypads lp10 = new Lilypads(4, 50, 20, "left");
	Lilypads lp11 = new Lilypads(5, 450, 20, "right");
	Lilypads lp12 = new Lilypads(2, 1, 20, "left");
	Lilypads lp13 = new Lilypads(3, 1, 25, "right");
	Lilypads lp14 = new Lilypads(2, 450, 20, "left");
	Lilypads lp15 = new Lilypads(3, 50, 25, "right");
	Lilypads lp16 = new Lilypads(2, 400, 20, "left");
	Lilypads lp17 = new Lilypads(3, 200, 25, "right");
	Lilypads lp18 = new Lilypads(2, 250, 20, "left");
	Lilypads lp19 = new Lilypads(3, 250, 25, "right");
	Lilypads lp20 = new Lilypads(2, 200, 20, "left");
	Lilypads lp21 = new Lilypads(3, 400, 25, "right");
	Lilypads lp22 = new Lilypads(2, 50, 20, "left");
	Lilypads lp23 = new Lilypads(3, 450, 25, "right");
	Lilypads lp24 = new Lilypads(2, 1, 20, "left");
	
	ArrayList<Lilypads> lpList = new ArrayList<Lilypads>();
    
    
    
    
	Lilypads lp25 = new Lilypads(5, 4500, 2000, "right");
	Frog f2 = new Frog(3000, 6000, "up");
	Car c3 = new Car(9000, 1000, 40,"right");


	
	public void moves(){
		c2.move();
		f1.move();
		lp7.move();
	}


	// test for all the methods 
	public void testMethods(Tester t){
	    moves();
	    t.checkExpect(this.c2.x,41);
	    t.checkExpect(this.f1.y, 550);
	    t.checkExpect(this.lp7.x, 270);
	    t.checkExpect(this.f1.onScreen(), true);
	    t.checkExpect(this.f2.onScreen(), false);
	    t.checkExpect(this.lp7.onScreen(), true);
	    t.checkExpect(this.lp25.onScreen(), false);
	    t.checkExpect(this.c1.onScreen(), true);
	    t.checkExpect(this.c3.onScreen(), false);
	}

	public static void main(String[]argv){
		Examples ett = new Examples();

		ett.lpList.add(ett.lp1);
		ett.lpList.add(ett.lp2);
		ett.lpList.add(ett.lp3);
		ett.lpList.add(ett.lp4);
		ett.lpList.add(ett.lp5);
		ett.lpList.add(ett.lp6);
		ett.lpList.add(ett.lp7);
		ett.lpList.add(ett.lp8);
		ett.lpList.add(ett.lp9);
		ett.lpList.add(ett.lp10);
		ett.lpList.add(ett.lp11);
		ett.lpList.add(ett.lp12);
		ett.lpList.add(ett.lp13);
		ett.lpList.add(ett.lp14);
		ett.lpList.add(ett.lp15);
		ett.lpList.add(ett.lp16);
		ett.lpList.add(ett.lp17);
		ett.lpList.add(ett.lp18);
		ett.lpList.add(ett.lp19);
		ett.lpList.add(ett.lp20);
		ett.lpList.add(ett.lp21);
		ett.lpList.add(ett.lp22);
		ett.lpList.add(ett.lp23);
		ett.lpList.add(ett.lp24);
		ett.carList.add(ett.c1);
		ett.carList.add(ett.c2);
		ett.carList.add(ett.c5);
		ett.carList.add(ett.c6);
		ett.carList.add(ett.c7);
		ett.carList.add(ett.c8);
		ett.carList.add(ett.c9);
		ett.carList.add(ett.c10);
		
		FroggerWorld FW1 = new FroggerWorld(ett.f1, ett.carList, ett.lpList);
		FW1.bigBang(600, 600, 0.2);
	}
}
