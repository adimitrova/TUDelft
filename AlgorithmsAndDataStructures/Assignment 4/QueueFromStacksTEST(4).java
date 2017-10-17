package weblab;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class UTest {
  
  @Test
  public void testFirstEmptyQueue() {
    try {
      new Queue<Integer>().first();
      fail();
    } catch (Exception e) {
    }
  }
  
  @Test
  public void testSingle() {
    for (int j = -5; j <= 5; j++) {
      Queue<Integer> q = new Queue<>();

      assertEquals(0, q.size());
      assertTrue(q.isEmpty());

      q.enqueue(j);

      assertEquals(1, q.size());
      assertFalse(q.isEmpty());

      assertEquals(new Integer(j), q.first());

      assertEquals(new Integer(j), q.dequeue());
      assertTrue(q.isEmpty());
    }
  }
}