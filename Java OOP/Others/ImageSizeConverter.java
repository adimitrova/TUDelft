import java.util.Scanner;

/**
 * 
 * @author Ani
 *	options: 1 for cm, 2 for pixels, 3 for sizes, 4 for size ratio
 *		- case 3: case a1, a2, a3, a4, a5, a6
 *		- case 4: case a1, a2, a3, a4, a5, a6
 *			- options for percent of a given size
 *			- enter percent
 *			- output size in pixels and cm (width and height) 
 */

public class ImageSizeConverter {

	public static void menu(){
		Scanner inp = new Scanner(System.in);
		System.out.println("Press 1 to convert cm to px");
		System.out.println("Press 2 to convert px to cm");
		System.out.println("Press 3 to for a certain size");
		System.out.println("Press 4 to for certain size ratio converting");
		System.out.println("Press 9 to exit");
		int choice = inp.nextInt();
		
		switch (choice) {
		case 1:
			System.out.print("Enter width in cm: ");
			int widthCM = inp.nextInt();
			System.out.print("Enter height in cm: ");
			int heightCM = inp.nextInt();
			
			cm(heightCM,widthCM);
			break;
		case 2:
			// call method
			break;
		case 3:
			//call method
			break;
		case 4:
			// call method
			break;
		case 9:
			// exit the program
			break;

		default:
			System.out.println("Invalid choice, please start over");
			break;
		}
	}
	
	public static void cm(int height, int width){
		double convH = height * 118.1034482758621;
		double convW = width * 118.1034482758621;
		System.out.println("Converted values in pixels: " + String.format("%.0f", convW) + " x " + String.format("%.0f", convH) + " [W x H]");
	}
	
	
	// ------------------------------ MAIN METHOD ----------------------------------
	public static void main(String[] args) {
		menu();
	}

}
