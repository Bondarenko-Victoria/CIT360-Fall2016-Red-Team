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
    
    // NASTY PATHS
    // You get a NullPointerException if the userCity arrayList constructor is null.
    // protected ArrayList<String> userCity = new ArrayList(null);

    /* You will get an IllegalArgumentException: Illegal Capacity exception if the
     * arrayList constructor capacity has a negative integer.
     */
    // protected ArrayList<String> userCity = new ArrayList(-1);

    // Saves the cities from the view into the array list.
    public void saveUserCity(String aCity) {
        userCity.add(aCity);
        
         // NASTY PATH
        /* You get a NullPointerException if the input city is not added to
        *  the userCity arrayList.
        */
        //userCity.add(null);
    }

    // Gets the data from the array list.
    public ArrayList getUserCity() {
        return new ArrayList<>(userCity);
        
        // NASTY PATH
        // You get a NullPointerException if the method returns a null arrayList.

        // return new ArrayList(null);
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
        
        // NASTY PATHS
        // You will get a NullPointerException if the 'database' hash map constructor is empty.
        // HashMap<String, String> database = new HashMap<>(null);

        /* You will get an IllegalArgumentException: Illegal initial capacity if the
         * hashmap constructor has an initial capacity of a negative integer.
         */
        //HashMap<String, String> database = new HashMap<>(-1);

        return database;
    }
}
