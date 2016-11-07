package ApplicationControllerPattern;

/**
 * Created by Victoria on 01.10.2016.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ApplicationControllerPatternExample {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Creates an instance of the room's controller
        RoomsControllerExample roomsController = new RoomsControllerExample();

        try {
            System.out.println("Imagine that you can open a room and access some country!");
            System.out.println("Which country do you want to go?");
            System.out.println("1 for Egypt, 2 for Turkey and 3 for Israel.");

            // Reads number from keyboard and
            // stores integer from the user input
            int door = Integer.parseInt(reader.readLine());
            // Calls to the controller's puttingItems method to pass the user input
            roomsController.puttingItems(door);
        }
        catch (Exception e){
            System.out.println("Type 1, 2 or 3!!!");
            int door = Integer.parseInt(reader.readLine());
            roomsController.puttingItems(door);
        }
    }
}