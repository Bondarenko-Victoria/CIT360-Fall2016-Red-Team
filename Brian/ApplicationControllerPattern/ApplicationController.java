import java.util.HashMap;

/**
 * Created by Brian on 10/11/16.
 */
public class ApplicationController {

    // Creates a hash map to use to store the user input command and the result of the operation
    // user request for the three strings.
    public static HashMap<String, HandleStrings> commandsHashMap = new HashMap<String, HandleStrings>();

    // Default constructor
    public void ApplicationController() {

    }

    public static void handleComand(String command, String word1, String word2, String adjective) {
        // Save in the hash map command 'key', with the operation result as the 'value'
        commandsHashMap.put("c", new JoinStrings());

        // Stores the key and value to the method later.
        HandleStrings myHandler = commandsHashMap.get(command);

        // Call to the method to handle the strings and perform the right operation.
        myHandler.execute(word1, word2, adjective);
    }
}
