// Assignment 7 Problem 1
// Partner James Kandebo
// partner1username Kandebo
// Partner Patrick Burden
// partner2username PBurden
// 27 February 2012

import tester.*;

// examples and tests for lists of Persons and Groups
class Examples{
  Examples(){}
  MtLoP emptyperson = new MtLoP();
  MtLoG emptygroup = new MtLoG();
  
  Person P1 = new Person ("Pat", 19, emptygroup);
  Person P2 = new Person ("Ben", 20, emptygroup);
  Person P3 = new Person ("Mary", 17, emptygroup);
 
  ConsLoP LoP1 = new ConsLoP (P1, new ConsLoP( P2, emptyperson));
  ConsLoP LoP2 = new ConsLoP (P3, LoP1);
  
  Group G1 = new Group ("CS2510", 18, LoP1);
  Group G2 = new Group ("Fundies 1", 17, LoP2);
  Group G3 = new Group ("Discrete Structures", 17, LoP1);
  Group G4 = new Group ("Logic and Computation", 18, LoP1);
  Group G5 = new Group ("College Writing", 17, LoP1);
  Group G6 = new Group ("Rock Music", 17, LoP2);
  Group G7 = new Group ("Psychology", 17, LoP1);
  Group G8 = new Group ("Sociology", 17, LoP2);
  
  ConsLoG LoG1 = new ConsLoG (G1, new ConsLoG (G2, emptygroup));
  ConsLoG LoG2 = new ConsLoG (G3, new ConsLoG (G4, emptygroup));
  ConsLoG LoG3 = new ConsLoG (G5, new ConsLoG (G6, new ConsLoG (G7, emptygroup)));

  
}
  