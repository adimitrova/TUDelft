import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NestedArrayLists {
	
	public static void main(String[] args) {
		NestedArrayLists myList = new NestedArrayLists();
		int counter = 0;
		
		Integer[] list1 = {1,3,5,3};
		counter++;
		Integer[] list2 = {1,7};
		counter++;
		Integer[] list3 = {2,56,35,24};
		counter++;
		
		myList.addToList(list1);
		myList.addToList(list2);
		myList.addToList(list3);
		
		System.out.println(myList.getList().isEmpty());
		for (ArrayList<Integer> list : myList.getList()) {
			if(list.get(0) == 1) {
				System.out.println(list);
			}
		}
	}
	
	// class fields
	private List<ArrayList<Integer>> listObj;
	
	// constructor to initialize empty list
	public NestedArrayLists() {
		listObj = new ArrayList<ArrayList<Integer>>();
	}
	
	// add to the list
	public void addToList(Integer[] valuesIn) {
		ArrayList<Integer> innerList = new ArrayList<Integer>();
		innerList.addAll(Arrays.asList(valuesIn));
		listObj.add(innerList);
	}
	
	// get the current list
	public List<ArrayList<Integer>> getList(){
		return listObj;
	}
}
