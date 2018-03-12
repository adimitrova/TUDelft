import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Doubly Linked Lists Test cases
 * @author ani
 * @version 1 Dec 17
 */
public class NodeTest {

  @Test
  public void testDLListconstructor()
  {
	  DLList list = new DLList();
      assertEquals(0, list.size());
  }

  @Test
  public void testAddAtZero() 
  {
	  DLList list = new DLList();
	list.addFirst(new Node(3, null, null));
	list.addLast(new Node(2, null, null));
	list.addAtPosition(new Node(5, null, null),0);
	assertEquals(3, list.size());
	Node node = list.removeFromPosition(10);
	assertNull(node);
	assertEquals(3, list.size());
	
	assertEquals(3, list.removeFirst().getElement());
	assertEquals(5, list.removeFirst().getElement());
    
  } 
}
