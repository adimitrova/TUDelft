import static org.junit.Assert.*;

import org.junit.Test;

public class DLListTest {
	Node n1 = new Node(3, null, null);
	Node n2 = new Node(2, null, null);
	Node n3 = new Node(1, null, null);

	DLList dllist = new DLList();

	@Test
	public void test_Add() {
		dllist.addFirst(n1);
		dllist.addFirst(n2);
		dllist.addFirst(n3);
		
		// assert head and tail are as they shold be after adding several elements
		assertEquals(n1.getElement(), dllist.getHead().getElement());
	}

}
