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
		String gatherAllLineFromFile = "";
		String inputFromFile, inputWithoutWhiteSpace, outputPostFix, outputResult = "", outputConsole = "";
		gatherAllLineFromFile = getString(); // Recupere dans un String les donnees du fichier
		if (gatherAllLineFromFile.equals("")) // Si le fichier ne contient aucune donne, on termine le programme
			return;
		String[] readLine = gatherAllLineFromFile.split("\\r?\\n"); // R�cup�re sous forme de tableau les donn�e
		for (int i = 0; i < readLine.length; i++) {
			inputFromFile = readLine[i]; // Enregistre la valeur avec les espaces de la ligne du fichier
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
			} // Fin du bloc try-catch
			outputConsole += inputFromFile + "\t|\t" + outputPostFix + "\t|\t" + outputResult + "\n"; // Va permettre
																										// d'afficher
																										// les r�sultats
																										// � la console
		}
		System.out.println(outputConsole);
	} // Fin du main

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String lines = "";
		String inputString = "";
		if (!br.ready()) { // Si le BufferedReader n'a pas de fichier
			System.out.println(
					"Le programme s'est �teint car le fichier entr� en System.in(Run configuration-->common-->System.in)\n"
							+ "est innexistant ou contient un erreur rendant sa lecture impossible. Veuillez revoir le nom du fichier "
							+ "dans la configuration du programme.");
			throw new IOException();
		}
		while (!(lines = br.readLine()).isEmpty()) {
			System.out.flush();
			inputString += lines + "\n";
		} // Fin de la boucle while
		br.close();
		return inputString;
	} // Fin de la methode
} // Fin de la classe
