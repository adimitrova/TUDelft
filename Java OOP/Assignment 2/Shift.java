public class Shift {

	public static int[] rotate(int[] seq){
	    int[] origArr = seq;
	    int[] shiftedArrR = new int[seq.length];
	
	    for (int i = 0, j = i+1; j < origArr.length; i++, j++) {
	        shiftedArrR[j] = origArr[i];
	    }
	    shiftedArrR[0] = origArr[origArr.length-1]; 
	
	    System.out.print("RIGHT SHIFT:	  ");
	    System.out.println(java.util.Arrays.toString(shiftedArrR));
	    return shiftedArrR;
	}
	
	public static void rotate(int[] seq, int times){
	
	    System.out.println(java.util.Arrays.toString(seq));
	    	
	    for (int i = 1; i <= times; i++) {
	    	seq = rotate(seq);
	    }
	}
	
	
	// ------------ MAIN METHOD ----------------
	public static void main(String[] args) {
	
	    System.out.print("Original array:   ");
	    rotate(new int[]{1,2,3,4,5,6}, 3);
	    }

}