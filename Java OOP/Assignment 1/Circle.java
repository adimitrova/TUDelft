import java.util.*;

public class Circle {

	// class fields
	Point center;
	double radius;
	
	//constructor
	public Circle(Point pntCenter, double rad){
		center = pntCenter;
		radius = rad;
		
		if(radius < 0){
			radius = Math.abs(rad);
		}
	}
	
	// get the center of curr obj
	private Point getCenter(){
		return this.center;
	}
	
	// get the radius of curr obj
	private double getRadius(){
		return this.radius;
	}
	
	// overriding the String toString() method to return the point coordinates
	public String toString(){
		String text = "<Circle(<Point(%s, %s)>, %s)>";
		String pointCoord = String.format(text, center.getX(), center.getY(), this.radius);
		return pointCoord;
	}
	
	// compare 2 circles
	public boolean equals(Object other){
		Circle circ2 = (Circle) other ; //make "other" a POINT object to compare it with the first one
		if (this.center.getX() == circ2.center.getX() 
								&& this.center.getY() == circ2.center.getY() 
								&& this.getRadius() == circ2.getRadius()){
			return true;
		}
		else {
			return false;
		}
	}
	
	public double perimeter(){
		// Circumference (periphery or perimeter) = 2*PI*r
		double periphery = 2*Math.PI*radius;
		return periphery;
	}
	
	public double area(){
		// Surface (area) = 4*PI*r^2
		double area = 4*Math.PI*Math.pow(radius, 2);
		return area;
	}
	
	public void translate(double dx, double dy){
		this.center.translate(dx, dy);
	}
	
	public boolean overlappingWith(Circle other){
/*		Two circles intersect if, and only if, 
		the distance between their centers is between the sum and the difference of their radii. 
		Given two circles (x0,y0,R0) and (x1,y1,R1), the formula is as follows:

		ABS(R0-R1) <= SQRT((x0-x1)^2+(y0-y1)^2) <= (R0+R1)
		Squaring both sides lets you avoid the slow SQRT, and stay with ints if your inputs are integer:

		(R0-R1)^2 <= (x0-x1)^2+(y0-y1)^2 <= (R0+R1)^2
		Since you need only a yes/no test, this check is faster than calculating the exact intersection points.*/

		double radDiff = Math.abs(this.radius - other.radius);
		double xDiff = Assignment1_7.squared((this.center.getX()-other.center.getX()));
		double yDiff = Assignment1_7.squared((this.center.getY()-other.center.getY()));
		double centerDiff = xDiff + yDiff;
		double radSum = Math.abs(this.radius + other.radius);

		// values check:
		System.out.println("Radius difference: " + String.format("%.3f",  radDiff) + 
						   " | Center difference: " + String.format("%.3f",  centerDiff) + 
						   " | Radius sum: " + String.format("%.3f",  radSum));
		
		if(radDiff <= centerDiff && centerDiff <= radSum){
			return true;
		}
		else{
			return false;
		}
	}
	
}
