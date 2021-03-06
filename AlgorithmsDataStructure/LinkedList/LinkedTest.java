import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedTest {

	@Test
	public void complexTest() {
		LinkedList test = new LinkedList();
		test.addInTail(new Node(5));
		test.showHead();
		test.showTail();
		test.addInTail(new Node(6));
		test.showHead();
		test.showTail();
		test.remove(5);
		test.remove(5);
		test.clear();
		for(int i = 0; i < 100; i++)
			test.addInTail(new Node(i));
		test.display();
		test.remove(9);
		test.display();	
		test.removeAll(8);
		test.display();
		test.removeAll(7);
		test.removeAll(0);
		test.display();
		test.insertAfter(new Node (3), new Node(6));
		test.insertAfter(new Node (99), new Node(1));
		test.display();
		test.removeAll(6);
		test.remove(99);
		test.remove(1);
		test.remove(1);
		assertNotNull(test.find(2));
		test.display();
		test.clear();
		assertNull(test.find(2));
		test.addInTail(new Node(2));
		assertNotNull(test.find(2));
		test.display();
		for(int i = 0; i < 4;i++)
		test.addInTail(new Node(1));
		test.display();
		test.remove(1);
		test.remove(2);
		test.display();
		test.addInTail(new Node(2));
		test.insertAfter(new Node(1), new Node(3));
		test.remove(1);
		assertNotNull(test.find(3));
		assertNotNull(test.find(2));
		test.remove(2);
		assertNull(test.find(2));
		test.insertAfter(new Node(3), new Node(2));
		for(int i = 0; i < 3; i++)test.insertAfter(new Node(3), new Node(3));
		test.insertAfter(new Node(2), new Node(4));
		test.display();
		test.removeAll(3);
		test.removeAll(1);
		test.display();
		test.clear();
		test.addInTail(new Node(2));
		test.display();
		test.removeAll(2);
		assertNull(test.find(2));
		for(int i = 0; i < 3;i++)test.addInTail(new Node(2));
		test.addInTail(new Node(4));
		test.addInTail(new Node(3));
		test.addInTail(new Node(2));
		test.removeAll(2);
		test.display();
		test.clear();
		test.addInTail(new Node(1));
		test.addInTail(new Node(1));
		test.addInTail(new Node(1));
		test.addInTail(new Node(2));
		test.addInTail(new Node(1));
		test.display();
		test.remove(1);
		test.remove(1);
		test.remove(1);
		test.display();
		test.removeAll(1);
		test.display();
		for(int i = 0; i < 7;i++)test.addInTail(new Node(i));
		test.insertAfter(new Node(6), new Node(1));
		test.insertAfter(new Node(1), new Node(1));
		
		test.display();
		test.remove(2);
		test.display();
		test.remove(6);
		test.display();
		test.remove(0);
		test.display();
		test.removeAll(1);
		test.display();
		test.clear();
		test.addInTail(new Node(2));
		test.display();
		test.removeAll(2);
		assertNull(test.find(2));
	}
	
	@Test
	public void add() {
		LinkedList list = new LinkedList();
		for(int i = 0; i < 4; i++)
			list.addInTail(new Node(i));
		list.addInTail(new Node(10));
		list.insertAfter(new Node(0), new Node(4));
		list.remove(0);list.remove(10);
		list.display();
	}
	
	
	
	@Test
	public void insertAfter() {
		LinkedList list = new LinkedList();
		list.insertAfter(new Node(0), new Node(1));
		for(int i = 0; i < 5; i++)list.addInTail(new Node(i));
		list.insertAfter(new Node(0), new Node(5));
		list.insertAfter(new Node(4), new Node(6));
		list.showTail();
		list.clear();
		list.insertAfter(new Node(0), new Node(2));
		list.display();
	}
	
	@Test
	public void remove() {
		LinkedList list = new LinkedList();
		list.addInTail(new Node(5));
		assertTrue(list.remove(5));
	//	list.addInTail(new Node(9));
		list.showTail();
	}
	
	
	@Test
	public void removeAll() {
		LinkedList list = new LinkedList();
		list.addInTail(new Node(1));
		list.removeAll(1);
	}
	
	@Test
	public void count() {
		LinkedList list = new LinkedList();
		list.count();
		for(int i = 0; i < 4; i++)list.addInTail(new Node(i));
		list.count();
		list.clear();
		list.count();
	}


}
