/**
 * Doubly Linked Lists implementation with skeleton code from the course
 * @author ani
 * @version 1 Dec 17
 */
class SolutionDLL {
 	  public static class Node {
	    // Each node object has these three variables
	    private Object element;
	    private Node   next;
	    private Node   previous;
	    
	    // Constructor: Creates a Node object with element = e, next = n and previous = p
	    Node(Object elementIn, Node nextNodeIn, Node prevNodeIn) 
	    {
	      element = elementIn;
	      next    = nextNodeIn;
	      previous = prevNodeIn;
	    }
	  
	    // This function gets Object e as input and sets e as the element of the Node 
	    public void setElement(Object elementIn) 
	    {
	      element = elementIn;
	    }
	    
	    // This function returns the element variable of the Node
	    public Object getElement()
	    {
	      return element;
	    }
	    
	    // This function gets Node n as input and sets the next variable of the current Node object as n.
	    public void setNext(Node nextNodeIn) 
	    {
	      next = nextNodeIn;
	    }
	    
	    // This function returns the next Node
	    public Node getNext()
	    {
	      return next;
	    }
	    
	    // This function gets Node n as input and sets the previous variable of the current Node object as p.
	    public void setPrevious(Node prevNodeIn) 
	    {
	      previous = prevNodeIn;
	    }
	    
	    // This function returns the previous Node
	    public Node getPrevious()
	    {
	      return previous;
	    }
	    
	  }
	  
	  public static class DLList {
	  
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
	    public void addFirst(Node n)
	    {
	    	SolutionDLL.Node tempNode = new SolutionDLL.Node(
	    			n.getElement(), 
	    			n.getNext(), 
	    			n.getPrevious()); 
	    	// do something
	    	
	    }
	    
	    //Removes and returns the first node in the list. If the list is empty, returns null.
	    public Node removeFirst()
	    {
	  
	    }
	    
	    // Adds node n to the end of the list
	    public void addLast(Node n)
	    {
	  
	    }
	      
	    //Removes and returns the last node in the list.If the list is empty, returns null.
	    public Node removeLast() {
	    
	    }
	    
	    // Returns the number of nodes in the list
	    public int size()
	    {
	  
	    }
	  
	    // Adds node n after the node in position pos. The list is zero indexed, so the first element in the list correspond
	    // to position 0. If there is no node in position pos, this method adds it to the last position.
	    public void addAtPosition(Node n, int pos)
	    {
	  
	    }
	    
	    // Remove and return node n at position pos. The list is zero indexed, so the first element in the list correspond
	    // to position 0. If there is no node in position pos, this method returns null.
	    public Node removeFromPosition(int pos)
	    {
	  
	    }
	    
	    // Returns  a new DLL that contains the elements of the current one in reversed order
	    public DLList reverse()
	    {
	  
	    }
	  }
}