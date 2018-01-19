class CloneArrays {
  
  static float[][] clone(float[][] arr1) {
    
    float[][] arr1copy = null;
    
    for (int i = 0; i < arr1.length; i++) {
    	arr1copy[i] = arr1[i];
	}
    
    return arr1copy;
  }
}