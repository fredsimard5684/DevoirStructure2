package linkedlist;

public class SingleNode {
	private char valueChar;
	private SingleNode next;
	
	
	public char getValueChar() {
		return valueChar;
	}
	public void setValueChar(char valueChar) {
		this.valueChar = valueChar;
	}
	public SingleNode getNext() {
		return next;
	}
	public void setNext(SingleNode next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return valueChar + "";
	}
 }
