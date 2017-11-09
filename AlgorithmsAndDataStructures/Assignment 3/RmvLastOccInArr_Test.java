import static org.junit.Assert.*;
import org.junit.*;

public class RmvLastOccInArr_Test{
	@Test
	public void testRemoveArray_Empty() {
		int[] array = new int[0];
		assertEquals(0, remLastOccInArr.removeLastOccurence(5, array).length);
	}
	
	@Test
	public void testFirstSimple() {
		int[] input = {1,2,3,4,5,6,7,8,9,10};
		int[] result = {2,3,4,5,6,7,8,9,10};
		assertArrayEquals(result, remLastOccInArr.removeLastOccurence(1, input));
	}
	
	@Test
	public void testLast() {
		int[] input = {1,2,3,4,5,6,7,8,9,10,9};
		int[] result = {1,2,3,4,5,6,7,8,9,10};
		assertArrayEquals(result, remLastOccInArr.removeLastOccurence(9, input));
	}
}