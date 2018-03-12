import javafx.scene.SubScene;

/**
 * Given a string and a non-empty substring sub, compute recursively the number of times
 * that sub appears in the string, without the sub strings overlapping.
 * 
 * strCount("catcowcat", "cat") → 2
 * strCount("catcowcat", "cow") → 1
 * strCount("catcowcat", "dog") → 0
 * 
 * @URL (http://codingbat.com/prob/p186177)
 */
public class strCount {

	public static void main(String[] args) {
		strCount("catcowcat", "cat");
		
	}
	
	
	
	private static int strCount(String str, String sub) {
		String strMain = str;
		char[] strMainArr = new char[str.length()];
		String substr = sub;
		char[] substrArr = new char[substr.length()];
		int nrSub = 0;
		
		for (int i = 0; i < strMain.length(); i++) {
			strMainArr[i] = strMain.charAt(i);
		}
		
		for (int i = 0; i < substr.length(); i++) {
			substrArr[i] = substr.charAt(i);
		}
		
		
		
		return nrSub;
	}

}
