import java.util.Scanner;

public class Assignment1_7 {

	public static void main(String[] args) {
		System.out.println("Bigger num: " + Assignment1_7.max(5.2,4.2));
		// CALLING A METHOD TO PRINT OUTPUT: 
		// System.out.println(CLASS.METHOD(PAR1,PAR2);
		
		System.out.println("Absolute num: " + Assignment1_7.abs(-15));
		System.out.println("Squared: " + Assignment1_7.squared(15));
		
		System.out.println("Enter x1, y1, x2 and y2 in this order: ");
		Scanner input = new Scanner(System.in);
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		
		Assignment1_7.distance(x1, y1, x2, y2);
	}

	//Returns the largest value of x and y.
	public static double max(double x, double y){
		if (x > y){
			return x;
		} else {
			return y;
		}
	}
	
	//Returns the absolute value of x.
	public static int abs(int x){
		if(x<0){
			x = x*(-1);
			return x;
		} else {
			return x;
		}
	}
	
	//Returns the squared value of x.
	public static int squared(int x){
		x = x*x;
		return x;
	}
	
	//Returns the distance between coordinates (x1, y1) and (x2, y2). Pythagorean theorem.
	// formula: |AB|=√|AC|2+|BC|2= √ (x2-x1)2+(y2-y1)2
	public static double distance(double x1,double y1,double x2, double y2){
		// (a-b)^2 = a^2 - 2ab + b^2
		double intRes1 = Math.pow(x2, 2) - 2*x2*x1 + Math.pow(x1, 2);
		double intRes2 = Math.pow(y2, 2) - 2*y2*y1 + Math.pow(y1, 2);		
		double result = Math.sqrt(intRes1+intRes2);
		System.out.println(String.format("%.3f", result)); // rounds the result to 3 digits after decimal point
		return result;
	}
}
