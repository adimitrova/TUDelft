import static org.junit.Assert.*;

import org.junit.Test;

public class UTest {

	final static Quaternion p = new Quaternion(2.0, 0.0, -3.0, 0.0);
	final static Quaternion q = new Quaternion(0.0, 1.0, 1.0, -2.0);
	
	@Test
	public void testToStringP() {
		assertEquals("2.0 + 0.0i + -3.0j + 0.0k", p.toString());
	}

	@Test
	public void testToStringQ() {
		assertEquals("0.0 + 1.0i + 1.0j + -2.0k", q.toString());
	}
	
	@Test 
	public void testAdd() {
	  Quaternion r = p.add(q);
	  assertEquals(2.0, r.getA(), 0.0001);
	  assertEquals(1.0, r.getX(), 0.0001);
	  assertEquals(-2.0, r.getY(), 0.0001);
	  assertEquals(-2.0, r.getZ(), 0.0001);
	}
	
	@Test 
	public void testMul() {
	  Quaternion r = p.mul(q);
	  assertEquals(3.0, r.getA(), 0.0001);
	  assertEquals(8.0, r.getX(), 0.0001);
	  assertEquals(2.0, r.getY(), 0.0001);
	  assertEquals(-1.0, r.getZ(), 0.0001);
	}
	
	@Test
	public void testRobustAdd() {
		try {
			p.add(null);
		} catch (IllegalArgumentException e) {
		
		} catch (NullPointerException e) {
			fail();
		}
	}

	@Test
	public void testRobustMul() {
		try {
			p.mul(null);
		} catch (IllegalArgumentException e) {
		
		} catch (NullPointerException e) {
			fail();
		}
	}
	
	@Test 
	public void testConjugateP() {
	  Quaternion r = p.conjugate();
	  assertEquals(2.0, r.getA(), 0.0001);
	  assertEquals(0.0, r.getX(), 0.0001);
	  assertEquals(3.0, r.getY(), 0.0001);
	  assertEquals(0.0, r.getZ(), 0.0001);
	}

	@Test 
	public void testConjugateQ() {
	  Quaternion r = q.conjugate();
	  assertEquals(0.0, r.getA(), 0.0001);
	  assertEquals(-1.0, r.getX(), 0.0001);
	  assertEquals(-1.0, r.getY(), 0.0001);
	  assertEquals(2.0, r.getZ(), 0.0001);
	}
	
	@Test 
	public void testNormP() {
		assertEquals(Math.sqrt(13), p.norm(), 0.0001);
	}
	
	@Test 
	public void testNormQ() {
		assertEquals(Math.sqrt(6), q.norm(), 0.0001);
	}

	@Test 
	public void testReciprocalP() {
	  Quaternion r = p.reciprocal();
	  assertEquals(0.15384615384615385, r.getA(), 0.0001);
	  assertEquals(0.0, r.getX(), 0.0001);
	  assertEquals(0.23076923076923078, r.getY(), 0.0001);
	  assertEquals(0.0, r.getZ(), 0.0001);
	}
	
	@Test 
	public void testReciprocalQ() {
	  Quaternion r = q.reciprocal();
	  assertEquals(0.0, r.getA(), 0.0001);
	  assertEquals(-0.16666666666666669, r.getX(), 0.0001);
	  assertEquals(-0.16666666666666669, r.getY(), 0.0001);
	  assertEquals( 0.33333333333333337, r.getZ(), 0.0001);
	}
}//
