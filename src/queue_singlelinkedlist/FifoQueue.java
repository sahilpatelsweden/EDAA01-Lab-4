package queue_singlelinkedlist;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	e the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */

	// Handle insertion when the queue is empty (circular self-reference) //
	public boolean offer(E e) {
		QueueNode<E> newNode = new QueueNode<E>(e);
		if (last == null) {
			last = newNode;
			last.next = last;         // Circular reference for the single node
		} else {
			newNode.next = last.next;    // Point new node to the current head
			last.next = newNode;         // Link the current last node to the new node
			last = newNode;              // Update last to the new node
		}
		size++;             // Increment size after successful insertion
		return true;        // Indicate that the element was successfully added
	}
	
	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {		
		return size; // return the current number of elements stored in the queue
	}
	
	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */

	// Return the first element without removing it
	public E peek() {
		if (last == null) {
			return null;
		}
		return last.next.element;
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */

	// Remove and return the first element while maintaining circular structure //
	public E poll() {
		if (last == null) {
        	return null;
    	}

    	QueueNode<E> first = last.next;

    	if (first == last) {
        	last = null;
    	} else {
        	last.next = first.next;
    	}

    	size--;
    	return first.element;
	}
	
	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		return null;
	}
	
	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

}
