package stack;

public class StackString {
	private int maxSize;
	private String[] stackArray;
	private int top;
	
	public StackString(int size) {
		maxSize = size;
		stackArray = new String[maxSize];
		top = -1;
	}
	
	public void push(String s) {
		stackArray[++top] = s;
	} //Fin de la methode
	
	public String pop() {
		return stackArray[top--]; 
	} //Fin de la methode
	
	public String peek() {
		return stackArray[top];
	} //Fin de la methode
	
	public boolean isEmpty() {
		return (top == 1);
	} //Fin de la methode
	
	public boolean isFull() {
		return (top == maxSize -1);
	} //Fin de la methode
	
	public int size() {
		return top + 1;
	} //Fin de la methode
	
	public String peekN(int n) {
		return stackArray[n];
	} //Fin de la methode
	
	public void displayStack(String s) {
		System.out.println(s);
		System.out.println("Stack (bottom-->top): ");
		for (int i = 0; i < size(); i++) {
			System.out.print(peekN(i));
			System.out.println(' ');
		} //Fin de la boucle for
		System.out.println("");
	} //Fin de la methode
}
