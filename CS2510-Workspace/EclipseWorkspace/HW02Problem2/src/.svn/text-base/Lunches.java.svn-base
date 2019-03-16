import tester.*;

//Assignment 2 Problem 1
//Josh Samara
//joshs
//Patrick Burden
//pburden
//24 January 2012

//to represent any possible lunch item
interface ILunchItem{}

//to represent the lunch item soup
class Soup implements ILunchItem{
	String flavor;
	boolean vegetarian;
	double price;
		
	Soup(String flavor, boolean vegetarian, double price){
		this.flavor = flavor;
		this.vegetarian = vegetarian;
		this.price = price;
	}
}

//to represent the lunch item salad
class Salad implements ILunchItem{
	String type;
	String dressing;
	boolean vegetarian;
	double price;
	
	Salad(String type, String dressing, boolean vegetarian, double price){
		this.type = type;
		this.dressing = dressing;
		this.vegetarian = vegetarian;
		this.price = price;
	}
}

//to represent the lunch item bread
class Bread implements ILunchItem{
	String type;
	boolean vegetarian;
	double price;
	
	
	Bread(String type, boolean vegetarian){
		this.type = type;
		this.vegetarian = vegetarian;
		this.price = 1.00;
	}
}


//to represent an entire order of lunch items 
interface ILunchOrder{}

//an order with at least one item
class Lunch implements ILunchOrder{
//Interpretation: You are not limited to one of each lunch item
//nor are you required to have at least one of each item
	ILunchItem first;
	ILunchOrder rest;
	
	Lunch(ILunchItem first, ILunchOrder rest){
		this.first = first;
		this.rest = rest;
	}
	
}

//an empty order
class MtLunch implements ILunchOrder{
	MtLunch(){}
}

class ExamplesLunches{
	ExamplesLunches(){}
	
	Soup soup1 = new Soup("Chicken Noodle", false, 1.50);
	Soup soup2 = new Soup("Golden Tomato", true, 500.01);
	Salad salad1 = new Salad("Chef", "Thousand Island", false, 6.28);
	Salad salad2 = new Salad("Greek", "Olive Oil", true, 4.50);
	Bread bread1 = new Bread("White", true);
	Bread bread2 = new Bread("Bacon Biscuts", false);
	
	ILunchOrder order1 = new MtLunch();
	ILunchOrder order2 = new Lunch(soup2, order1);
	ILunchOrder order3 = new Lunch(salad2, order2);
	
	//Full vegetarian lunch order
	ILunchOrder order4 = new Lunch(bread1, order3);
	
	//Not full vegetarian lunch order
	ILunchOrder order5 = new Lunch(bread2, order3);
	ILunchOrder order6 = new Lunch(bread1, new Lunch(salad1, order1));
	ILunchOrder order7 = 
			new Lunch(bread2, new Lunch(salad1, new Lunch(soup1, order1)));
	
	
}