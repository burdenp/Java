import tester.*;

public class Examples {
			Examples(){reset();}
			Deque Mt;
			AbstNode n1;
			AbstNode n2;
			AbstNode n3;
			public void reset(){
			 Mt = new Deque();
			 n1 = Mt.addToHeadNode(new Node("ghi", null, null));
			 n2 = Mt.addToHeadNode(new Node("abc", null, null));
			 n3 = n2.addAfterNode(new Node("def", null, null));
			}
// Test the addAtHead method
			public void testAddAtHead (Tester t){
				reset();
				Mt.addAtHead("abc");
				t.checkExpect(Mt.head.dataList(), n2.next.dataList());
				Mt.head.data.concat(Mt.head.next.data.concat(Mt.head.next.next.data));
				reset();
			}
			public void testAddAtTail(Tester t){
				reset();
				Mt.addAtTail("abc");
				return t.checkExpect(Mt.head.dataList(), n2.next.dataList());
			}
			public void testSortAdd(Tester t){
				reset();
				Mt.sortAdd("abc");
				return t.checkExpect(Mt.head.dataList(), n2.next.dataList());
			}
			public void testInsertSorted(Tester t){
				reset();
				Mt.sortAdd("abc");
				return t.checkExpect(Mt.head.dataList(), n2.next.dataList());
			}
			public void testRemoveAtHead(Tester t){
				reset();
				n2.removeAtHead("abc");
				return t.checkExpect(Mt.head.dataList(), n2.next.dataList());
			}
			public void testRemoveAtHead(Tester t){
				reset();
				n2.removeAtTail("abc");
				return t.checkExpect(Mt.head.dataList(), n2.next.dataList());
			}
			public void testRemoveSorted(Tester t){
				reset();
				n2.removeSorted("abc");
				return t.checkExpect(Mt.head.dataList(), n2.next.dataList());
			}
			public boolean testSize(Tester t){
				reset();
				return t.checkExpect(n2.size(), 2);
			}
			public void testToLowerCase(Tester t){
				reset();
				n2.toLowerCase();
				return t.checkExpect(Mt.head.dataList(), n2.next.dataList());
			}
			
}

