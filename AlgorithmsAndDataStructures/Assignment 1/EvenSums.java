class EvenSums {
	
	private int sum = 0;
	
  /**
   * @param n
   * @returns the sum of all the even positive integers less then or equal to n.
   */
  public static int sumEvenFor(int n) {
	  int lessThan = n;
	  int sum = 0;
	  
	  if(lessThan <= 0) {
		  sum = 0;
	  } else {
		  for (int num = 0; num <= lessThan ; num++) {
			  if(num % 2 == 0) {
				  sum += num;
			  }
		  }
	  }
	  return sum;
  }
  
  /**
   * @param n
   * @returns the sum of all the even positive integers less then or equal to n.
   */
  public static int sumEvenWhile(int n) {
	  int lessThan = n;
	  int sum = 0;
	  int currNum = 0;
	  
	  if(lessThan <= 0) {
		  sum = 0;
	  } else {
		  while(currNum <= lessThan) {
			  if(currNum % 2 == 0) {
				  sum += currNum;
			  }
			  currNum++;
		  }
	  }
	  return sum;
  }
  
  /**
   * @param n
   * @returns the sum of all the even positive integers less then or equal to n.
   */
  public int sumEvenRec(int n) {
	  int input = n;
	  
	  if(input <= 0) {
		  return 0;
	  } else {
		  if(input % 2 == 0) {
			  sum += input;
		  }
		  sumEvenRec(--input);
	  }
	  return sum;
  }
  
}
