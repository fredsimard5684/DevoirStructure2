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
	
	public void push(String expression) {
		if (list.getTete() == null) { //Creer la linked list si ce n'est pas deja fait
			list.createSingleLinkedList(expression);
		} else { //Ajoute a la premiere position de la linked list. On fait cela car la pile est un LIFO
			list.insertionDansLinkedList(expression, 0);
		}
		System.out.println("L'expression a ete ajoute dans la pile.");
	} //Fin de la methode
	
	public String pop() {
		String expressionValue = null;
		if (isEmpty()) {
			System.out.println("Aucun item dans la pile");
		} else {
			expressionValue = list.getTete().getValueString(); //Retiens le noeud sur le dessus de la pile
			list.deleteNode(0); //On pop le noeud sur le dessus de la pile
		}
		return expressionValue;
	} //Fin de la mathode
	
	public String peak() {
		if (isEmpty()) {
			System.out.println("La liste est vide");
			return null;
		} else 
			return list.getTete().getValueString();
	} //Fin de la methode
	
	public void deleteStack() {
		list.setTete(null);
	} //Fin de la methode
} //Fin de la classe
