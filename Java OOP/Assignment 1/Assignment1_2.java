
public class Assignment1_2 {

	public static void main(String[] args) {
		int one = 1;
		int two = 2;
		int three = 3;
		int temp;
		System.out.println("one: " + one + " two: " + two + " three: " + three);
		
		temp = one;
		one = two;
		two = three;
		three = temp;
		System.out.println("one: " + one + " two: " + two + " three: " + three);
	}

}
