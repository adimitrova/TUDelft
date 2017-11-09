/**
 * Customized Linked List Node
 * NOTE: Assuming the pointers are only integer values
 * @author ani
 * @version 9.11.17
 */

public class LLNode {
	public static int firstNodeNextPointer = 2;	// head's pointer points to the second element
	private int objCount = 0;	// object counter
	private Object elValue;				// Node object value
	private int NEXTpointer;			// Node pointer
	private int OWNPointer;				// Node's own pointer
	public static int terminator = -1;	// if pointer points to it, then it's the last node in the list. In wikipedia = NULL
													
	//constructor
	public LLNode(Object elIn) {
		elValue = elIn;
		objCount++;
		OWNPointer = objCount;	// current Node's own pointer is equal to the object count
		NEXTpointer = terminator;					// current Node's NEXTpointer is equal initially to terminator, 
													//i.e. it's initially tail
	}
	
	// set current node's NEXTPointer to the next element, i.e. if this is element 3, it's NEXTPointer = 4
	public void setPointerNext() {
		NEXTpointer = objCount+1;
	}
	
	// set current node to Tail
	public void setTail() {
		this.NEXTpointer = terminator;
	}
	
	// getter for NEXTpointer value
	public int getNEXTPointerValue() {
		return this.NEXTpointer;
	}
	
	// getter for OWNpointer value
		public int getOWNPointerValue() {
			return this.OWNPointer;
		}
	
	// getter for actual node value
		public Object getNodeValue() {
			return this.elValue;
		}
	
	// if tail, no next element
	public boolean isTail() {
		boolean isTail = false;
		if(this.NEXTpointer == terminator) {
			isTail = true;
		}
		return isTail;
	}
	
	// if head, pointer == 1
	public boolean isHead() {
		boolean isHead = false;
		if(this.NEXTpointer == firstNodeNextPointer) {
			isHead = true;
		}
		return isHead;
	}
	
	// pretty print of the Node value (object's value)
	public String toString() {
		String start = "Node(";
		String NodeParts = "Value: " + this.getNodeValue() 
						 + "; OwnPointer: " + this.getOWNPointerValue() 
						 + "; NextPointer: " + this.getNEXTPointerValue();
		
		return start + NodeParts + ")";
	}
	
}
