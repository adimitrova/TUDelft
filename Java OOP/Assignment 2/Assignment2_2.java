import java.util.Arrays;

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
	 * @return
	 */
	public static boolean isPrime(int element){
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
		int[] primes = new int[to];
		int primesIndex = 0;
		
		for (int i = from; i < to; i++) {
			boolean isPrime = true;
			
			/*
			 * Sled kato mine celiq for i ne match-ne zna4i e prime
			 * TODO: Fix & COMPLETE
			 */
			for (int j = 0; j < primes.length; j++) {
				if(i == 1 || i == 2 ){
					primes[primesIndex] = i;
					primesIndex++;
					break;
				} else {
					if(primes[j] != 1 ){
						if(i % 2 == 0){
							isPrime = false;
							break;
						} else if(primes[j] == 0){
							break;
						} else if(i % primes[j] == 0){
							isPrime = false;
							break;
						}
					} else {
						continue;
					}	
				} 
			}
			
			if(isPrime == true){
				primes[primesIndex] = i;
				primesIndex++;
			}			
		}
		System.out.println(java.util.Arrays.toString(primes));
	}
	
	//TODO: implement
	public static int countPrimes(int[] seq){
		// Post: Returns the number of primes in seq.
	}
	
	//TODO: implement
	public static int[] primesIn(int[] seq){
		// Post: Returns a new array with all primes in seq.
	} 
	
	//TODO: implement
	public static int[] primesUpTo(int n){
		// Post: Returns an array with all primes up to, but excluding, n.
	}
	
	
	// ---------------------- MAIN METHOD ---------------------------
	public static void main(String[] args) {
		//int[] array = new int[]{-6,-12,64,-24,23,6,1,745,-234};
		//int element = 119;
		//max(array);
		//index(array, 745);
		//contains(array,24);
		//isPrime(element);		
		
		allPrimes(1,15);
	}

}
