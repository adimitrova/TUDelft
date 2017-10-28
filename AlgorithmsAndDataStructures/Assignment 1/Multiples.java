class Multiples {
  /**
   * @param n
   * @param m
   * @returns true if and only if a is a multiple of b, that is, a = bi for some integer i.
   * If the remainder after dividing a by b is 0, then a is multiple of b
   */
  public static boolean isMultiple(long a, long b) {
	  long source = b;
	  long target = a;
	 
	  return target % source == 0;
  }
}
