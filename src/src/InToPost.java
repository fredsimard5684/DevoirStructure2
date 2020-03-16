package src;
import stack.*;

public class InToPost {
	private String input;
	private String output = "";
	private Stack theStack;
	
	public InToPost(String in) {
		input = in;
		theStack = new Stack();
	} //Fin constructeur
	
	public String doTrans() {
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			theStack.displayStack("Pour " +ch+" ");
			switch (ch) {
			case '+':
			case '-' :
				gotOper(ch, 1);
				break;
			case '*' :
			case '/' :
				gotOper(ch, 2);
				break;
			case '$' :
				gotOper(ch, 3);
				break;
			case '(':
				theStack.push(ch);
				break;
			case ')':
				gotParen(ch);
				break;
			default:
				String number = "";
				int j = i;
				while (ch >= '0' && ch <= 9) {
					number += ch;
					j++;
					ch = input.charAt(j);
				} //Fin de la boucle while
				i = j - 1;
				output += number + " ";
				break;
			} //Fin du switch case
		} //Fin de la boucle for
		while (!theStack.isEmpty()) {
			theStack.displayStack("Pendant ");
			output += theStack.pop() + " ";
		} //Fin de la boucle while
		theStack.displayStack("Fin  ");
		return output;
	} //Fin de la methode
	
	public void gotOper(char opThis, int prec1) {
		while (!theStack.isEmpty()) {
			char opTop = theStack.pop();			
			if (opTop == '(') {
				theStack.push(opTop);
				break;
			} else {
				int prec2;
				if(opTop == '+' || opTop == '-')
					prec2 = 1;
				else if (opTop == '*' || opTop == '/') {
					prec2 = 2;
					if (prec2 < prec1) {
						theStack.push(opTop);
						break;
					} else
						output += opTop + " ";
				} // Fin else-if
				else { //Pour aller chercher le $ qui a la plus grande priorite
					prec2 = 3;
					if (prec2 < prec1) { //Pour le $
						theStack.push(opTop);
						break;
					} else 
						output += opTop + " ";
				} //Fin du else
			} //Fin du else externe
		} //Fin du while
		theStack.push(opThis);
	} //Fin de la methode
	
	public void gotParen(char ch) {
		while (!theStack.isEmpty()) {
			char chx = theStack.pop();
			if (chx == '(') 
				break;
			else 
				output += chx + " ";
		} //Fin de la boucle while
	} //Fin de la methode
} //Fin de la classe
