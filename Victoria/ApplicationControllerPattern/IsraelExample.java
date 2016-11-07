package ApplicationControllerPattern;

/**
 * Created by Victoria on 01.10.2016.
 */

// Implements Handler interface
class IsraelExample implements Handler {

    // Overrides execute method
    @Override
    public void execute(int farmNumber) {
        // Prints the result
        System.out.println("Shalom, welcome to Israel!  Enjoy your time spending " +
                "in holy places and swimming in the Dead Sea.");
    }

}