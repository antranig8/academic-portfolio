import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * MyPriorityQueue Class that implements PriorityQueueAFT Interface
 */
public class MyPriorityQueue<T> implements PriorityQueueADT<T>{
	// Fields
	private T[] line;
	private int size;
	private Comparator<T> cmp;
	final static int MAX_CAPACITY = 1000;
	
	/**
	 * pass a comparator into the constructor
	 * @param compare
	 */
	public MyPriorityQueue(Comparator<T> compare) {
		line = (T[]) new Object[10];
		size = 0;
		this.cmp = compare;
	}
		/**
	     * Adds an item into the queue in priority order
	     * @param item the element to insert
	     * @throws IllegalArgumentException if item is null
	     * @throws IllegalStateException if queue is full
	     */
		@Override
	    public void enqueue(T item) {
	    	// Run checks
	    	if(item == null) {
	    		throw new IllegalArgumentException("Item cannot be null.");
	    	}
	    	if(size == line.length) {
	    		throw new IllegalStateException("The PriorityQueue is full.");
	    	}
	    	// Add to queue
	    	line[size] = item;
	    	int index = size;
	    	// Move it into place by priority
	    	while(index > 0) {
	    		int other = (index - 1) / 2;
	    		// Check who has the higher priority
	    		if(cmp.compare(line[index], line[other]) < 0) {
	    			// Swap Places
	    			T temp = line[index];
	    			line[index] = line[other];
	    			line[other] = temp;
	    			index = other;
	    		}
	    		// Otherwise break
	    		else {
	    			break;
	    		}
	    	}
	    	// Increment size
	    	size++;
	    }

	    /**
	     * Removes and returns the highest-priority item.
	     * @return the dequeued element
	     * @throws NoSuchElementException if the queue is empty
	     */
	    @Override
	    public T dequeue(){
	    	if(size == 0) {
	    		throw new NoSuchElementException("The queue is empty.");
	    	}
	    	// Get first in line
	    	T first = line[0];
	    	// fill in empty space with the last element in the line
	    	line[0] = line[size - 1];
	    	line[size-1] = null;
	    	size--;
	    	// re-sort the queue
	    	int index = 0;
	    	while(true) {
	    		// set the parameters
	    		int left = 2*index+1;
	    		int right = 2*index+2;
	    		int smallest = index;
	    		// now run comparisons
	    		if(left < size && cmp.compare(line[left], line[smallest]) < 0) {
	    			smallest = left;
	    		}
	    		if(right < size && cmp.compare(line[right], line[smallest]) < 0) {
	    			smallest = right;
	    		}
	    		// run the swap
	    		if(smallest != index) {
	    			T temp = line[index];
	    			line[index] = line[smallest];
	    			line[smallest] = temp;
	    			index = smallest;
	    		}
	    		// otherwise break
	    		else {
	    			break;
	    		}
	    	}
	    	// return the removed element
	    	return first;
	    }

	    /**
	     * Returns the highest-priority item.
	     * @return the first element
	     * @throws NoSuchElementException if the queue is empty
	     */
	    @Override
	    public T peek() {
	    	// run check
	    	if(size == 0) {
	    		throw new NoSuchElementException("The queue is empty.");
	    	}
	    	// return first in line
	    	return line[0];
	    }

	    /**
	     * Checks whether the queue has no elements.
	     * @return true if empty, false otherwise
	     */
	    @Override
	    public boolean isEmpty() {
	    	return size == 0;
	    }

	    /**
	     * Returns the current number of elements in the queue.
	     * @return number of elements
	     */
	    @Override
	    public int size() {
	    	return size;
	    }
	    /**
	     * Returns an array containing all elements in this priority queue,
	     */
	    @Override
	    public Object[] toArray() {
		// Create an array that houses all the elements
		Object[] array = new Object[size()];
		// Run for loop 
		for(int index = 0; index < size(); index++) {
			array[index] = line[index];
			}
		return array;
	    }
}
