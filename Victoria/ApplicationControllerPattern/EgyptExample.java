package ApplicationControllerPattern;

/**
 * Created by Victoria on 01.10.2016.
 */

// Implements Handler interface
class EgyptExample implements Handler {

    // Overrides execute method
    @Override
    public void execute(int rooms) {
        // Prints the result
        System.out.println("Markhaba, welcome to Egypt! Enjoy your time " +
                "spending with camels and pyramids.");
    }
}