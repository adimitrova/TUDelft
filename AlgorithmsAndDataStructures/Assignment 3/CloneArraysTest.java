import org.junit.*;
import static org.junit.Assert.*;

public class UTest
{
	@Test
	public void cloneEmpty() {
	  
	  float[][] empty = new float[0][0];
	  float[][] clone = Solution.clone(empty);
	  
	  assertEquals(empty.length, clone.length);
	}
	
	@Test
	public void cloneSingle() {
	  
	  float[][] empty = {{1.5f}};
	  float[][] clone = Solution.clone(empty);
	  
	  assertEquals(empty.length, clone.length);
	  assertEquals(empty[0].length, clone[0].length);
	  assertEquals(empty[0][0], clone[0][0], 0);
	}
	
	@Test
	public void cloneLonger() {
	  
	  float[][] empty = {{1.5f, -10.3f, 0}, {-2.5f, 8, 1.3f}};
	  float[][] clone = Solution.clone(empty);
	  
	  assertEquals(empty.length, clone.length);
	  assertEquals(empty[0].length, clone[0].length);
	  assertEquals(empty[0][0], clone[0][0], 0);
	  assertEquals(empty[0][1], clone[0][1], 0);
	  assertEquals(empty[0][2], clone[0][2], 0);
	  assertEquals(empty[1][0], clone[1][0], 0);
	  assertEquals(empty[1][1], clone[1][1], 0);
	  assertEquals(empty[1][2], clone[1][2], 0);
	}
}