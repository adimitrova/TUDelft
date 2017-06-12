import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class StringList {
	
	// class fields
	private String[] elements;
	private int amount;
	

	/**
	 * constructor
	 * @param n is the initial size of the list
	 */
	public StringList(int n){
		// initializing fields in the constructor
		amount = 0;
		if(n < 0){
			elements = new String[0];
		} else {
			elements = new String[n];
		}		
	}
	
	/**
	 * add new element to the list
	 * @throws IllegalArgumentException if the list if already full 
	 * @param el is the STRING element to add
	 * 
	 * PROMLEM WITH THIS METHOD, check it out! Always returns the list is full, maybe that's why
	 * it doesn't add any elements to the list.
	 */

	public void add(String el){
		if(amount < elements.length){
			elements[amount] = el;
			amount++;
		} else if(amount >= elements.length){
			throw new IllegalArgumentException("No more space in the list, it's full.");
		}	
	}
	
	// get the element at position i
	public String get(int i){
		if(0 <= i && i < amount){
			return elements[i];
		} 
		return null;
	}
	
	public void set(int i, String el){
		if(i < 0){
			throw new IllegalArgumentException("Sorry, you entered a negative index.");
		}
		else if(0 <= i && i < amount){
			elements[i] = el;
		} 
		else if (i > amount){
			throw new IllegalArgumentException("No more space available in the array.");
		}
	}
	
	public int index(String el){
		for (int position = 0; position < elements.length; position++) {
			if (elements[position] == el) {
				//If found, return index i
				return position;
			} 
		}
		//If not found, return index -1
		return -1;
	}

	public boolean contains(String el){
		if(index(el) != -1){
			// if we call the index() method and it DOES NOT return -1 
			// (cannot check for the other value), we returns true, i.e. value exists
			return true;
		}
		// else does not exist
		return false;
	}
	
	public int getSize(){
		// returns number (amount) of actual values and not size of the list
		return amount;
	}	
	
	public boolean equals(Object other){
		boolean equal = false;
		
		if(!(other instanceof StringList)){
			equal = false;
		} 
		else {
			StringList secondList = (StringList)other;
			if(this.amount == secondList.amount && Arrays.equals(this.elements, secondList.elements)){
						equal = true;
			}
		}
		return equal;
	}
	
	public String toString(){
		String beginning = new String();
		String result = new String();
		String temp = new String();
		beginning = "<StringList[";
		
		for (int position = 0; position < elements.length; position++) {
			temp = elements[position] + ",";
			result = result + temp; 
		}
		
		if (result.endsWith(",")) {
			result = result.substring(0, result.length()-1);
		}
		return beginning + result + "]>";
	}

}
