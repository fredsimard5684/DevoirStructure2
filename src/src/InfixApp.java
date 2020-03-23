// ***********************************************************************************************************************************************************************
// InfixApp.java 			Auteurs: Simard, Mongeau, Desfosses
// 
// Ce fichier contient la classe InfixApp. C'est le programme principal. Celui-ci permet d'afficher à la console les expressions postfix et les
// les résultats des équations Infix lu à partir d'un fichier input.
//********************************************************************************************************************************************************************
package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InfixApp {

	public static void main(String[] args) throws IOException {
		String gatherAllLineFromFile = "";
		String inputFromFile, inputWithoutWhiteSpace, outputPostFix, outputResult = "", outputConsole = "";
		System.out.println("Veuillez entrer les vos équation infix et terminer en ajoutant une ligne vide:\n");
		gatherAllLineFromFile = getString(); // Recupere dans un String les donnees du fichier
		String[] readLine = gatherAllLineFromFile.split("\\r?\\n"); // Récupère sous forme de tableau les donnée
		for (int i = 0; i < readLine.length; i++) {
			inputFromFile = readLine[i]; // Enregistre la valeur avec les espaces de la ligne du fichier
			inputWithoutWhiteSpace = readLine[i].replaceAll("\\s+", ""); // Remplace les lignes blanches
			InToPost inToPost = new InToPost(inputWithoutWhiteSpace);
			outputPostFix = inToPost.doTrans(); // Fait la conversion Infix à Postfix
			if (outputPostFix.contains("(") || outputPostFix.contains(")"))
				outputPostFix = "ERROR";
			EvaluatePostFix evaluatePostFix = new EvaluatePostFix(outputPostFix);
			try {
				outputResult = evaluatePostFix.eval(); // Calcule la réponse du Postfix
				if (outputResult.contains("\u221E") || outputResult.contains("NaN")) { // Le formatage(DecimalFormart)
																						// d'infini résulte au caractère
																						// ?.. Il faut donc aller
																						// chercher son caractère
																						// equivalent de formatage
					outputResult = "ERROR";
				} // Fin du if

			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
				outputResult = "ERROR";
			} // Fin du bloc try-catch
			outputConsole += inputFromFile + "\t|\t" + outputPostFix + "\t|\t" + outputResult + "\n"; // Va permettre
																										// d'afficher
																										// les résultats
																										// à la console
		}
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("VOICI L'ENSEMBLE DES DONNÉES:");
		System.out.println(outputConsole);
	} // Fin du main

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String lines = "";
		String inputString = "";
		//Tant qu'il n'y a pas de lignes vides, on continue.
		while (!(lines = br.readLine()).isEmpty()) {
			System.out.flush();
			inputString += lines + "\n";
		} // Fin de la boucle while
		br.close();
		return inputString;
	} // Fin de la methode
} // Fin de la classe
