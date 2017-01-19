import java.util.Scanner;

public class Temperature {

	/** 
	 * @Notes to myself:
	 * Method to enter the values of the array
	 * The array get as input parameter the ORIGINAL array
	 * (as arrays are passed by reference and Java does not make a copy of the array)
	 * we DO NOT need to return value in this method
	 * i.e. our method is VOID
	 * @param tempIn
	 */
	private static void enterTemp(double[] tempIn){
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < tempIn.length; i++) {
			System.out.print("Temperature for day " + (i+1) + ":");
			tempIn[i] = input.nextDouble();
		}
	}
	
	//Method to display entered values of the array
	private static void displayTemp(double[] tempIn){
		System.out.println();
		System.out.println("***TEMPERATURES***");
		for (int i = 0; i < tempIn.length; i++) {
			System.out.println("Day " + (i+1) + ": " + tempIn[i]);
		}
	}
	
	//Method to display average temp
	private static void average(double[] tempIn){
		double sum = 0;
		double average;
		
		System.out.println();
		for (int i = 0; i < tempIn.length; i++) {
			sum += tempIn[i];
		}
		average = sum / tempIn.length;
		// FORMAT DOUBLE VALUE TO SHOW UP TO 1st VALUE AFTER DECIMAL POINT: 	String.format("%.1f",(VARIABLE))
		System.out.println("Average temperature for the week: " + String.format("%.1f",average) + "°C"); // Alt+248 for °
	}
	
	public static void main(String[] args) {
		double[] temp = new double[7];
		enterTemp(temp);
		displayTemp(temp);
		average(temp);
	}

}
