package src;

public class InfixApp {

	public static void main(String[] args) {
		String inputString = "$(10-5)-67-23+54*44+(55*6)*4+(40+10)-6";
		InToPost post = new InToPost(inputString);
		String output = post.doTrans();
		System.out.println(output);
	}

}
