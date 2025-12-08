import java.util.NoSuchElementException;
/**
 * MyStack class that implements the StackADT interface
 */
public class MyStack<T> implements StackADT<T> {
	// Fields
	private T[] data;
	private int topIndex;
	/**
	 * default myStack constructor that takes a generic data type array and topIndex
	 */
	public MyStack(){
		this.data = (T[]) new Object[10];
		this.topIndex = -1;
	}
	
	/**
     * Pushes an item to top of stack.
     * @param item the element to push 
     * @throws IllegalArgumentException if item is null 
     * @throws IllegalStateException if stack has reached max capacity
     */
	@Override
	public void push(T item) {
		// Check if item is null
		if(item == null) {
			throw new IllegalArgumentException("Item is null, cannot be added.");
		}
		// Check if stack is full
		if(size() >= data.length) {
			throw new IllegalStateException("Stack has reached max capacity. Item cannot be added.");
		}
		// If everything passes, add item to stack
		data[++topIndex] = item;
	}
	
	/**
     * Removes and returns the item at the top of the stack
     * @return the removed element
     * @throws NoSuchElementException if the stack is empty
     */
	@Override
	public T pop() {
		// Check if stack is empty
		if(isEmpty()) {
			throw new NoSuchElementException("Stack is empty");
		}
		else {
		T top = data[topIndex];
		data[topIndex] = null;
		topIndex--;
		return top;
		}
	}
	/**
     * Returns the top item of the stack without removing.
     * @return the top element
     * @throws NoSuchElementException if the stack is empty
     */
	@Override
    public T peek() {
    	// Check if stack is empty
    	if(isEmpty()) {
			throw new NoSuchElementException("Stack is empty");
		}
    	return data[topIndex];
    }
    /**
     * Checks whether the stack is empty.
     * @return true if the stack has no elements, false otherwise
     */
	@Override
    public boolean isEmpty() {
    	if(topIndex < 0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    /**
     * Returns the current number of elements in the stack.
     * @return number of elements
     */
	@Override
    public int size() {
    	return topIndex+1;
    }
    /**
     * Returns an array containing all elements in the stack.
     * @return array the new array containing all elemnts
     */
	@Override
    public Object[] toArray() {
		// Create an array that houses all the elements
		Object[] array = new Object[size()];
		// Run for loop 
		for(int index = 0; index < size(); index++) {
			array[index] = data[index];
		}
		return array;
    }
	
}
