import java.util.Scanner;

public class StringList {

	// class fields
	private String[] elements;
	private int amount;
	private static Scanner input;
	
	public StringList(int n){
		if(n < 0){
			elements = new String[0];
			amount = 0;
		} else {
			elements = new String[n];
			amount = n;
		}		
	}
	
	public void add(String el){
		if(amount < elements.length){
			for (int position = 0; position < elements.length; position++) {
				if(elements[position] == null){
					elements[position] = el;
					amount++;
				}
			}
		}
	}	
	
	public static void main(String[] args) {
		System.out.print("Enter initial number of elements: ");
		Scanner inpElInit = new Scanner(System.in);
		String elements = inpElInit.next();
		
		System.out.print("Enter initial amount: ");
		Scanner inpAmInit = new Scanner(System.in);
		double amount = inpAmInit.nextDouble();
		
		System.out.print("Enter new element: ");
		Scanner inpElNew = new Scanner(System.in);
		String newEl = inpElNew.next();
		//add(newEl);
	}

}
