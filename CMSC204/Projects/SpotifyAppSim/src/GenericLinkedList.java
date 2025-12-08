import java.util.NoSuchElementException;
import java.util.ListIterator;

/**
 * GenericLinkedList class that works with a head and tail reference
 * Also includes a GenericIterator inner Class
 * @param <T>
 */
public class GenericLinkedList<T> implements Iterable<T>{
	// fields referencing nodes and num of entries
	private Node head;
	private Node tail;
	private int numOfEntries;
	// Default no arg constructor
	public GenericLinkedList() {
		this.head = null;
		this.tail = null;
		this.numOfEntries = 0;
	}
	// Getters
	public T getFirst() {
		if(head == null) {
			throw new NoSuchElementException("The first element is null.");
		}
		return head.data;
	}
	public T getLast() {
		if(tail == null) {
			throw new NoSuchElementException("The last element is null.");
		}
		return tail.data;
	}
	// simple checker methods
	public boolean isEmpty() {
		return numOfEntries == 0;
	}
	public int size() {
		return numOfEntries;
	}
	public void clear() {
		head = null;
		tail = null;
		numOfEntries = 0;
	}
	/**
	 * addFirst method that adds the element at the head of the list
	 * @param element The element being added
	 */
	public void addFirst(T element) {
		Node newNode = new Node(element);
		// if the list is empty set the element to both head and tail
		if(isEmpty()) {
			head = newNode;
			tail = newNode;
		}
		else {
			// if the list had a head already
			// set the current head as the current newNode next
			newNode.next = head;
			// link the old heads previous address to the newNode
			head.prev = newNode;
			// Set the newNode as the head
			head = newNode;
		}
		// increment the numOfEntries
		numOfEntries++;
	}
	/**
	 * addLast method that adds the element at the back of the list
	 * @param element The element being added
	 */
	public void addLast(T element) {
		Node newNode = new Node(element);
		// if the list is empty set the element to both head and tail
		if(isEmpty()) {
			head = newNode;
			tail = newNode;
		}
		else {
			// link the old heads previous address to the newNode
			tail.next = newNode;
			// set the current tail as the current newNode next
			newNode.prev = tail;
			// Set the newNode as the head
			tail = newNode;
		}
		// increment the numOfEntries
		numOfEntries++;
	}
	/**
	 *  Checks if the element is in the list
	 *  @param element The element entered
	 */
	public boolean contains(T element) {
		//get the first node
		Node current = head;
		// traverse every node until null
		while(current != null) {
			if(element.equals(current.data)) {
				return true;
			}
			// set current to the next node
			current = current.next;
		}
		return false;
	}
	/**
	 * get method that returns an element at a specified position in the list
	 * @param index
	 */
	public T get(int index) {
		// Check for out of bounds exception
		if(index < 0 || index >= numOfEntries) {
			throw new IndexOutOfBoundsException("Input is less than 0, or greater than amount of elements in the List");
		}
		// Set current to the head
		Node current = head;
		// traverse the list until the index is reached
		for(int i = 0; i < index; i++) {
			current = current.next;
		}
		// return the element at the index
		return current.data;
	}
	/**
	 * removeFirst method that removes the head
	 * and returns the element inside
	 * @return data The element inside the previous head
	 */
	public T removeFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException("Cannot remove from an empty list.");
		}
		// set the current heads data to temp data
		T data = head.data;
		// move head to the next node
		head = head.next;
		// if the head was the only element set the list as empty
		if(head == null) {
			tail = null;
		}
		else {
			// otherwise remove the previous head
			head.prev = null;
		}
		// de-increment entries
		numOfEntries--;
		// return the previous heads data
		return data;
	}
	/**
	 * removeLast method that removes the tail
	 * and returns the element inside
	 * @return data The element inside the previous tail
	 */
	public T removeLast() {
		if(isEmpty()) {
			throw new NoSuchElementException("Cannot remove from an empty list.");
		}
		// set the current tails data to temp data
		T data = tail.data;
		// move tails to the previous node
		tail = tail.prev;
		// if the tail was the only element set the list as empty
		if(tail == null) {
			head = null;
		} else {
			// link the new tails next to null
			tail.next = null;
		}
		// de-increment entries
		numOfEntries--;
		// return the previous heads data
		return data;
	}
	/**
	 * remove method that removes the element and chosen index
	 * @param index of the element to be removed
	 * @return data The element inside the chosen index to be removed
	 */
	public T remove(int index) {
		// Check for out of bounds exception
		if(index < 0 || index >= numOfEntries) {
			throw new IndexOutOfBoundsException("Input is less than 0, or greater than amount of elements in the List");
		}
		// if the index is 0 (the head)
		if(index == 0) {
			return removeFirst();
		}
		// if index is the tail
		if(index == numOfEntries-1) {
			return removeLast();
		}
		// Otherwise, get the node at the index and remove it
		Node current;
		if(index < numOfEntries/2) {
			current = head;
			for(int i = 0; i < index; i++) {
				current = current.next;
			}
		}else {
			 current = tail;
				for(int i = numOfEntries-1; i > index; i--) {
					current = current.prev;
				}
			}
		// unlink and relink the nodes around
		Node before = current.prev;
		Node after = current.next;
		before.next = after;
		after.prev = before;
		// de increment and return data
		numOfEntries--;
		return current.data;
	}
	/**
	 * remove method that removes the element if its in the list
	 * @param element to be removed
	 * @return true if it was found and removde, false otehrwise
	 */
	public boolean remove(T element) {
		Node current = head;
		
		while(current != null) {
			// check if it equals
			if(element.equals(current.data)) {
				// if its at the head
				if(current == head) {
					removeFirst();
				}
				// if its at the tail
				else if(current == tail) {
					removeLast();
				}
				// otherwise remove wherver its at
				else {
					// un link and re link the node
					Node before = current.prev;
					Node after = current.next;
					before.next = after;
					after.prev = before;
					// de increment
					numOfEntries--;
				}
				return true;
			}
			current = current.next;
		}
		// if it was not found in the list
		return false;
	}
	/**
	 * toArray that shows all elements in the list
	 * @return Object[] containing all elements
	 */
	public Object[] toArray() {
		// create array to match size of the list
		Object[] array = new Object[numOfEntries];
		// traverse the list and add every element
		Node current = head;
		int index = 0;
		while(current != null) {
			array[index++] = current.data;
			current = current.next;
		}
		// retrun the array
		return array;
	}
	/**
	 * The iterator for this linkedList
	 */
	@Override
	public ListIterator<T> iterator(){
		return new GenericIterator();
	}
	
	/**
	 * the private GenericIterator class
	 */
	private class GenericIterator implements ListIterator<T>{
		// setup the fields
		// the node that is returned by iterator
		private Node next;
		// the last node returned
		private Node lastReturned;
		// index of next
		private int nextIndex;
		//Constructor to setup the iterator class
		private GenericIterator() {
			this.next = head;
			this.lastReturned = null;
			this.nextIndex = 0;
		}
		/**
		 * hasNext method
		 * @return true if there is something next, false otherwise
		 */
		@Override
		public boolean hasNext() {
			return next != null;
		}
		/**
		 * iterates to the next element
		 * @return the next node
		 */
		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException("No next element exists.");
			}
			// set this as the current node
			lastReturned = next;
			// set the next node
			next = next.next;
			// increment index
			nextIndex++;
			// return the current nodes element
			return lastReturned.data;
		}
		/**
		 * checks for previous 
		 * @return true if there is something next, false otherwise
		 */
		@Override
		public boolean hasPrevious() {
			// if next is null we are past the tail
			if(next == null) {
				return tail != null;
			}
			// otherwise check if theres a previous node
			return next.prev != null;
		}
		/**
		 * iterastes to  previous 
		 * @return the previous node
		 */
		public T previous() {
			Node node;
			// if the next node is null were at the tail, so return to it
			if(next == null) {
				node = tail;
			}else {
				node = next.prev;
			}
			// if the node is null
			if (node == null) {
				throw new NoSuchElementException("No previous element exists.");
			}
			// set the node
			next = node;
			lastReturned = node;
			nextIndex--;
			return node.data;
		}
		/**
		 * Method to remove element
		 */
		public void remove() {
			if (lastReturned == null) {
				throw new IllegalStateException("No element to remove.");
			}
			// Set nodes to the iterators next and previous
			Node before = lastReturned.prev;
			Node after = lastReturned.next;
			// Relink surrounding nodes
			// head relink
			if(before == null) {
				head = after;
			}else {
				before.next = after;
			}
			// tail relink
			if(after == null) {
				tail = before;
			}else {
				after.prev = before;
			}
			// Adjust the iterator
			if(lastReturned == next) {
				next = after;
			}
			else {
				nextIndex--;
			}
			// de increment and set to null
			numOfEntries--;
			lastReturned = null;
		}
		// Override the other methods and set them to UnsupportedOpertationExceptions
		@Override
		public void set(T element) {
			throw new UnsupportedOperationException();
		}
		@Override
		public void add(T element) {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}
		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}
	}
	/*
	 * private Node class that holds the data and address of next node
	 */
	private class Node {
	// fields for node
	private T data;
	private Node next;
	private Node prev;
	// Constructor with data
	private Node (T data) {
		this.data = data;
		this.next = null;
		this.prev = null;
		}
	// Constructor with all parameters
	private Node (T data, Node prev,Node next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
		}
	}
	
}
