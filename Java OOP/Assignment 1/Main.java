// MAIN CLASS 
public class Main {

	public static void main(String[] args) {
		// main method code	
		
		Point firstPoint = new Point(-34, 31);
		System.out.println("First point: " + firstPoint.toString());
		System.out.print("Translated point: "); 
		firstPoint.translate(3, 5.4);
		
		System.out.println("------------");
		
		Point secondPoint = new Point(-334, 31);
		System.out.println("Second point: " + secondPoint.toString());
		System.out.println("Distance between points = " + String.format("%.3f", firstPoint.distance(secondPoint)));
		System.out.println("Equal points check: " + firstPoint.equals(secondPoint));
		
		System.out.println("------------");		
		
		// new Point(X,Y)
		// new Circle(POINT,RADIUS)
		Point pnt1 = new Point(2,3); // new Point obj
		Circle circ1 = new Circle(pnt1,7); // new Circle obj
		System.out.println(circ1.toString());
		
		Point pnt2 = new Point(-1,1); // new Point obj
		Circle circ2 = new Circle(pnt2,5.2); // new Circle obj
		System.out.println("Second point: " + circ2.toString());
		
		System.out.println("Equal circles check: " + circ1.equals(circ2));
		System.out.println("Circle 1 perimeter = " + String.format("%.3f",  circ1.perimeter()));
		System.out.println("Circle 1 area = " + String.format("%.3f", circ1.area()));
		
		System.out.print("Circle 2 Translated center: "); 
		circ2.translate(3, 5.4);
		System.out.println("Circles overlapping? " + circ1.overlappingWith(circ2));
	}

}


/*		OUTPUT:
			First point: <Point(-34.0, 31.0)>
			Translated point: <Point(-31.0, 36.4)>
			------------
			Second point: <Point(-334.0, 31.0)>
			Distance between points = 303.048
			x1 = -31.0; x2 = -334.0
			y1 = 36.4; y2 = 31.0
			Equal points check: false
			------------
			<Circle(<Point(2.0, 3.0)>, 7.0)>
			Second point: <Circle(<Point(-1.0, 1.0)>, 5.2)>
			Equal circles check: false
			Circle 1 perimeter = 43.982
			Circle 1 area = 615.752
			Circle 2 Translated center: <Point(2.0, 6.4)>
			Radius difference: 1.800 | Center difference: 11.560 | Radius sum: 12.200
			Circles overlapping? true
*/