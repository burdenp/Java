
// Assignment 1 Problem 1
// Partner Patrick Burden
// partner1username pburden
// Partner Name2 Seydi Sy
// partner2username Seydi
// 2 April 2012


import java.util.*;
import tester.*;

/** Class to hold examples of data and tests */
public class ExamplesWords{

    public ExamplesWords() {}
    
    Word me = new Word("me");
    WordCounter word = new WordCounter();
    ArrayList<Word> list = new ArrayList<Word>();
    
    
    public void initData(){
    	list.add(new Word("hey"));
    	list.add(new Word("bye"));
    	list.add(new Word("hey"));
    	list.add(new Word("bye"));
    }
    
    /** Test Word Classes... */
    public void testWords(Tester t){      	
        initData();
    	
        t.checkExpect(new Word("hey").equals(new Word("hey")), true);
        t.checkExpect(new Word("hey").equals(new Word("you")), false);
        t.checkExpect(new Word("hey").toString(), "hey has 1 occurences");
        t.checkExpect(new Word("hey").equals(new Word("hey")), true);
        
        word.countWords(list.iterator());
        t.checkExpect(word.words(), 4);
        
        
        
        WordCounter wc = new WordCounter();
        wc.countWords(new StringIterator(new StringBuffer("The Words Are")));
        t.checkExpect(wc.words(), 3);
        
        WordCounter macbeth = new WordCounter();
        macbeth.countWords(new StringIterator("Macbeth.txt"));
        macbeth.printWords(10);
    }

    public void testStringIter(Tester t){
        StringIterator wrds = new StringIterator(new StringBuffer("The Words Are"));
        
        int i = 0;
        for(Word w : wrds){
            System.out.println(" Word["+ (i++) +"] : "+w);
        }
    }
}