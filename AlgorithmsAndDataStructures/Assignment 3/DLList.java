	// --------------------------------------- DLL LIST CLASS ---------------------------------------------------//
public class DLList {
	//TODO: FIX
	  
	    // Each object in DLList has one variable head, which points to the starting Node of DLList.
	private Node head;
	private Node tail;
	
	// Implements an empty constructor which initializes the head variable as null
	DLList()
	{
	  head = null;
	  tail = null;
	}
	
	// Returns the head node of the DLL
	public Node getHead()
	{
	  return head;
	}
	
	// Returns the tail node of the DLL
	public Node getTail()
	{
		return tail;
	}
	
	// Following methods are the ones you are expected to implement
	
	// Adds node n to the head of the list.
	public void addFirst(Node node)
	{
		/**
		 * get the head node
		 * assign it to a temp node
		 * replace head with n
		 * n.next points temp
		 * n.prev is null
		 * temp.prev points to n
		 * temp.next points stays the same?  
		 */
		DLList list = new DLList();
    	Node getHead = list.getHead();
		
		if(getHead != null) {
			System.out.println("Current head<" + getHead().getElement() 
					+ "; prev: " + getHead().getPrevious() 
					+ "; next: " + getHead().getNext() + ">");
			
			// get the curr head
			Node tempNode = new Node(getHead().getElement(), getHead().getPrevious(), getHead().getNext()); // current head
			
			// update the new head
			this.head.setElement(node.getElement());
			this.head.setPrevious(null);
			this.head.setNext(tempNode);  	
			System.out.println("Empty list New head<" + getHead().getElement() 
			+ "; prev: " + getHead().getPrevious() 
			+ "; next: " + getHead().getNext() + ">");
		} else {
			head = node;
			System.out.println("Non-Empty list New head<" + getHead().getElement() 
											+ "; prev: " + getHead().getPrevious() 
											+ "; next: " + getHead().getNext() + ">");
		}
	}
	
	//Removes and returns the first node in the list. If the list is empty, returns null.
	public Node removeFirst()
	{
		/**
		 * get current head
		 * get curr.head's next el
		 * make head = curr.head's next
		 */
		Node currHead = head; // current head - for readability
		Node currHeadNext = new Node(currHead.getNext().getElement(), currHead.getNext().getNext(), currHead);
		head = currHeadNext;
		head.setPrevious(null);
		
		return head;
	}
	
	// Adds node n to the end of the list
    public void addLast(Node n)
    {
    	System.out.println("Current tail<" + getTail().getElement() 
		+ "; prev: " + getTail().getPrevious() 
		+ "; next: " + getTail().getNext() + ">");
		// get the curr head
		Node tempNode = new Node(getTail().getElement(), getTail().getPrevious(), getTail().getNext()); // current head
		// update the new head
		tail.setElement(n.getElement());
		tail.setPrevious(tempNode);
		tail.setNext(null);  	
		System.out.println("New head<" + getTail().getElement() 
		+ "; prev: " + getTail().getPrevious() 
		+ "; next: " + getTail().getNext() + ">");   	
    }
      
	    //Removes and returns the last node in the list.If the list is empty, returns null.
	public Node removeLast() {
		/**
		 * get current tail
		 * get curr.head's prev el
		 * make tail = curr.tail's prev node
		 */
		Node currTail = head; // current tail - for readability
		Node currTailPrev = new Node(currTail.getPrevious().getElement(), currTail, currTail.getPrevious().getPrevious());
		tail = currTailPrev;
		tail.setNext(null);
		
		return tail;
	}
	
	// Returns the number of nodes in the list
	public int size()
	{
		int size = 0;
    	Node tempNode = getHead();
    	while(tempNode.getPrevious() != null) {
    		size++;
    		size();
    	}
    	return size;
	}
	  
	    // Adds node n after the node in position pos. The list is zero indexed, so the first element in the list correspond
	// to position 0. If there is no node in position pos, this method adds it to the last position.
    public void addAtPosition(Node node, int pos)
    {
    	Node prevNode;
    	Node nextNode;
    	Node currNode = node;
    	int currPos = pos;
    	
    	for (int i = 0; i <= size(); i++) {
			if(i == pos) {
				prevNode = new Node(currNode.getPrevious().getElement(), currNode.getPrevious().getNext(), currNode.getPrevious().getPrevious());
				nextNode = new Node(currNode.getNext().getElement(), currNode.getNext().getNext(), currNode.getNext().getPrevious());
				prevNode.setNext(currNode);
				nextNode.setPrevious(currNode);
			}
			else {
				addAtPosition(currNode,currPos);
			}
		}
    }
	    
	    // Remove and return node n at position pos. The list is zero indexed, so the first element in the list correspond
	// to position 0. If there is no node in position pos, this method returns null.
	public Node removeFromPosition(int pos)
	{
		//TODO: implement
		return null;
	}
	
	// Returns  a new DLL that contains the elements of the current one in reversed order
	public DLList reverse()
	{
		//TODO: implement
		    	return null;
	}
	
	public String toString() {
		int size = 0;
    	Node tempNode = head;
    	String tempNodeStr = "";
    	while(tempNode.getPrevious() != null) {
    		size++;
    		tempNodeStr = tempNode.toString();
    	}
    	return "DLL<" + tempNodeStr + ">";
	}
}