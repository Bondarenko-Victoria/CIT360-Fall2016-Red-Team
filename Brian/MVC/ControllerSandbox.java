/**
 * Created by Brian on 10/01/2016.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;


public class ControllerSandbox {
    // reference the view and the model so it can be the middle communicator
    // cause view never talks to model and vice versa
    private ViewSandbox view;
    private ModelSandbox model;

    ControllerSandbox(ViewSandbox view, ModelSandbox model) {
        this.view = view;
        this.model = model;
        this.view.searchZPButtonListener(new searchZPButtonListener());
    }

    // default constructor
    public ControllerSandbox() {
    }

    /* Set action for the price button */
    class searchZPButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                // Gets the cities saved from in the model
                model.saveUserCity(view.getCity());
                // gets the zip from the hashmap function and puts it in the view.
                view.setZipCode(getZipCode());
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /* getFlightPrice method*/
    public String getZipCode() {
        // Stores the data from the model into the array list.
        ArrayList userCities = model.getUserCity();
        // Stores the city stored in the array list.
        String inputCity = (String)userCities.get(0);

        HashMap zpHash = model.cityDatabase();

        String result = "";
        try {
            if (zpHash.containsKey(inputCity)) {
                result = zpHash.get(inputCity).toString();
            } else {
                result = "No match found!";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // clear data and keep the first 2 numbers
        clearArrayData();
        return result;
    }

   // Clears new data saved and only keeps the first 2 numbers
    protected void clearArrayData() {
        model.userCity.clear();
    }
}
