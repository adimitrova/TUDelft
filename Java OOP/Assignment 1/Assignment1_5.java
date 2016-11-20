import java.util.Scanner;

public class Assignment1_5 {

	public static void main(String[] args) {
		System.out.print("Enter N: ");
		Scanner userInput = new Scanner(System.in);
		int numN = userInput.nextInt();
		
		for (int i = 1; i <= numN; i++) {
			// why second one works with numN-1???
			for (int j = 1; j <= numN-1; j++) {
				System.out.print("*");
			}
			System.out.println("*");
		}
	}
}
