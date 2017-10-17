import static org.junit.Assert.*;

import org.junit.Test;

public class UTest {

	final static Point p = new Point(4.0, 5.0, 6.0);
	final static Point q = new Point(1.0, 2.0, 3.0);
	
	@Test
	public void testToStringP() {
		assertEquals("<4.0, 5.0, 6.0>", p.toString());
	}

	@Test
	public void testToStringQ() {
		assertEquals("<1.0, 2.0, 3.0>", q.toString());
	}
	
		@Test
	public void testRotateP() {
		Point r = p.rotate(1, 2, 3, 90);
		assertEquals(1.4839305599770118, r.getX(), 0.0001);
		assertEquals(6.174996022903118, r.getY(), 0.0001);
		assertEquals(6.055359131405586, r.getZ(), 0.0001);
	}
	
	@Test
	public void testRotateQ() {
		Point r = q.rotate(4, 5, 6, 45);
		assertEquals(1.4357410990710693, r.getX(), 0.0001);
		assertEquals(1.539329069804002, r.getY(), 0.0001);
		assertEquals(3.0933983757826184, r.getZ(), 0.0001);
	}

	
	@Test
	public void testRobustRotate() {
		try {
			p.rotate(0, 0, 0, 180);
		} catch (IllegalArgumentException e) { return; }
		
		fail();
	}
}
//
