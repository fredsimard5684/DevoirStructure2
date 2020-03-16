package src;

import java.text.DecimalFormat;

import stack.*;

public class EvaluatePostFix {
	private StackString theStack;
	private String postFixInput;

	public EvaluatePostFix(String s) {
		postFixInput = s;
		theStack = new StackString(s.length());
	}

	public String eval() {
		String[] valueString = postFixInput.split(" ");
		String characterSequence;
		double num1 = 0, num2 = 0;
		double interAns = 0;

		for (int i = 0; i < valueString.length; i++) {
			characterSequence = valueString[i];
			theStack.displayStack("" + characterSequence + " ");
			if (characterSequence.matches("^[0-9]+$"))
				theStack.push(characterSequence);
			else if (characterSequence.equals("$")) {
				interAns = Double.parseDouble(theStack.pop());
				interAns = Math.sqrt(interAns);
				theStack.push(String.valueOf(interAns));
			}
			else {
				num2 = Double.parseDouble(theStack.pop());
				num1 = Double.parseDouble(theStack.pop());

				switch (characterSequence) {
				case "+":
					interAns = num1 + num2;
					break;
				case "-":
					interAns = num1 - num2;
					break;
				case "*":
					interAns = num1 * num2;
					break;
				case "/":
					interAns = num1 / num2;
					break;
				default:
					interAns = 0;
					break;
				} //Fin du switch
				theStack.push(String.valueOf(interAns));
			} // Fin du else
		} // Fin de la boucle for
		interAns = Double.parseDouble(theStack.pop());
		DecimalFormat format = new DecimalFormat("0.################################");
		return format.format(interAns);
	} // Fin de la methode
} // Fin de la classe
