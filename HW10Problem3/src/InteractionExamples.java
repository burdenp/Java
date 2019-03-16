// Assignment 10 Problem 3
// Partner Patrick Burden
// partner1username pburden
// Partner Name2 Seydi Sy
// partner2username seydi
// 27 March 2012


import java.util.ArrayList;

import tester.Tester;

public class InteractionExamples {
	InteractionExamples(){}
	
    ArrayList<String> whoList = new ArrayList<String>();
    
    Reply r1 = new Reply("who", whoList);
    ArrayList<String> whyList = new ArrayList<String>();
    
    Reply r2 = new Reply("why", whyList);
    ArrayList<String> howList = new ArrayList<String>();

    Reply r3 = new Reply("how", howList);
    ArrayList<String> whereList = new ArrayList<String>();

    Reply r4 = new Reply("where", whereList);
    ArrayList<String> whenList = new ArrayList<String>();
    
    Reply r5 = new Reply("when", whenList);
    ArrayList<String> whatList = new ArrayList<String>();

    Reply r6 = new Reply("what", whatList);
    ArrayList<Reply> elList = new ArrayList<Reply>();
  
    Eliza el = new Eliza(elList);
    public void initData(){
    	 whoList.add("Him");
    	 whoList.add("Her");
    	 whoList.add("They");
    	 whyList.add("I wanted to");
    	 whyList.add("I can");
    	 whyList.add("To see what would happen");
    	 howList.add("It depends");
    	 howList.add("It is up to you");
    	 howList.add("Its complicated");
    	 whereList.add("In the car");
    	 whereList.add("In the house");
    	 whereList.add("In the office");
    	 whenList.add("In the morning");
    	 whenList.add("In the afternoon");
    	 whenList.add("At night");
    	 whatList.add("Google it");
    	 whatList.add("Say what again");
    	 whatList.add("Its a long story");
    	 elList.add(r1);
    	 elList.add(r2);
    	 elList.add(r3);
    	 elList.add(r4);
    	 elList.add(r5);
    	 elList.add(r6);
    	 
    }
    public void testEliza(Tester t){
    	t.checkExpect(el.firstWord(" Who "), "who");
    	t.checkExpect(el.firstWord("Who "), "who");
    	t.checkExpect(el.firstWord("WHat ww"), "what");
    	t.checkExpect(el.firstWord("Where ww"), "where");
    }
    public void testReply(Tester t){
    	this.initData();
    	t.checkExpect(r1.answers.contains(r1.RandomAnswer()), true);
    	t.checkExpect(r2.answers.contains(r2.RandomAnswer()), true);
    	t.checkExpect(r3.answers.contains(r3.RandomAnswer()), true);
    	t.checkExpect(r4.answers.contains(r4.RandomAnswer()), true);
    	t.checkExpect(r5.answers.contains(r5.RandomAnswer()), true);
    	t.checkExpect(r6.answers.contains(r6.RandomAnswer()), true);
    }
    
}
