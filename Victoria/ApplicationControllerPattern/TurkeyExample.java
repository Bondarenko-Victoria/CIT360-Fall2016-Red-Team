package ApplicationControllerPattern;

/**
 * Created by Victoria on 01.10.2016.
 */

// Implements Handler interface
class TurkeyExample implements Handler {

    // Overrides execute method
    @Override
    public void execute(int rooms) {
        // Prints the result
        System.out.println("Selam, welcome to Turkey! Enjoy your time " +
                "eating rakhatlukum and climbing mountains.");
    }

}