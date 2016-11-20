import java.util.Scanner;

public class Assignment1_3 {
	public static void main(String[] args) {
		System.out.print("Temp in Celcius: ");
		Scanner userInp = new Scanner(System.in);
		double tempC = userInp.nextInt();
		
		double tempF = 1.8 * tempC + 32.0;		
		System.out.println("Temp in Fahrenheit: " + tempF);	
	}
}
