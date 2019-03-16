// CS 2510 Spring 2012
// Assignment 3
// Problem 3.2
// 24 January 2012
// ExcelCells.java

import tester.*;

//Assignment 3 Problem 2
//Josh Samara
//joshs
//Patrick Burden
//pburden
//31 January 2012

/*
          +------------+
+-------->| Cell       |<-------------------------+-+
|         +------------+                          | | 
|         | int row    |                          | | 
|         | int col    |                          | |
|         | IData data |-+                        | | 
|         +------------+ |                        | | 
|                      |                          | | 
|                      v                          | | 
|                  +-------+                      | | 
|                  | IData |                      | | 
|                  +-------+                      | | 
|                     / \                         | |
|                     ---                         | |
|                      |                          | | 
|     ---------------------------------           | |
|     |                 |             |           | | 
| +------------+   +-----------+  +----------+    | |
| | MyNumber   |   | Reference |  | Formula  |    | | 
| +------------+   +-----------+  +----------+    | |
| | int number | +-| Cell cell |  | Cell op1 |----+ |        
| +------------+ | +-----------+  | Cell op2 |------+
|                |              +-| IFun fun |
+----------------+              | +----------+            
                                v                    
                            +------+
                            | IFun |
                            +------+
                              / \
                              ---
                               |
           ---------------------------         
           |           |             |         
       +------+    +-------+    +-------+ 
       | Plus |    | Minus |    | Times | 
       +------+    +-------+    +-------+ 

 */

/*
  A sample spreadsheet:
  ---------------------

   |  A(1)    |  B(2)   |  C(3)   |  D(4)   |  E(5)     | 
---+----------+---------+---------+---------+-----------+ 
 1 |    7     |    4    |    3    |    2    |    5      | 
---+----------+---------+---------+---------+-----------+ 
 2 | mn A1 E1 | + B1 C1 | ref(A3) |         | * A2 D1   | 
---+----------+---------+---------+---------+-----------+ 
 3 |          | + B2 B1 |         |         | mn B3 D1  | 
---+----------+---------+---------+---------+-----------+ 
 4 |          | + B3 B2 |         |         | abs B4 D1 | 
---+----------+---------+---------+---------+-----------+ 
 5 |          | + B4 B3 |         |         | * A2 E4   | 
---+----------+---------+---------+---------+-----------+ 
 */

// to represent a cell in a spreadsheet
class Cell{
  int row;
  int col;
  IData data;

  Cell(int row, int col, IData data){
    this.row = row;
    this.col = col;
    this.data = data;
  }  

  /* TEMPLATE:
   FIELDS:
    ... this.row ...             -- int
    ... this.col ...             -- int
    ... this.data ...            -- IData

    METHODS:
    ... this.eval ...            -- int
    ... this.countFuns ...		 -- boolean
    ... this.countPlus ...		 -- boolean
    METHODS FOR FIELDS:
    ... this.data.eval ...      	 -- int
    ... this.data.countFuns ...		 -- boolean
    ... this.data.countPlus ...		 -- boolean
   */
  
  //returns the data within the invoking cell
  public int eval(){
	 return this.data.eval();
  }
  
  //counts the number of function calls
  public int countFuns(){
	  return this.data.countFuns();
  }
  
  //counts the number of times plus was called
  public int countPlus(){
	  return this.data.countPlus();
  }

}                                

// to represent data in one cell of a spreadsheet
interface IData{
	
	//computes the value of the data
	public int eval();
	
	//counts the number of function calls
	public int countFuns();
	
	//counts the number of times plus was called
	public int countPlus();

}

// to represent numerical data in one cell of a spreadsheet
class MyNumber implements IData{
  int number;

  MyNumber(int number){
    this.number = number;
  }

  /* TEMPLATE:
   FIELDS:
    ... this.number ...             -- int

    METHODS:
    ... this.eval() ...              -- int
    ... this.countFuns() ...		 -- boolean
    ... this.countPlus)() ...		 -- boolean
    
   */

  
  	//computes the value of the data
  	public int eval(){
	  return this.number;
  }
  
  	//counts the number of function calls
  	public int countFuns(){
	  return 0;
  }
  
  	//counts the number of times plus was called
  	public int countPlus(){
	  return 0;
  }
  
}

//to represent a reference to another cell in one cell of a spreadsheet
class Reference implements IData{
  Cell cell;

  Reference(Cell cell){
    this.cell = cell;
  }

  /* TEMPLATE:
   FIELDS:
   ... this.cell ...             -- Cell

   METHODS:
   ... this.eval() ...           -- int
   ... this.countFuns() ...		 -- boolean
   ... this.countPlus() ...		 -- boolean

   METHODS FOR FIELDS:
   ... this.cell.eval() ...            -- int
   ... this.cell.countFuns() ...	   -- boolean
   ... this.cell.countPlus() ...	   -- boolean
  */
  
  	//evaluates the referenced cell. Assuming no self reference
  	public int eval(){
	  return this.cell.eval();
  }
  
  	//counts the number of function calls
  	public int countFuns(){
	  return this.countFuns();
  }
  	//counts the number of times plus was called
  	public int countPlus(){
	  return this.countPlus();
  }

}

// to represent a formula data in one cell of a spreadsheet
class Formula implements IData{
  Cell op1;
  Cell op2;
  IFun fun;

  Formula(Cell op1, Cell op2, IFun fun){
    this.op1 = op1;
    this.op2 = op2;
    this.fun = fun;
  }


  /* TEMPLATE:
   FIELDS:
    ... this.op1 ...             -- Cell
    ... this.op2 ...             -- Cell
    ... this.fun ...             -- IFun

    METHODS:
    ... this.eval() ...          -- int
   ... this.countFuns() ...		 -- int
   ... this.countPlus() ...		 -- int

    METHODS FOR FIELDS:
    ... this.op1.eval() ...            -- int
    ... this.op2.eval() ...            -- int
    ... this.fun.compute(int, int) ... -- int
    
   */
  
  //evaluates the referenced cells and computes the operation
  	public int eval(){
	  return this.fun.compute(this.op1.eval(), this.op2.eval());
  }
  
  	//counts the number of function calls
  	public int countFuns(){
	  return this.op1.countFuns() + this.op2.countFuns() + 1;
  }
  
  	//counts the number of times plus was called
  	public int countPlus(){
	  return this.op1.countPlus() + this.op2.countPlus() + this.fun.countPlus();
  }
 
}

// to represent a function of two arguments
interface IFun{
  
	//computes the function using the given value
	public int compute(int x, int y);
	//counts the number of times plus was called
	public int countPlus();
}                         

// to represent an addition function of two arguments
class Plus implements IFun{
  Plus(){}

  /* TEMPLATE:
   FIELDS:

    METHODS:
    ... this.compute(int, int) ... -- int

   */  

   //computes the function using the given cells
	public int compute(int x, int y){
		return x + y;
	}
	
	public int countPlus(){
		return 1;
	}
}

// to represent a subtraction function of two arguments
class Min implements IFun{
  Min(){}

  /* TEMPLATE:
   FIELDS:

    METHODS:
    ... this.compute(int, int) ... -- int
    ... this.countPlus() ...       -- int

   */  

    //computes the function using the given cells
	public int compute(int x, int y){
		return x - y;
	}
	public int countPlus(){
		return 0;
	}
}   

// to represent a multiplication function of two arguments
class Times implements IFun{
  Times(){}

  /* TEMPLATE:
   FIELDS:

    METHODS:
    ... this.compute(int, int) ... -- int
    ... this.countPlus() ...       -- int

   */  

   //computes the function using the given cells
	public int compute(int x, int y){
		return x * y;
	}
	
	//counts the number of times plus was called
	public int countPlus(){
		return 0;
	}
}

class AbsDiff implements IFun{
	AbsDiff(){}
	
	/* TEMPLATE:
	   FIELDS:

	    METHODS:
	    ... this.compute(int, int) ... -- int
	    ... this.countPlus() ...       -- int

	   */  
	
	//computes the function using the given cells
	public int compute(int x, int y){
		return Math.abs(x - y);
	}
	
	//counts the number of times plus was called
	public int countPlus(){
		return 0;
	}
}

// Examples and tests for classes that model a spreadsheet
class ExamplesExcelCells{
  ExamplesExcelCells(){}
  
  
  //EXAMPLES OF DATA
  IData n8 = new MyNumber(8);
  IData n3 = new MyNumber(3);
  IData n4 = new MyNumber(4);
  IData n6 = new MyNumber(6);
  IData n2 = new MyNumber(2);
  
  Cell ca1 = new Cell(1,1, n8);
  Cell cb1 = new Cell(2,1, n3);
  Cell cc1 = new Cell(3,1, n4);
  Cell cd1 = new Cell(4,1, n6);
  Cell ce1 = new Cell(5,1, n2);
  
 
  IData fa2 = new Formula(ca1, ce1, new Min());
  Cell ca2 = new Cell(1, 2, fa2);
  IData fb2 = new Formula(cb1, cc1, new Plus());
  Cell cb2 = new Cell(2,2, fb2);
  IData fe2 = new Formula(cb2, cc1, new Plus());
  Cell ce2 = new Cell(5,2,fe2);
  IData fa3 = new Formula(ca1, ca2, new Times()); 
  Cell ca3 = new Cell(1,3, fa3);
  IData rc2 = new Reference(ca3);
  Cell cc2 = new Cell(3, 2, rc2);
  IData fb3 = new Formula(cb2, cb1, new Plus());
  Cell cb3 = new Cell(2,3,fb3);
  IData fe3 = new Formula(ca3, cd1, new Min());
  Cell ce3 = new Cell(5, 3, fe3);
  IData fb4 = new Formula(cb3,cb2, new Plus());
  Cell cb4 = new Cell(2, 4, fb4);
  IData fe4 = new Formula(cb4, cd1, new Min());
  Cell ce4 = new Cell(5, 4, fe4);
  IData fb5 = new Formula(cb4, cb3, new Plus());
  Cell cb5 = new Cell(2, 5, fb5);
  IData fe5 = new Formula(cb5, ce4, new Times());
  Cell ce5 = new Cell(5, 5, fe5);
  IData fc3 = new Formula(ca1, cb1, new AbsDiff());
  Cell cc3 = new Cell(3, 3, fc3);
  
  //METHOD EXAMPLES
  boolean testEval(Tester t){
	  return  t.checkExpect(ca1.eval(), 8) &&
			  t.checkExpect(cb2.eval(), 7) &&
			  t.checkExpect(cc2.eval(), 48) &&
			  t.checkExpect(ce4.eval(), 11) &&
			  t.checkExpect(ce5.eval(), 297) &&
			  t.checkExpect(cc3.eval(), 5) &&
			  t.checkExpect(ca3.eval(), 48);
  }
  
  boolean testCountFuns(Tester t){
	  return t.checkExpect(ca1.countFuns(), 0) &&
			  t.checkExpect(cb2.countFuns(), 1) &&
			  t.checkExpect(cb3.countFuns(), 2) &&
			  t.checkExpect(cb4.countFuns(), 4) &&
			  t.checkExpect(cb5.countFuns(), 7) &&
			  t.checkExpect(ce4.countFuns(), 5) &&
			  t.checkExpect(ce5.countFuns(), 13);
			  
  }
  
  boolean testCountPlus(Tester t){
	  return t.checkExpect(ca1.countPlus(), 0) &&
			  t.checkExpect(cb2.countPlus(), 1) &&
			  t.checkExpect(cb3.countPlus(), 2) &&
			  t.checkExpect(cb4.countPlus(), 4) &&
			  t.checkExpect(cb5.countPlus(), 7) &&
			  t.checkExpect(ce4.countPlus(), 4) &&
			  t.checkExpect(ce5.countPlus(), 11);
			  
  } 	
  
  
  /*
  A sample spreadsheet:
  ---------------------

   |  A(1)    |  B(2)   |  C(3)   |  D(4)   |  E(5)     | 
---+-----------+---------+---------+---------+-----------+ 
 1 |    8      |    3    |    4    |    6    |    2      | 
---+-----------+---------+---------+---------+-----------+ 
 2 | mn A1 E1  | + B1 C1 |  ref(A3)|         | * B2 D1   | 
---+-----------+---------+---------+---------+-----------+ 
 3 | * A1 A2   | + B2 B1 ||A1 - B1||         | mn A3 D1  | 
---+-----------+---------+---------+---------+-----------+ 
 4 |           | + B3 B2 |         |         | mn B4 D1  | 
---+-----------+---------+---------+---------+-----------+ 
 5 |           | + B4 B3 |         |         | * B5 E4   | 
---+-----------+---------+---------+---------+-----------+ 

  A sample spreadsheet:
  ---------------------

   |  A(1)    |  B(2)   |  C(3)   |  D(4)   |  E(5)     | 
---+-----------+---------+---------+---------+-----------+ 
 1 |    8      |    3    |    4    |    6    |    2      | 
---+-----------+---------+---------+---------+-----------+ 
 2 |    6      |    7    |    48   |         |    42     | 
---+-----------+---------+---------+---------+-----------+ 
 3 |    48     |   10    |    5    |         |    42     | 
---+-----------+---------+---------+---------+-----------+ 
 4 |           |   17    |         |         |    11     | 
---+-----------+---------+---------+---------+-----------+ 
 5 |           |   27    |         |         |    38     | 
---+-----------+---------+---------+---------+-----------+ 

*/
}