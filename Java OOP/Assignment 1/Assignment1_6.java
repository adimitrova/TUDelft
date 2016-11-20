import java.util.Scanner;

public class Assignment1_6 {

	public static void main(String[] args) {
		System.out.print("Enter N: ");
		Scanner userInput = new Scanner(System.in);
		int numN = userInput.nextInt();
		
		for (int row = 1; row <= numN; row++) {
			for (int col = 1; col <= row; col++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

}
