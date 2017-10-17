class ArrayStack {
  private Object[] elements;
  private int size;
  private int capacity;

  // post: Empty StackArray with capacity 1  
  public ArrayStack() {
  
  }
  
  public int size() {
    return 0;
  }
  
  public boolean isEmpty() {
    return true;
  }
  
  // post: returns true iff capacity is fully used
  public boolean isFull() {
    return false;
  }
  
  public Object peek() throws EmptyStackException {
    return null;
  }
  /**
   * pre: the stack is not full
   * post: o added to the stack. If capacity of stack was 
   * too small, capacity is doubled and o is added.
   */
  public void push (Object o) {

  }
  
  /**
   * @return the element which was at the top of the stack,
   * If removing top would make the stack use less than 25% of its capacity,
   * then the capacity is halved.
   * @throws EmptyStackException iff the queue is empty
   */
  public Object pop() throws EmptyStackException {
    return null;
  }
  
  /**
   * post: returns a String representation of the ArrayStack
   * Example output for ArrayStack with 2 elements and capacity 5:
   * <ArrayStack[1,2]>(Size=2, Cap=5)
   */
  public String toString() {
    return null;
  }
  
  //For testing, do not remove or change.
  public Object[] getElements() {
    return elements;
  }
}
