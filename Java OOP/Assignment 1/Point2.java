import java.util.Scanner;

public class Point2 {
	private Scanner dxdy;
	
	// constructor Point (method):
	public double Point(double xCoord, double yCoord){	
		final double x;  	// field of type double
		final double y;	// field of type double
		Point p;
		
		x = xCoord;
		y = yCoord;
		
		public double GetX(x){
			return x;
		}
		
		public double GetY(){
			return y;
		}
		
		public static void toString(String[] args) {
			System.out.println("<Point" + x + "," + y + ">");
		}
		
		public void translate(double dx, double dy){
			dxdy = new Scanner(System.in);
			double dxx = dxdy.nextDouble();
			double dyy = dxdy.nextDouble();
			
			double resultX = x+dxx;
			double resultY = x+dyy;
			System.out.println("X+DX: " + resultX);
			System.out.println("Y+DY: " + resultY);
		}
	}
}
