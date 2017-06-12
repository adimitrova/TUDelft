import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Assignment2_2 {

	public static int max(int[] seq){
		int length = seq.length;
		// MIN_VALUE needed because also negative values could be provided
		int max = Integer.MIN_VALUE;

		/**
		 * Each array element is tested against the max variable.
		 * If it is bigger than what max currently holds
		 * max gets the value of the current array element. 
		 * the loop runs until the elements of the array are all passed
		 * and returns max
		 */
		for (int i = 0; i < length; i++) {
			if(seq[i] > max){
				max  = seq[i];
			}
		}
		System.out.println("Max value element: " + max);
		return max;
	}
	
	/**
	 * Method to return the index in the array that holds value
	 * that is equal to the given one
	 * 
	 * @param seq
	 * @param element 
	 * @return index of element
	 */
	public static int index(int[] seq, int element){
		int index = 0;
		
		// Find element
		for (int i = 0; i < seq.length; i++) {
			if(seq[i] == element){
				index = i;
				break;
			}
			else{
				index = -1;
			}
		}
		
		// Result display
		if(index == (-1)){
			System.out.println("There is no element equal to the given one in this array.");
		} else{
			System.out.println("Element with value \'" + element + "\' was found in the array at index: [" + index + "]" );
		}		
		
		return index;
	}
	
	/**
	 * Return if an element exists in the array or not
	 * 
	 * @param seq
	 * @param element
	 * @return TRUE if element exists or FALSE if not
	 */
	public static boolean contains(int[] seq, int element){
		boolean exists = false;
		
		for (int i = 0; i < seq.length; i++) {
			if(seq[i] == element){
				exists = true;
				break;
			} else {
				exists = false;
			}
		}
		
		// Result display
		if(exists == true){
			System.out.println("Element " + element + " exists in the array.");
		} else{
			System.out.println("Element " + element + " does not exist in the array.");
		}
		
		return exists;
	}
	
	/** 
	 * Method to return if a number is prime or not
	 * 
	 * @param element
	 * @return true or false
	 */
	
	public static boolean isPrime(int element){
		if(element > 1){
			int divisor = 2;
			// loop runs until it returns a remainder equal to zero (meaning number is not prime), then exists and assigns the divisor value to the element
			// this way it divides the element to everything up until that number
			while(element % divisor != 0){
				//for DEBUG: int remainder = element % divisor;
				divisor++;
			}
			return divisor == element;
		} else if(element < 0) {
			throw new IllegalArgumentException("Negative numbers cannot be tested.");
		}
		return false;
	}
	
	// previous attempt
	public static boolean isPrime2(int element){
		int byTwo = element % 2;
		int byThree = element % 3;
		int byFive = element % 5;
		int byEleven = element % 11;
		boolean prime = false;

		if(byTwo == 0 || byThree == 0 || byFive == 0 || byEleven == 0){
			prime = false;
			System.out.println(element + " is NOT prime.");
		} else{
			prime = true;
			System.out.println(element + " is prime.");
		}
		
		return prime;
	}
	
	
	/**
	 * 
	 * 
	 * @param from
	 * @param to
	 */
	public static void allPrimes(int from, int to){
		System.out.println("All prime numbers in range " + from + " - " + to + " are: ");
		
		for (int curr = from; curr <= to; curr++) {
			if(isPrime(curr) == true){
				System.out.print(curr + ", ");
			}
		}
	}
	

	public static int countPrimes(int[] seq){
		// Post: Returns the number of primes in seq.
		int counter = 0;
		
		for (int element = 0; element < seq.length; element++) {
			if(isPrime(seq[element]) == true){
				System.out.println("Prime number: " + seq[element]);
				counter++;
			}
		}
		System.out.println("Prime numbers found: " + counter);
		return counter;	
	}
	
	/**
	 * Return array of only prime numbers
	 * 
	 * @param seq
	 * @returns new array of primes
	 */
	
	public static int[] primesIn(int[] seq){
		System.out.println("Your array: " + java.util.Arrays.toString(seq));
		int[] temp = new int[seq.length];
		int elCounter = 0;
		/**
		 * Plan:
		 * for each given arr element check if prime  
		 * if prime look over the primes array and find the first 0 element and replace it with the value of the prime number
		 * once given arr is over check number of non-0 element of the temp Array and create a new one with that
		 * fill the element of the PrimesArray from the temp array
		*/ 
		for (int el = 0; el < seq.length; el++) {
			if(isPrime(seq[el]) == true){
				for (int tempEl = 0; tempEl < temp.length; tempEl++) {
					if(temp[tempEl] == 0){
						temp[tempEl] = seq[el];
						break;
					}
				}
			}
		}
		
		// count non-0 elements and add value to the counter
		for (int tempElCnt = 0; tempElCnt < temp.length; tempElCnt++) {
			if(temp[tempElCnt] != 0){
				elCounter++;
			}
		}
		
		//create Primes array with lenght = counter value
		int[] primesArr = new int[elCounter];
		
		// go over the temp array again and assign all non-0 elements to the primesArr
		for (int tempEl = 0; tempEl < temp.length; tempEl++) {
			for (int primesEl = 0; primesEl < primesArr.length; primesEl++) {
				if(primesArr[primesEl] == 0){
					primesArr[primesEl] = temp[tempEl];
					break;
				}
			}
		}
		System.out.println("Primes only array: " + java.util.Arrays.toString(primesArr));
		return primesArr;
	}
	
	
	/**
	 * Returns an array with all primes up to, but excluding, n.
	 * 
	 * @param to
	 * @return a LIST of type Integer with primes 
	 */
	
	public static List<Integer> primesUpTo(int to){
		/**
		 * Because I would have to copy half of the primesIn() method I decided to look for a way to update dynamically the array
		 * so I won't need to iterate over it again as above. Comes out that the arrays' length cannot be altered and 
		 * new elements cannot be added to the end of it. So I used Lists. Had to modify the method to return a list too. 
		 */
		List<Integer> primesTo = new ArrayList<Integer>();
		
		for (int i = 0; i < to; i++) {
			if(isPrime(i) == true){
				primesTo.add(i);
			}
		}
		System.out.println("Primes up to " + to + ": " + primesTo);
		return primesTo;
	} 
	
	
	// ---------------------- MAIN METHOD ---------------------------
	public static void main(String[] args) {
		int[] array = new int[]{-6,-12,64,-24,23,6,1,17,-234};
		int[] array2 = new int[]{3,52,71,526,17,21,22,23,19,25,26,32};
		int element = 119;
		max(array);
		index(array, 745);
		contains(array,24);
		
		System.out.println("Prime: " + isPrime(18));		
		
		System.out.println("-------------------");
		countPrimes(array2);
		System.out.println("-------------------");
		allPrimes(5, 52);
		System.out.println();
		System.out.println("-------------------");
		primesIn(array2);
		System.out.println("-------------------");
		primesUpTo(47);
	}

}



/*

OUTPUT:

Max value element: 64
There is no element equal to the given one in this array.
Element 24 does not exist in the array.
Prime: false
-------------------
Prime number: 3
Prime number: 71
Prime number: 17
Prime number: 23
Prime number: 19
Prime numbers found: 5
-------------------
All prime numbers in range 5 - 52 are: 
5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 
-------------------
Your array: [3, 52, 71, 526, 17, 21, 22, 23, 19, 25, 26, 32]
Primes only array: [3, 71, 17, 23, 19]
-------------------
Primes up to 47: [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43]

*/