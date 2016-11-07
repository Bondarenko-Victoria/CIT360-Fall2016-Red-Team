package ApplicationControllerPattern;

/**
 * Created by Victoria on 01.10.2016.
 */

import java.util.HashMap;

public class RoomsControllerExample {
    // Creates a hash map "rooms" to store the user input and
    // the result of the operation user request
    public static HashMap<Integer, Handler> rooms = new HashMap<Integer, Handler>();

    // Method puttingItems
    public static void puttingItems(int door){
        // Puts/saves items to rooms HashMap
        rooms.put(1, new EgyptExample());
        rooms.put(2, new TurkeyExample());
        rooms.put(3, new IsraelExample());

        // Stores the key and value to the method
        Handler handler = rooms.get(door);
        // Calls to the method to handle integer and perform the right operation
        handler.execute(door);
    }
}