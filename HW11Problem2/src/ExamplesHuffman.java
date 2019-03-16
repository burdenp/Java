// Assignment 11 Problem 2
// Partner Patrick Burden
// partner1username pburden
// Partner Name2 Seydi Sy
// partner2username Seydi
// 2 April 2012



import java.util.ArrayList;
import tester.Tester;


public class ExamplesHuffman {
	
	Algorithms alg = new Algorithms();
    ArrayList<LF> histogram = new ArrayList<LF>();
    LF o2 = new LF("o", 2 );
    LF h1 = new LF("h", 1);
    LF a2 = new LF("a", 2);
    LF e2 = new LF("e", 2);
    LF s2 = new LF("s", 2);
    LF c01 = new LF("c", 1);
    LF n1 = new LF("n", 1);
    LF y2 = new LF("y", 2);
    LF u1 = new LF("u", 1);
    LF space4 = new LF(" ", 4);
    LF coma2 = new LF(",", 2);
    LF changing = new LF("a", 1);
    
    KeyTree c1 = new Leaf("c", 1);
    KeyTree b1 = new Leaf("b", 1);
    KeyTree a3 = new Leaf("a", 3);
    KeyTree t3 = new Leaf("t", 3);
    KeyTree two1 = new Node(c1, b1);
    KeyTree six1 = new Node(a3, t3);
    KeyTree sp2 = new Leaf("sp", 2);
    KeyTree four1 = new Node(two1, sp2);
    KeyTree ten1 = new Node(six1, four1);
    
    KeyTree t1 = new Leaf("t", 1);
    KeyTree sp1 = new Leaf("sp", 1);
    KeyTree h2 = new Leaf("h", 2);
    KeyTree r2 = new Leaf("r", 2);
    KeyTree e4 = new Leaf("e", 4);
    KeyTree two2 = new Node(t1, sp1);
    KeyTree four2 = new Node(h2, r2);
    KeyTree six2 = new Node(e4, two2);
    KeyTree ten2 = new Node(four2, six2);
    
    

    KeyTree h11 = new Leaf("h", 1);
    KeyTree c011 = new Leaf("c", 1);
    KeyTree n11 = new Leaf("n", 1);
    KeyTree u11 = new Leaf("u", 1);
    KeyTree o21 = new Leaf("o", 2);
    KeyTree a21 = new Leaf("a", 2);
    KeyTree e21 = new Leaf("e", 2);
    KeyTree s21 = new Leaf("s", 2);
    KeyTree y21 = new Leaf("y", 2);
    KeyTree coma21 = new Leaf(",", 2);
    KeyTree space41 = new Leaf(" ", 4);
    KeyTree two3 = new Node(h11, c011);
    KeyTree two4 = new Node(n11, u11);
    KeyTree four3 = new Node( o21, a21);
    KeyTree four4 = new Node(e21, s21);
    KeyTree six3 = new Node(y21, two3);
    KeyTree six4 = new Node(two4, space41);
    KeyTree eight = new Node(four3, four4);
    KeyTree twelve = new Node(six3, six4);
    KeyTree twenty = new Node(eight, twelve);
    
    KeyTree kt1 = new Node(space41, e21);
    KeyTree kt2 = new Node(kt1, o21);
    KeyTree kt3 = new Node(kt2, s21);
    KeyTree kt4 = new Node(kt3, coma21);
    KeyTree kt5 = new Node(kt4, a21);
    KeyTree kt6 = new Node(kt5, y21);
    KeyTree kt7 = new Node(kt6, n11);
    KeyTree kt8 = new Node(kt7, u11);
    KeyTree kt9 = new Node(kt8, c011);
    KeyTree kt10 = new Node(kt9, h11);
    
    ByFreq freqComp = new ByFreq();
    
    
    public void initData(){
    	histogram.clear();
        histogram.add(o2);
        histogram.add(h1);
        histogram.add(coma2);
        histogram.add(space4);
        histogram.add(s2);
        histogram.add(a2);
        histogram.add(y2);
        histogram.add(c01);
        histogram.add(n1);
        histogram.add(u1);
        histogram.add(e2);

    }
    public void testAlgorithms(Tester t){
    	initData();
    	t.checkExpect(alg.computeHisto("oh, say, can you see"), histogram);
    	t.checkExpect(alg.removeDuplicates(histogram), histogram);
    	changing.addFrequency("aa");
    	t.checkExpect(changing, new LF("a", 3));
    	t.checkExpect(alg.encodeString(ten1, "tbc"), "01101100");
    	t.checkExpect(alg.encodeString(ten2, "hre"), "000110");
    	initData();
    	t.checkExpect(alg.buildTree(alg.buildPQ(histogram)), kt10); 
    	
    }
    public void testKeyTree(Tester t){
    	t.checkExpect(freqComp.compare(t1, six2), 1);
    	t.checkExpect(freqComp.compare(six2, six2), 0);
    	t.checkExpect(freqComp.compare(six2, t1), -1);
    	t.checkExpect(ten1.findPath('t'), "01t");
    	t.checkExpect(ten2.findPath('t'), "110t");
    	t.checkExpect(ten1.nextLetter("01"), "t");
    	t.checkExpect(ten2.nextLetter("110"), "t");
    	t.checkExpect(ten1.decode("1000001"), "cat");
    	t.checkExpect(ten2.decode("1100010"), "the");
    }
}
