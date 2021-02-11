// Fig. 21.11: Queue.java
// Queue uses class List.
package lists;

import java.util.NoSuchElementException;

public class Queue<E> {
	private List<E> queueList;

	// constructor
	public Queue() {
		queueList = new List<E>("queue");
	}

	// add object to queue
	public void enqueue(E object) {
		queueList.insertAtBack(object);
	}

	// remove object from queue
	public E dequeue() throws NoSuchElementException {
		return queueList.removeFromFront();
	}
	public E peek() {
		return queueList.peek();
	}
	
	public int size() {
		return queueList.size();
	}
	
	
	public String toString() {
		return queueList.toString();
	}
	
	public String finalString() {
		return queueList.finalString();
	}
	

	// determine if queue is empty
	public boolean isEmpty() {
		return queueList.isEmpty();
	}

	// output queue contents
	public void print() {
		queueList.printq();
	}
}


