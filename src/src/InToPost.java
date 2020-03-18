// ***************************************************************************************************************************************************************************
// InToPost.java 			Auteurs: Simard, Mongeau, Desfosses
// 
// Ce fichier contient la classe InToPost. Cette classe permet d'effectuer la transformastion infix � postfix. On utilise une pile impl�mentent la Linked List(StackCaracter).
//****************************************************************************************************************************************************************************
package src;

import stack.StackCharacter;

public class InToPost {
	private String input;
	private String output = "";
	private StackCharacter theStack;

	public InToPost(String in) {
		input = in;
		theStack = new StackCharacter();
	} // Fin constructeur

	public String doTrans() {
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			theStack.displayStack("Pour " + ch + " ");
			switch (ch) {
			case '+':
			case '-':
				gotOper(ch, 1);
				break;
			case '*':
			case '/':
				gotOper(ch, 2);
				break;
			case '$':
				gotOper(ch, 3);
				break;
			case '(':
				theStack.push(ch);
				break;
			case ')':
				gotParen(ch);
				break;
			default:
				output += ((ch >= 48 && ch <= 57) || ch == '.') ? ch : " "; // Si ch est un nb ou un point, affiche le
																			// caract�re, sinon mettre un espace
																			// Permet d'identifier et cr�er les 
																			//nombres plus grand que 9.
				try {
					char next = input.charAt(i + 1);
					output += ((next >= 48 && ch <= 57) || next == '.') ? "" : " "; // Si le prochain ch est un nb ou un
																					// point, ne rien ajouter � output,
																					// sinon mettre un espace
				} catch (Exception e) {
					output += " "; // S'il n'y a plus de caract�re suivant, ajouter un espace
				} // Fin try-catch
				break;
			} // Fin du switch case
		} // Fin de la boucle for
		while (!theStack.isEmpty()) {
			theStack.displayStack("Pendant ");
			output += theStack.pop() + " ";
		} // Fin de la boucle while
		theStack.displayStack("Fin  ");
		return output;
	} // Fin de la methode

	public void gotOper(char opThis, int prec1) {
		while (!theStack.isEmpty()) {
			char opTop = theStack.pop();
			if (opTop == '(') {
				theStack.push(opTop);
				break;
			} else {
				int prec2 = 0;
				if (opTop == '+' || opTop == '-')
					prec2 = 1;
				else if (opTop == '*' || opTop == '/')
					prec2 = 2;
				else // Pour le $
					prec2 = 3;
				if (prec2 < prec1) {
					theStack.push(opTop);
					break;
				} else
					output += opTop + " ";
			}
		} // Fin du while
		theStack.push(opThis);
	} // Fin de la methode

	public void gotParen(char ch) {
		while (!theStack.isEmpty()) {
			char chx = theStack.pop();
			if (chx == '(') {
				break;
			} else
				output += chx + " ";
		} // Fin de la boucle while
	} // Fin de la methode
} // Fin de la classe
