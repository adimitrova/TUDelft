
public class Assignment2_1 {

	public static void println(int[] seq){
		for(int i=0; i<seq.length; i++){
			System.out.print(seq[i] + " ");
		}
		System.out.println();
	}
	
	public static void swap(int[] seq){
		// reverse order of array values
		for (int i = seq.length-1; i >= 0; i--) {
			System.out.print(seq[i] + " ");
		}
		System.out.println();
	}
	
	public static int[] copy(int[] seq){
		int arrNum = seq.length;
		int[] copyArr = new int[arrNum];
		
		for (int i = 0; i < arrNum; i++) {
			copyArr[i] = seq[i];
		}
		return copyArr;
	}
	
	public static void rotate(int[] seq){
		int[] origArr = seq;
		int[] shiftedArr = new int[seq.length];
		
		for (int i = 0; i <= origArr.length-1; i++) {
			for (int j = i+1; j < shiftedArr.length; j++) {
				shiftedArr[j] = origArr[i];
				System.out.print(shiftedArr[j] + " ");
			}
		}
	}
	
	
	// ------------ MAIN METHOD ----------------
	public static void main(String[] args) {
		System.out.print("You entered array: "); 
		println(new int[]{1,54,2});
		
		int[] sequence = {1,23,6,5,24,34,54,2};
		System.out.print("Reversed order: "); 
		swap(sequence);
		
		int[] sequence2 = {1,62,42,53,4,1,96,5};
		System.out.print("Copy of your array: ");
		// IF WITHOUT java.util.Arrays.toString we get [I@15db9742
		System.out.println(java.util.Arrays.toString(copy(sequence2)));
		
		rotate(new int[]{1, 2, 3,4,5,6,7});
	}

}
