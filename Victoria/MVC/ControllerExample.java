package MVC;

/**
 * Created by Victoria on 04.10.2016.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ControllerExample {

    // Reference to the view and the model
    // It is the middle communicator
    // View never talks to model and model never talks to view
    private ModelExample modelExample;
    private ViewExample viewExample;

    // Constructor
    public ControllerExample (ModelExample modelExample, ViewExample viewExample) {
        this.modelExample = modelExample;
        this.viewExample = viewExample;
    }

    // Method run
    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            // Every single letter to lower case
            String exit = reader.readLine().toLowerCase();
            if (exit.equals("exit")) {
                break;
            }
            // Read a number from key board
            int num = Integer.parseInt(exit);
            int number = num;
            // Calls yourNum, printNum, printText2 methods
            number = modelExample.yourNum();
            viewExample.printNum(num);
            viewExample.printText2();
        }
    }

}