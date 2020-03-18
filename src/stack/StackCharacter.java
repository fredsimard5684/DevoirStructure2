// ***********************************************************************************************************************************************************************
// StackCharacter.java 			Auteurs: Simard, Mongeau, Desfosses
// 
// Ce fichier contient la classe StackCharacter. Cette classe permet de créer une pile avec des caractères. L'implémentation de cette pile est fait
// par une LinkedList. Elle sera utile pour convertir le infix en outfix
// NOTE: Il n'était pas nécessaire de le faire de cette façon, on aurait pu utiliser un array comme dans le livre au lieu d'une LL.
// Or, nous trouvions que c'était une bonne idée d'implémenter une pile par LinkedList et par array pour se pratiquer. La classe StackString utilisera un array.
//********************************************************************************************************************************************************************
package stack;

import linkedlist.*;

public class StackCharacter {
	private SingleLinkedList list;

	// Constructeur
	public StackCharacter() {
		list = new SingleLinkedList();
	}

	public boolean isEmpty() {
		if (list.getTete() == null)
			return true;
		else
			return false;
	} // Fin de la methode

	public void push(char expression) {
		if (list.getTete() == null) { // Creer la linked list si ce n'est pas deja fait
			list.createSingleLinkedList(expression);
		} else { // Ajoute a la premiere position de la linked list. On fait cela car la pile est
					// un LIFO
			list.insertionDansLinkedList(expression, 0);
		}
		System.out.println("L'expression a ete ajoute dans la pile.");
	} // Fin de la methode

	public char pop() {
		char expressionValue = 0;
		if (isEmpty()) {
			System.out.println("Aucun item dans la pile");
		} else {
			expressionValue = list.getTete().getValueChar(); // Retiens le noeud sur le dessus de la pile
			list.deleteNode(0); // On pop le noeud sur le dessus de la pile
		}
		return expressionValue;
	} // Fin de la mathode

	public char peek() {
		if (isEmpty()) {
			System.out.println("La liste est vide");
			return '\0';
		} else
			return list.getTete().getValueChar();
	} // Fin de la methode

	public String peekN(int location) {
		return list.locationValue(location);
	} //Fin de la méthode

	public boolean searchStack(char ch) {
		return list.searchNode(ch);
	} //Fin de la méthode

	public void deleteStack() {
		list.setTete(null);
	} // Fin de la methode

	public int size() {
		return list.getSize();
	} //Fin de la méthode

	public void displayStack(String s) {
		System.out.println(s);
		System.out.println("Pile (dessous --> dessus): ");
		list.traverserLaLinkedList();
		System.out.println("");
	} // Fin de la methode
} // Fin de la classe
