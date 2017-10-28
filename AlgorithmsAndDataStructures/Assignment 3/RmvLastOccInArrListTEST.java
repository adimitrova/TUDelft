package weblab;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import static java.util.Arrays.asList;
	
public class UTest
{
	@Test
	public void testMultipleLast() {
		ArrayList<Integer> input = new ArrayList<Integer>(asList(1,1,3,5,7,1,5,9,1));
		ArrayList<Integer> result = new ArrayList<Integer>(asList(1,1,3,5,7,1,5,9));
		Solution.removeLastOccurence(1, input);
		assertEquals(result, input);
	}
}