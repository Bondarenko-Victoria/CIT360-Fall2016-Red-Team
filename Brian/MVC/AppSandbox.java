/**
 * Created by Brian on 10/01/2016.
 */

/*  This is a very simple app that allows the user to enter a city name
 *  in the textfield, and when the user clicks the search button, a zip code
 *  that belongs to that city name will be displayed in the zip code textfield.
 *  The purpose of this app is just to be an example, that's whay the database is
 *  too short. It only contains 10 names of cities with one zip code for each of them.
 */
public class AppSandbox {

    public static void main(String[] args) {
        // reference the model and the view
        ViewSandbox view = new ViewSandbox();
        view.setVisible(true);

        ModelSandbox model = new ModelSandbox();
        // pass the model and the view to the Control constructor
        ControllerSandbox control = new ControllerSandbox(view, model);
        
         //NASTY PATH
        /* You will get a NullPointerException if null is passed for the view and
         * the model to the controller constructor
         */
        // ControllerSandbox control = new ControllerSandbox(null, null);
    }
}
