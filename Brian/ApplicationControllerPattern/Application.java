import java.util.Scanner;

/**
 * Created by Brian on 10/11/16.
 */

/* This is a very simple app that prompts the user for 2 words and a possessive adjective.
 * Then it prompts the user to enter the letter 'c' to combine the three strings, and
 * it then prints the strings in one sentence. 
 */
public class Application {

    public static void main(String[] args) {
        // Creates an instance of the controller
        ApplicationController myController = new ApplicationController();

        // variables to store user input
        String command;
        String word1;
        String word2;
        String adjective;

        // Creates a scanner for user input.
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a word: ");
        // Stores the first string from the user input
        word1 = input.next();
        System.out.println("Enter another word: ");
        // Stores the second string from the user
        word2 = input.next();
        System.out.println("Enter a possessive adjective: (My, your, her, our, their)");
        // Stores the third string from the user input
        adjective = input.next();
        System.out.println("'c' to combine words");
        System.out.println("Enter a letter: ");
        // Stores the 'string' command from the user
        command = input.next();

        // Call to the controller's handleCommand method to pass the user input command and the words.
        myController.handleComand(command, word1, word2, adjective);
    }
}
