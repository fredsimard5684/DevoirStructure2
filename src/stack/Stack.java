package stack;
import linkedlist.*;

public class Stack {
	private SingleLinkedList list;
	
	//Constructeur
	public Stack() {
		list = new SingleLinkedList();
	}
	
	public boolean isEmpty() {
		if (list.getTete() == null) 
			return true;
		else
			return false;
	} //Fin de la methode
	
	public void push(char expression) {
		if (list.getTete() == null) { //Creer la linked list si ce n'est pas deja fait
			list.createSingleLinkedList(expression);
		} else { //Ajoute a la premiere position de la linked list. On fait cela car la pile est un LIFO
			list.insertionDansLinkedList(expression, 0);
		}
		System.out.println("L'expression a ete ajoute dans la pile.");
	} //Fin de la methode
	
	public char pop() {
		char expressionValue = 0;
		if (isEmpty()) {
			System.out.println("Aucun item dans la pile");
		} else {
			expressionValue = list.getTete().getValueChar(); //Retiens le noeud sur le dessus de la pile
			list.deleteNode(0); //On pop le noeud sur le dessus de la pile
		}
		return expressionValue;
	} //Fin de la mathode
	
	public char peek() {
		if (isEmpty()) {
			System.out.println("La liste est vide");
			return '\0';
		} else 
			return list.getTete().getValueChar();
	} //Fin de la methode
	
	public void deleteStack() {
		list.setTete(null);
	} //Fin de la methode
	
	public void displayStack(String s) {
		System.out.println(s);
		System.out.println("Stack (bottom --> top): ");
		list.traverserLaLinkedList();
		System.out.println("");
	} //Fin de la methode
} //Fin de la classe
