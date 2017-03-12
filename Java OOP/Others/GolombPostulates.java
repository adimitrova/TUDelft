import java.util.Scanner;

/**
 * Golomb postulates:
 * 1. #1s > #0s
 * 2. r(1) >= r(2) >= r(3) > r(4) // should decrease
 * 3. c(1) = c(2) = c(3) = c(n) = const
 * if 1,2 & 3 are true => pseudorandom number
 * 
 * @author Aneliya Dimitrova
 * TODO: complete
 */

public class GolombPostulates {

	private static boolean FirstPost(int input){
		boolean met = false;
		int ones = 0;
		int zeros = 0;
		String count = String.valueOf(input);
		
		for (int i = 0; i < count.length(); i++) {
			if(count.charAt(i) == '0'){
				zeros = zeros + 1;
			}
			else if(count.charAt(i) == '1'){
				ones = ones + 1;
			}
		}
		
		if(ones > zeros){
			met = true;
		}
		
		System.out.println("First Golomb Postulate is: " + met);
		return met;
	}
	
	
	private static boolean SecondPost(int input){
		boolean met = false;
		
		//TODO: Complete
		
		System.out.println("First Golomb Postulate is: " + met);
		return met;
	}
	
	
	private static boolean ThirdPost(int input){
		boolean met = false;
		
		//TODO: Complete
		
		System.out.println("First Golomb Postulate is: " + met);
		return met;
	}
	
	
	/* --------------- MAIN METHOD --------------- */
	public static void main(String[] args) {
		System.out.println("Please enter a binary number with max length 10 digits: ");
		Scanner inp = new Scanner(System.in);
		int number = inp.nextInt();
		
		FirstPost(number);
	}

}
