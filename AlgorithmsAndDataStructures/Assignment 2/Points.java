class Point {
	
	private final Quaternion pq;
	
	/**
	 * represents point <x, y, z>
	 */
	public Point(double x, double y, double z) {
		
	}
	
	/**
	 * @param pq quaternion representation of a point
	 */
	private Point(Quaternion pq) {
		
	}
	
	/**
	 * @return string representation of the point <x, y, z>
	 */
	@Override
	public String toString() {
    return "";
	}
	
	/**
	 * @return x coordinate
	 */
	public double getX() {
    return 0;
	}
	
	/**
	 * @return y coordinate
	 */
	public double getY() {
    return 0;
	}
	
	/**
	 * @return z coordinate
	 */
	public double getZ() {
    return 0;
	}
	
	/**
	 * @param x rotation vector
	 * @param y rotation vector
	 * @param z rotation vector
	 * @param alpha angle in degrees
	 * @return rotated point
	 */
	public Point rotate(double x, double y, double z, double alpha) {
		
		return null;
	}
}
//
