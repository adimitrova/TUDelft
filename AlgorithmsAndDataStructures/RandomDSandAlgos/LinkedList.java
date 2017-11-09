import java.util.ArrayList;
import java.util.List;

/**
 * Customized Linked List that uses the LLNode class
 * @author ani
 * @version 09.11.2017
 */

public class LinkedList {
	static List<LLNode> myLinkedList;
	
	public LinkedList() {
		myLinkedList = new ArrayList<LLNode>();
	}
	
	// adds node at the end
	public void addNode(LLNode nodeIn) {
		if(!(myLinkedList.isEmpty())) {
			updatePrevNode();	// update previous element by changing it's NEXTPointer to NOT be tail, i.e. something other than -1
		} 
		nodeIn.setTail();	// set new element to be TAIL
		myLinkedList.add(nodeIn);	// add that element to the LinkedList 
	}
	
	public static void updatePrevNode() {
		// get previous node's index in the ArrayList and assign it the element to tempNode
		LLNode tempNode = myLinkedList.get(myLinkedList.size()-1);	
		tempNode.setPointerNext();	// set the NEXTPointer of this element to +1, so it's no longer TAIL
	}
	
	public String toString() {
		String start = "LinkedList<\n";
		String nodes = "";
		
		for (LLNode currNode : myLinkedList) {
			nodes += currNode + "\n";
		}
		
		return start + nodes + ">";		
	}
}
