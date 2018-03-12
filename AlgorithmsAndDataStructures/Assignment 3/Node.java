/**
 * Doubly Linked Lists implementation with skeleton code from the course
 * @author ani
 * @version 1 Dec 17
 */
class Node {
	//TODO: FIX
	  // ----------------------------------------- NODE CLASS ---------------------------------------------------//
	   
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
	
	@Override
	public String toString() {
		return "<P:" + this.getPrevious() + ", E:" + this.getElement() + ", N:" + this.getNext() + ">";
	}
}