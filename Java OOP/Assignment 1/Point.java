import java.util.*;
import java.text.DecimalFormat;

public class Point {

	//static // declaring the class fields
	double xCoord;
	double yCoord;
	
	// define a constructor
	public Point(double x, double y){
		xCoord = x;
		yCoord = y;
	}
	
	private double getX(){
		return xCoord;
	}
	
	private double getY(){
		return yCoord;
	}
	
	// overriding the String toString() method to return the point coordinates
	public String toString(){
		String text = "<Point(%s, %s)>";
		String pointCoord = String.format(text, xCoord, yCoord);
		return pointCoord;
	}
	
	public void translate(double dx, double dy){
		//System.out.println("Original x = " + xCoord + " and y = " + yCoord);
		//System.out.println("Increment x with " + dx + " and y with " + dy);
		xCoord = xCoord + dx;
		yCoord = yCoord + dy;
		//print the new point coordinates with the method toString() we created above
		System.out.println(toString()); 
	}
	
	public double distance(Point other) {
		// d = sqrt((x2-x1)^2 + (y2-y1)^2)
		double pX = Math.abs(this.getX() - other.getX()); // calculate (x2-x1)
		double pY = Math.abs(this.getY() - other.getY()); // calculate (y2-y1)
		double dist = Math.sqrt(Math.pow(pX, 2) + Math.pow(pY, 2)); // calculate sqrt(pX^2 + pY^2)
		return dist;
	}
	
	public boolean equals(Object other){
		Point p2 = (Point) other ; //make "other" a POINT object to compare it with the first one
		if (this.getX() == p2.getX() && this.getY() == p2.getY()){
			System.out.println("x1 = " + this.getX() + "; x2 = " + p2.getX());
			System.out.println("y1 = " + this.getY() + "; y2 = " + p2.getY());
			return true;
		}
		else {
			System.out.println("x1 = " + this.getX() + "; x2 = " + p2.getX());
			System.out.println("y1 = " + this.getY() + "; y2 = " + p2.getY());
			return false;
		}
	}
	

	// ---------------------- MAIN METHOD -------------------------------
	public static void main(String[] args) {
		Point first = new Point(-34, 31);
		//System.out.println(first.toString());
		//first.translate(3, 5.4);
		
		Point second = new Point(-34, 31);
		//System.out.println(second.toString());
		//System.out.println("Distance between points = " + String.format("%.3f", first.distance(second)));
		
		System.out.println("Equal points check: " + first.equals(second));
	}
}