class CountingVowels {
  /**
   * @param s character string
   * @returns the number of vowels in the given character string.
   */

	public static int countVowels(String s) {
		String thisString = s;
		char vowA = 'a';
		char vowE = 'e';
		char vowI = 'i';
		char vowO = 'o';
		char vowU = 'u';
		int vowCount = 0;
		
		for (int letterNum = 0; letterNum < thisString.length(); letterNum++) {
			if(thisString.charAt(letterNum) == vowA || 
					thisString.charAt(letterNum) == vowE ||
					thisString.charAt(letterNum) == vowI || 
					thisString.charAt(letterNum) == vowO ||
					thisString.charAt(letterNum) == vowU) {
				vowCount++;
			}
		}
		return vowCount;
	}
}
