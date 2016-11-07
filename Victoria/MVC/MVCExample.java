package MVC;

/**
 * Created by Victoria on 04.10.2016.
 */

import java.io.IOException;

public class MVCExample {

    public static void main(String[] args) throws IOException {
        // Reference the model
        ModelExample modelExample = new ModelExample();
        // Reference the view
        ViewExample viewExample = new ViewExample(modelExample);
        // Pass the model and the view to the Control constructor to run
        new ControllerExample(modelExample, viewExample).run();

        /* NASTY PATHS */

        // Gets NullPointerException
        // You will receive it if null is passed for(instead of)
        // the view and model in controller constructor

        // new ControllerExample(null, null).run();
    }

}