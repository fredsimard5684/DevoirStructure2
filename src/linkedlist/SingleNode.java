package linkedlist;

public class SingleNode {
	private String valueString;
	private SingleNode next;
	
	
	public String getValueString() {
		return valueString;
	}
	public void setValueString(String valueString) {
		this.valueString = valueString;
	}
	public SingleNode getNext() {
		return next;
	}
	public void setNext(SingleNode next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return valueString + "";
	}
 }
