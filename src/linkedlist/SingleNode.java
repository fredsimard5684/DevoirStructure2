// ***********************************************************************************************************************************************************************
// SingleNode.java 			Auteurs: Simard, Mongeau, Desfosses
// 
// Ce fichier contient la classe SingleNode. Cette classe est n�cessaire � l'implementation de la linked list puisqu'elle permet de cr�er par r�f�rence,
// les liens entre les noeuds.
//********************************************************************************************************************************************************************
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
