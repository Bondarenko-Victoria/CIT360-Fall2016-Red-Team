/**
 * Created by Brian on 10/01/2016.
 */

import java.util.ArrayList;
import java.util.HashMap;

public class ModelSandbox {

    // default constructor
    public ModelSandbox() {
    }

    // array list to store the input numbers from the view.
    protected ArrayList<String> userCity = new ArrayList();

    // Saves the cities from the view into the array list.
    public void saveUserCity(String aCity) {
        userCity.add(aCity);
    }

    // Gets the data from the array list.
    public ArrayList getUserCity() {
        return new ArrayList<>(userCity);
    }

    public HashMap cityDatabase() {
        HashMap<String, String> database = new HashMap<>();
        database.put("rexburg", "83440");
        database.put("provo", "84601");
        database.put("los angeles", "90061");
        database.put("san diego", "92121");
        database.put("miami", "33125");
        database.put("idaho falls", "83401");
        database.put("nyc", "10001");
        database.put("salt lake city", "84101");
        database.put("boise", "83701");
        database.put("las vegas", "89101");

        return database;
    }
}
