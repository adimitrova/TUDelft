import java.util.*;

public class Assignment2_1{

	/**
	 * Prints the sequence that was provided to the method
	 *
	 * @param seq
	 */
	public static void println(int[] seq){
		for(int i=0; i<seq.length; i++){
			System.out.print(seq[i] + " ");
		}
		System.out.println();
	}
	
	/**
	 * Reverses the order of array values
	 * 1 2 3 --> 3 2 1
	 *
	 * @param seq
	 */
	public static void swap(int[] seq){
		for (int i = seq.length-1; i >= 0; i--) {
			System.out.print(seq[i] + " ");
		}
		System.out.println();
	}
	
	/**
	 * Makes a copy of the provided array
	 *
	 * @param seq
	 */
	public static int[] copy(int[] seq){
		int arrNum = seq.length;
		int[] copyArr = new int[arrNum];
		
		for (int i = 0; i < arrNum; i++) {
			copyArr[i] = seq[i];
		}
		return copyArr;
	}
	
	
	/**
	 * Shifts the initial sequence provided to the right or to the left by 1 position
	 * left shift                 
	 * origArr [0] [1] [2] [3] j  
	 * copyArr [1] [2] [3] [0] i  
	 * right shift
	 * origArr [0] [1] [2] [3] i
	 * copyArr [3] [0] [1] [2] j
	 * 
	 * @param seq
	 */
	public static int[] rotate(int[] seq){
		int[] origArr = seq;
		int[] shiftedArrL1 = new int[seq.length];
		int[] shiftedArrL2 = new int[seq.length];
		int[] shiftedArrR = new int[seq.length];
		
		// LEFT SHIFT 1st VERSION
		for (int i = 0, j = 1; i < origArr.length-1; i++, j++) {
		
			shiftedArrL1[i] = origArr[j];
				
			if(j == origArr.length-1){
				shiftedArrL1[origArr.length-1] = origArr[0];
			}
		}
		System.out.print("LEFT SHIFT:	");
		System.out.println(java.util.Arrays.toString(shiftedArrL1));
		
		// LEFT SHIFT 2nd VERSION
		/**			
		 * left shift 
		 * origArr [0] [1] [2] [3] j
		 * copyArr [1] [2] [3] [0] i
		 */
		for (int i = origArr.length-1, j = i-1; i >= 0; i--, j--) {
			shiftedArrL2[j] = origArr[i];
			
			if(i == 1){
				j = origArr.length-1;
				i = 0;
				shiftedArrL2[j] = origArr[i];
			}
		}
		//System.out.print("LEFT SHIFT 2:	");
		//System.out.println(java.util.Arrays.toString(shiftedArrL2));
		
		// RIGHT SHIFT
		/**	
		 * right shift 
		 * origArr 	[0] [1] [2] [3] i 
		 * copyArr 	[3] [0] [1] [2] j 
		 */	
		// AS PER THE ORIGINAL ASSIGNMENT
		for (int i = 0, j = i+1; j < origArr.length; i++, j++) {					
			shiftedArrR[j] = origArr[i];
		}
		shiftedArrR[0] = origArr[origArr.length-1];	
		
		System.out.print("RIGHT SHIFT:	");
		System.out.println(java.util.Arrays.toString(shiftedArrR));
		
		return shiftedArrR;
	}
	
	
	/**
	 * Shifts the sequence n times to the right.
	 *
	 * right shift 
	 * origArr 	[0] [1] [2] [3] i
	 * copyArr 	[3] [0] [1] [2] j 
	 * 
	 * if times = 2:
	 * copyArr 	[2] [3] [0] [1] j => 2 positions to the right
	 *
	 * @param seq
	 * @param times
	 */
	public static void rotate(int[] seq, int times){
		System.out.println(java.util.Arrays.toString(seq));
		
		for (int i = 1; i <= times; i++) {
			seq = rotate(seq);
		}
		
		/**	

		 */	
		

	}
	
	
	// ------------ MAIN METHOD ----------------
		public static void main(String[] args) {
		System.out.print("You entered array: "); 
		println(new int[]{1,54,2});
		
		System.out.println("---------------");
		
		int[] sequence = {14, 15, 16, 17, 18};
		System.out.print("Reversed order: "); 
		swap(sequence);
		
		System.out.println("---------------");
		
		int[] sequence2 = {1,62,42,53,4,1,96,5};
		System.out.print("Copy of your array: ");
		// IF WITHOUT java.util.Arrays.toString we get [I@15db9742
		System.out.println(java.util.Arrays.toString(copy(sequence2)));
		
		System.out.println("---------------");
		
		rotate(new int[]{30,31,32,33}); 
		System.out.print("Original array:	");
		rotate(new int[]{1,2,3,4,5,6}, 3); 
	} 

}



/*
 	******* OUTPUT *******
	* You entered array: 1 54 2 
	* ---------------
	* Reversed order: 18 17 16 15 14 
	* ---------------
	* Copy of your array: [1, 62, 42, 53, 4, 1, 96, 5]
	* ---------------
	* LEFT SHIFT:	[31, 32, 33, 30]
	* RIGHT SHIFT:	[33, 30, 31, 32]
	* Original array:	[1, 2, 3, 4, 5, 6]
	* LEFT SHIFT:	[2, 3, 4, 5, 6, 1]
	* RIGHT SHIFT:	[6, 1, 2, 3, 4, 5]
	* LEFT SHIFT:	[1, 2, 3, 4, 5, 6]
	* RIGHT SHIFT:	[5, 6, 1, 2, 3, 4]
	* LEFT SHIFT:	[6, 1, 2, 3, 4, 5]
	* RIGHT SHIFT:	[4, 5, 6, 1, 2, 3]
*/
