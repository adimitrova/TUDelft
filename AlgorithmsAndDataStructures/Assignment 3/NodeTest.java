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
	  SolutionDLL.DLList list = new SolutionDLL.DLList();
    assertEquals(0, list.size());
  }


  @Test
  public void testAddAtZero() 
  {
	  SolutionDLL.DLList list = new SolutionDLL.DLList();
    list.addFirst(new SolutionDLL.Node(3, null, null));
    list.addLast(new SolutionDLL.Node(2, null, null));
    list.addAtPosition(new SolutionDLL.Node(5, null, null),0);
    assertEquals(3, list.size());
    SolutionDLL.Node node = list.removeFromPosition(10);
    assertNull(node);
    assertEquals(3, list.size());
    
    assertEquals(3, list.removeFirst().getElement());
    assertEquals(5, list.removeFirst().getElement());
    
  } 
}
