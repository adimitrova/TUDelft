class remLastOccInArr {
	
	public static void main(String[] args) {
		int[] input = {1,20,33,45,52,61,79,83,91,105};
		System.out.println(remLastOccInArr.toString(removeLastOccurence(1, input)));
	}
	
	/**
	 * Takes the array and the last occuring element x,
	 * shifting the rest of the elements left. I.e.
	 * [1, 4, 7, 9], with x=7 would result in:
	 * [1,4,9].
	 * @param array to remove an entry from
	 * @return the shorter array
	 */
	public static int[] removeLastOccurence(int x, int[] array) {
		int[] tempArr = new int[array.length-1];
		int lookFor = x;
		int xAtIndex = -1;
		
		while(xAtIndex == -1) {
			for (int index = array.length-1; index >= 0 ; index--) {
				if(array[index] == lookFor) {
					xAtIndex = index;
					break;
				}
			}
		}
		
		for (int j = 0; j < array.length-1; j++) {
			if(j < xAtIndex) {
				tempArr[j] = array[j];
			} else if (j > xAtIndex) {
				tempArr[j] = array[j-1];
			}
		}
		
		return tempArr;
	}
	
	public static String toString(int[] arrayIn) {
		String start = "[";
		String mid = "";
		
		for (int i = 0; i < arrayIn.length-1; i++) {
			mid += arrayIn[i] + ", ";
		}
		String end = "]";
		
		return start + mid + end;
	}
	
}