import java.util.NoSuchElementException;


class Queue<T> {
  private Stack<T> s1 = new LibraryStack<>();
  private Stack<T> s2 = new LibraryStack<>();

  /**
   * @return true iff there are no elements left.
   */
  public boolean isEmpty() {
    return true;
  }

  /**
   * @return the number of elements in the queue.
   */
  public int size() {
    return 0;
  }

  /**
   * Adds an element to the queue.
   *
   * @param i
   *            element to enqueue.
   */
  public void enqueue(T i) {

  }

  /**
   * Removes the first element from the queue.
   *
   * @return the first element from the queue.
   * @throws NoSuchElementException
   *             iff the queue is empty.
   */
  public T dequeue() throws NoSuchElementException {
    return null
  }

  /**
   * Only returns (i.e. does not remove) the first element from the queue.
   *
   * @return the first element from the queue.
   * @throws NoSuchElementException
   *             iff the queue is empty.
   */
  public T first() throws NoSuchElementException {
    return null;
  }

}


/**
 * Interface for a Stack.
 * 
 * DO NOT MODIFY
 *
 * @param <T> Type of elements the Stack can hold
 */
interface Stack<T> {

  /**
   * @return true iff it contains no elements.
   */
  public boolean isEmpty();

  /**
   * @return the number of elements in the stack.
   */
  public int size();

  /**
   * Add an element to the top of the stack
   *
   * @param e
   *            element to push.
   */
  public void push(T e);

  /**
   * Removes the top element from the stack.
   *
   * @return the first element.
   * @throws NoSuchElementException
   *             iff the stack is empty
   */
  public T pop() throws NoSuchElementException;

  /**
   * @return the top element (does not pop it).
   * @throws NoSuchElementException
   *             iff the stack is empty
   */
  public T peek() throws NoSuchElementException;

}