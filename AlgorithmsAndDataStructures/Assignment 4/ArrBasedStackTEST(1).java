package weblab;
import static org.junit.Assert.*;
import org.junit.Test;

public class UTest
{
  @Test
  public void testConstructor()
  {
    ArrayStack tmp = new ArrayStack();
    assertArrayEquals(new Object[1],tmp.getElements());
  }
  
  @Test
  public void testToStringTwo() {
    ArrayStack s = new ArrayStack();
    s.push(1);
    s.push(2);
    assertEquals("<ArrayStack[1,2]>(Size=2, Cap=2)",  s.toString());
  }
  
  @Test
  public void testGrowShrink() {
    ArrayStack s = new ArrayStack();
    s.push(1);
    s.push(2);
    assertEquals("<ArrayStack[1,2]>(Size=2, Cap=2)",  s.toString());
    s.push(3);
    assertEquals(4, s.getElements().length);
    s.pop();
    s.pop();
    s.pop();
    assertEquals(2, s.getElements().length);
  }
}