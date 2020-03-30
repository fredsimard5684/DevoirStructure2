// ***********************************************************************************************************************************************************************
// InfixApp.java 			Auteurs: Simard, Mongeau, Desfosses
// 
// Ce fichier contient la classe InfixApp. C'est le programme principal. Celui-ci permet d'afficher � la console les expressions postfix et les
// les r�sultats des �quations Infix lu � partir d'un fichier input.
//********************************************************************************************************************************************************************
package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InfixApp {

	public static void main(String[] args) throws IOException {
		String gatherAllLine;
		String inputString, inputWithoutWhiteSpace, outputPostFix, outputResult;
		StringBuilder outputConsole = new StringBuilder();
		System.out.println("Veuillez entrer les vos �quation infix et terminer en ajoutant une ligne vide:\n");
		gatherAllLine = getString(); // Recupere dans un String les donnees
		String[] readLine = gatherAllLine.split("\\r?\\n"); // R�cup�re sous forme de tableau les donn�e
		for (int i = 0; i < readLine.length; i++) {
			inputString = readLine[i]; // Enregistre la valeur avec les espaces de la ligne du fichier
			inputWithoutWhiteSpace = readLine[i].replaceAll("\\s+", ""); // Remplace les lignes blanches
			InToPost inToPost = new InToPost(inputWithoutWhiteSpace);
			outputPostFix = inToPost.doTrans(); // Fait la conversion Infix � Postfix
			if (outputPostFix.contains("(") || outputPostFix.contains(")"))
				outputPostFix = "ERROR";
			EvaluatePostFix evaluatePostFix = new EvaluatePostFix(outputPostFix);
			try {
				outputResult = evaluatePostFix.eval(); // Calcule la r�ponse du Postfix
				if (outputResult.contains("\u221E") || outputResult.contains("NaN")) { // Le formatage(DecimalFormart)
																						// d'infini r�sulte au caract�re
																						// ?.. Il faut donc aller
																						// chercher son caract�re
																						// equivalent de formatage
					outputResult = "ERROR";
				} // Fin du if

			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
				outputResult = "ERROR";
			} // Fin du bloc try-catch
			
			outputConsole.append(inputString + "\t|\t" + outputPostFix + "\t|\t" + outputResult + "\n");
			//outputConsole += inputString + "\t|\t" + outputPostFix + "\t|\t" + outputResult + "\n"; // Va permettre
																										// d'afficher
																										// les r�sultats
																										// � la console
		}
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("VOICI L'ENSEMBLE DES DONN�ES:");
		System.out.println(outputConsole.toString());
	} // Fin du main
	

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String lines = "";
		StringBuilder inputString = new StringBuilder();
		//Tant qu'il n'y a pas de lignes vides, on continue.
		while (!(lines = br.readLine()).isEmpty()) {
			System.out.flush();
			inputString.append(lines).append("\n");
		} // Fin de la boucle while
		br.close();
		return inputString.toString();
	} // Fin de la methode
} // Fin de la classe
