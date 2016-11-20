import java.util.Scanner;

public class Assignment1_4 {
	public static void main(String[] args) {
		System.out.println("Enter 3 numbers: ");
		Scanner userInp = new Scanner(System.in);
		int num1 = userInp.nextInt();
		int num2 = userInp.nextInt();
		int num3 = userInp.nextInt();
		
		if(num1 > num2 && num1 > num3){
			System.out.println("First number is the biggest");
		} else if(num2 > num1 && num2 > num3){
			System.out.println("Second number is the biggest");
		} else if(num3 > num1 && num3 > num2){
			System.out.println("Third number is the biggest");
		}
	}
}
