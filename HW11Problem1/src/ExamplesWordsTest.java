import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class ExamplesWordsTest {

	Word me = new Word("me");
	WordCounter word = new WordCounter();
	ArrayList<Word> list = new ArrayList<Word>();





	public void initData(){
		list.add(new Word("hey"));
		list.add(new Word("bye"));
		list.add(new Word("hey"));
		list.add(new Word("bye"));
	}

	@Test
	public void test() {
		initData();
		assertEquals(true, new Word("hey").equals(new Word("hey")));
		assertEquals("hey has 1 occurences", new Word("hey").toString());
		word.countWords(list.iterator());
		assertEquals(4, word.words());

	}

}
