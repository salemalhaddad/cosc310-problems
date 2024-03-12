public class Stacks
{
	public static void main(String[] args) {
		int n;
        ArrayStack<Integer> stack = new ArrayStack();
        stack.push(1);
        while (!stack.isEmpty()) {
            n=stack.top();
            stack.pop();
            System.out.println(n);
            if(n <= 3) {
                stack.push(2 * n);
                stack.push(2 * n + 1);
            }
        }

		ArrayStack<Integer> IntStack = new ArrayStack();

        // Set SecondElement to the second element (from the top) in IntStack, leaving the stack without its top two elements.
        int SecondElement;
        IntStack.pop();
        SecondElement = stack.top();
        IntStack.pop();

        // Set Bottom equal to the bottom element in IntStack, leaving the stack empty.
		int Bottom = IntStack.top();

		while(!IntStack.isEmpty()) {
			Bottom = IntStack.top();
			IntStack.pop();
		}
		System.out.println("The bottom element is " + Bottom);

		// Set Bottom equal to the bottom element in IntStack, leaving the stack unchanged.
		int Bottom = IntStack.top();
		ArrayStack<Integer> tempStack = new ArrayStack();

		while(!IntStack.isEmpty()) {
			Bottom = IntStack.top();
			tempStack.push(Bottom);
			IntStack.pop();
		}

		int temp;
		while (!tempStack.isEmpty()) {
			temp = tempStack.top();
			IntStack.push(temp);
			tempStack.pop();
		}

		// Remove all the zero elements from IntStack, leaving all the other elements in the stack.
		int Bottom = IntStack.top();
		ArrayStack<Integer> tempStack = new ArrayStack();

		while(!IntStack.isEmpty()) {
			Bottom = IntStack.top();
			tempStack.push(Bottom);
			if (Bottom == 0)
				IntStack.pop();
		}

	}

    static class ArrayStack<E> {
        public static int CAPACITY = 10;
        // holds the stack elements
        private E[] data;
        // index to top element
        private int top = -1;


        public ArrayStack() {
        this(CAPACITY);
        } // default constructor


        public ArrayStack(int capacity) {// constructor
        CAPACITY = capacity;
        data = (E[]) new Object[capacity];
        }


        public boolean isEmpty() {
        return top == -1;
        }


        public int size() {
        return top + 1;
        }


        public void pop() {
        if (isEmpty())
          System.out.println("Stack is empty");
        top--;
        }


        public E top() {
        if (isEmpty())
          return null;
        return data[top];
    }


        // implement this method to print the stack – top first – ArrayStack only
        public String toString() {
			// insert code here
			String a=" ";
			for(int i=top;i>=0;i--){
			a=a+data[i]+" ";
			}
			return a;
        }


        // change this method to print the message in the output if size is exceeded
        public void push(E e) throws IllegalStateException {
			if (size() == data.length){
			System.out.println("Stack is full with "+ size()+"items");

			}
			else data[++top] = e;
        }

		public void *push(E e) {
			 a
		}


        // not part of the stack class but used here as an application method
        public static boolean isMatched(String expression) {
			final String opening = "({["; // opening delimiters
			final String closing = ")}]"; // respective closing delimiters
			ArrayStack<Character> buffer = new ArrayStack<Character>();
			System.out.print("Checking : ");
			for (char c : expression.toCharArray()) {
			System.out.printf("%s ", c);
			if (opening.indexOf(c) != -1) // this is a left delimiter
				buffer.push(c);
			else if (closing.indexOf(c) != -1) { // this is a right delimiter
				if (buffer.isEmpty()) { // nothing to match with
				System.out.println();
				return false;
				}
				if (closing.indexOf(c) != opening.indexOf(buffer.top())) {
				System.out.println();
				return false; // mismatched delimiter
				}
				buffer.pop();
			}
			}
			return buffer.isEmpty(); // were all opening delimiters matched?
        }


        // implement this method to reverse a stack using only methods of the class
        // This will allow you to use it in both array and linked list. Use 2 extra
        // stack objects to achieve this as discussed in class


        public void reverse() {
			// insert code here
			ArrayStack<E> stack= new ArrayStack<>();
			ArrayStack<E> stack1= new ArrayStack<>();
			while (!isEmpty()){
			E e=top();
			pop();
			stack.push(e);
			}
			while (!stack.isEmpty()){
			E e=stack.top();
			stack.pop();
			stack1.push(e);
			}
			while (!stack1.isEmpty()){
			E e=stack1.top();
			stack1.pop();
			push(e);
			}
        }
        // implement this method to reverse a stack using only methods of the class
        // This will allow you to use it in both array and linked list. Use an extra
        // stack object to push only items not equal to e as discussed in class


        public boolean eliminate(E e) {
			// insert code here
			ArrayStack<E> stack = new ArrayStack();
			boolean found = false;
			while (!isEmpty()){
			E m=top();
			pop();
			if(e!=m)
			stack.push(m);
			else found = true;
			}
			while (!stack.isEmpty()){
			E m=stack.top();
			stack.pop();
			push(m);
			}
			if(found)
			System.out.println(e+" is found in the stack");
			else
			System.out.println(e+" is not found in the stack");
			return found;
        }
    }
}
