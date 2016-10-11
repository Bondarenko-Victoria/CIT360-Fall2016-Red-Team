/**
 * Created by Brian on 10/11/16.
 */
public class JoinStrings implements HandleStrings {

    // Joins the strings given by the user and prints the result
    public void execute(String word1, String word2, String adjective) {
        String result = adjective + " " + word1 + " " + word2;
        System.out.println("Result: " + result);
    }
}
