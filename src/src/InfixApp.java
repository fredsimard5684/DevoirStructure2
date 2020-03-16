package src;
import stack.*;
public class InfixApp {

	public static void main(String[] args) {
		String inputString = "$(10*10)-30";
		InToPost post = new InToPost(inputString);
		String output = post.doTrans();
		EvaluatePostFix evaluatePostFix = new EvaluatePostFix(output);
		String result = evaluatePostFix.eval();
		System.out.println(output);
		System.out.println(result);
		
	}

}
