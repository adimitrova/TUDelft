package weblab;
import org.junit.*;
import static org.junit.Assert.*;

public class UTest
{
	@Test
  public void mp() {
    assertEquals(20, Multiplication.multiply(4,5));
  }
}
