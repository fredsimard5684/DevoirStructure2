package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class InfixApp {

	public static void main(String[] args) throws IOException {
		String gatherAllLineFromFile = getString();
		String inputFromFile, inputWithoutWhiteSpace, outputPostFix, outputResult = "", outputConsole = "";
		String[] readLine = gatherAllLineFromFile.split("\\r?\\n");
		for (int i = 0; i < readLine.length; i++) {
			inputFromFile = readLine[i]; // Enregistre la valeur avec les espaces de la ligne du fichier
			inputWithoutWhiteSpace = readLine[i].replaceAll("\\s+", ""); // Remplace les lignes blanches
			InToPost inToPost = new InToPost(inputWithoutWhiteSpace);
			outputPostFix = inToPost.doTrans();
			if (outputPostFix.contains("(") || outputPostFix.contains(")"))
				outputPostFix = "ERROR";
			EvaluatePostFix evaluatePostFix = new EvaluatePostFix(outputPostFix);
			try {
				outputResult = evaluatePostFix.eval();
				if (outputResult.contains("\u221E") || outputResult.contains("NaN")) { // Le formatage(DecimalFormart)
																						// d'infini résulte au caractère
																						// ?.. Il faut donc aller
																						// chercher son caractère
																						// equivalent de formatage
					outputResult = "ERROR";
				}

			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			}
			outputConsole += inputFromFile + "\t|\t" + outputPostFix + "\t|\t" + outputResult + "\n";
		}
		System.out.println(outputConsole);
	} // Fin du main

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String lines = "";
		String inputString = "";
		if (!br.ready()) {
			System.out.println(
					"Le programme s'est éteint car le fichier entré en System.in(Run configuration-->common-->System.in)\n"
							+ "est innexistant ou contient un erreur rendant sa lecture impossible. Veuillez revoir le nom du fichier "
							+ "dans la configuration du programme.");
			System.exit(0);
		}
		try {
			while (!(lines = br.readLine()).isEmpty())
				inputString += lines + "\n";
		} finally {
			br.close();
		}
		return inputString;
	} // Fin de la methode
} // Fin de la classe
