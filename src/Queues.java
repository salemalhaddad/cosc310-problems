// The students’ exam-scripts are stored in a box, in random order. The lecturer wants to review those
// exam-scripts with a mark less than the pass-mark 60. So, he takes out all the scripts, one by one,
// removes the scripts with a mark less than 60, and keeps the others in order, so that he can return
// them to the box in exactly the same order as before – minus the scripts with a mark less than 60 of
// course. Write a client function to simulate this process.

public class Queues {
	public static void main(String[] args) {

	}

	public class LinkedQueue<E>  {
		private static class Node<E> { //inner class Node
			private E element;
			private Node<E> next;

			public Node(E e, Node<E> n) {
				element = e;
				next = n;
			}

			public E getElement() {
				return element;
			}

			public Node<E> getNext() {
				return next;
			}

			public void setNext(Node<E> n) {
				next = n;
			}
		} //end of inner class Node

		private Node<E> front = null;
		private Node<E> tail = null;
		private int size = 0;

		public LinkedQueue() {
		}

		public int size() {
			return size;
		}

		public boolean isEmpty() {
			return size == 0;
		}

		public E dequeue() {
			if (isEmpty()) {
				System.out.println("Queue is empty");
				return null;
			}

			E temp = front.element;
			front = front.next;
			size--;

			return temp;
		}

		public void printQueue() {
			if(isEmpty()) System.out.println( "Queue is Empty");
			String s="";
			Node<E> loc=front;
			while(loc!=null) {
				s+=loc.element+ " ";
				loc=loc.next;
			}
			System.out.println(s);
		}

	} // End of Selection

	static class ArrayQueue<E> {
   		public static int CAPACITY = 10;
		private E[] data; // holds the queue elements
		private int front = 0; // index of front element
		private int size = 0;

		public ArrayQueue() {
			this(CAPACITY); // default constructor
		}

		public ArrayQueue(int capacity) {
			CAPACITY = capacity;
			data = (E[]) new Object[capacity]; // constructor
		}

		public boolean isEmpty() {
			return size == 0;
		}

		public int size() {
			return size;
		}

		public E peek() {
			if (isEmpty()) return null; // method to peek at the front element
			return data[front];
		}
		// The QueueType class is to be extended by the addition of a function, printQueue, which prints
		// all the elements in the encapsulated queue.
		// a) Write the Java code for function printQueue( ) using the array-based queue.

		public void printQueue() {
			if(isEmpty())
				System.out.println("Queue is empty");

			for (int i = 0; i < data.length; i++) {
				System.out.println("Element " + (i + 1) + " is " + data[i]);
			}
		}
		public E dequeue() {
			if (isEmpty()) {
				System.out.println("Queue is empty");
				return null;
			}
			E answer = data[front];
			data[front] = null;
			front = (front + 1) % data.length; // circular Queue wrap around
			size--;
			return answer;
		}

		public void enqueue(E e) throws IllegalStateException {
			if (size == data.length) throw new IllegalStateException("Queue is Full");
			data[(front + size) % data.length] = e; // circular Queue wrap around
			size++;
		}
	}
}
