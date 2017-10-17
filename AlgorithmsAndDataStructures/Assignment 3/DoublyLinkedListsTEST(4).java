import static org.junit.Assert.*;

import org.junit.Test;

public class UTest {

  @Test
  public void testDLListconstructor()
  {
    Solution.DLList list = new Solution.DLList();
    assertEquals(0, list.size());
  }


  @Test
  public void testAddAtZero() 
  {
    Solution.DLList list = new Solution.DLList();
    list.addFirst(new Solution.Node(3, null, null));
    list.addLast(new Solution.Node(2, null, null));
    list.addAtPosition(new Solution.Node(5, null, null),0);
    assertEquals(3, list.size());
    Solution.Node node = list.removeFromPosition(10);
    assertNull(node);
    assertEquals(3, list.size());
    
    assertEquals(3, list.removeFirst().getElement());
    assertEquals(5, list.removeFirst().getElement());
    
  } 
}
