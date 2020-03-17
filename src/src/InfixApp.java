package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

public class InfixApp {

	public static void main(String[] args) throws IOException {
		String inputString = getString();
		InToPost post = new InToPost(inputString);
		String output = post.doTrans();
		EvaluatePostFix evaluatePostFix = new EvaluatePostFix(output);
		String result = evaluatePostFix.eval();
		System.out.println(output);
		System.out.println(result);
		outputResultToFile(inputString, output, result);
		
	}
	public static String getString() throws IOException  {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		if (!br.ready()) {
			System.out.println("Le programme s'est éteint car le fichier entré en System.in(Run configuration-->common-->System.in)\n"
					+ "est innexistant ou contient un erreur rendant sa lecture impossible. Veuillez revoir le nom du fichier "
					+ "dans la configuration du programme.");
			System.exit(0);
		}
		String s = br.readLine();
		return s;
	}
	
	private static void outputResultToFile(String input, String postFix, String result) throws IOException {
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		bw.write(input + "\t|\t" + postFix + "\t|\t" + result);
		bw.close();
	}
}
