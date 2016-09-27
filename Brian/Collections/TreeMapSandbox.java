/**
 * Created by Brian on 09/23/2016.
 */
package Collections;
import java.util.ArrayList;
import java.util.TreeMap;

public class TreeMapSandbox {
    public static void main(String[] args) {

        // Creates a TreeMap called colorsTreeMap
        TreeMap<Integer,String> colorsTreeMap =
                new TreeMap<Integer, String>();
        colorsTreeMap.put(1, "blue");
        colorsTreeMap.put(2, "red");
        colorsTreeMap.put(3, "yellow");
        colorsTreeMap.put(4, "orange");

        // Creates an ArrayList called colorArrayList.
        ArrayList<String> colorArrayList = new ArrayList<>();

        /* Happy paths */

        // Add values to the colorArrayList.
        colorArrayList.add("brown");
        colorArrayList.add("gray");
        colorArrayList.add("black");
        colorArrayList.add("white");

        // Happy paths

        /* Prints all the values of the colorsTreeMap
        * to make sure the values were added
        */
        System.out.println("Valid tree map"
                + colorsTreeMap);

        /* Gets the first key from the the colorsTreeMap
        *  and prints it.
        */
        try {
            System.out.println("First key: "
                    + colorsTreeMap.firstKey());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Gets the first key and value of the colorsTreeMap
        *  and prints it
        */
        try {
            System.out.println("First entry: "
                    + colorsTreeMap.firstEntry());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Gets the 2nd value from the colorsTreeMap
        *  and prints it
        */
        try {
            System.out.println("Get the second value: "
                    + colorsTreeMap.get(2));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Check if the colorsTreeMap contains the String value
        *  "yellow" and returns true because it exists in the colorsTreeMap
        */
        try {
            System.out.println("Contains 'yellow': "
                    + colorsTreeMap.containsValue("yellow"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Checks if the colorsTreeMap contains a key of '3' 
        *  and returns true because there is a '3' as a key
        */
        try {
            System.out.println("Contains a key of '3': "
                    + colorsTreeMap.containsKey(3));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Replaces the second value 'red' from the colorsTreeMap with 'brown'
        try {
            colorsTreeMap.replace(2, "brown");
            System.out.println("Replace the second value: "
                    + colorsTreeMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        /* Nasty paths */

        /* Adds a key with a null value to the colorsTreeMap 
        *  and prints all the keys and values to make sure
        *  the new key with a null value was added
        */
        try {
            colorsTreeMap.put(5, null);
            System.out.println("Adds key with null value: "
                    + colorsTreeMap);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        /* Tries to add an null key and color value to the colorsTreeMap
        *  and throws a NullPointerException because it cannot have
        *  null key
        */
        try {
            System.out.println("Add a null key and color value to the TreeMap: "
                    +colorsTreeMap.put(null, "brown"));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        /* Gets a value from a key that does not exist in the colorsTreeMap.
        *  Returns null because there is not a 10th key
        */
        try {
            System.out.println("Get a value from a non-existing key: "
                    +colorsTreeMap.get(10));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        /* Tries to add a key and value that already exists in the colorsTreeMap.
        *  It doesn't add it because it cannot have duplicates
        */
        try {
            colorsTreeMap.put(1, "blue");
            System.out.println("Add a key and value that already exist: "
                    + colorsTreeMap);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        /* Tries to replace a null key with null value in the colorsTreeMap
        *  and throws a NullPointerException because there is not a null
        *  key because it cannot have null keys.
        */
        try {
            colorsTreeMap.replace(null, null);
            System.out.println("Replace a null key with null value: "
                    + colorsTreeMap);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        /* Tries to put null keys and values to the colorsTreeMap
        *  and throws a NullPointerException because it cannot have null keys
        */
        try {
            colorsTreeMap.putAll(null);
            System.out.println("Put non-existing Tree Map values to the TreeMap: "
                    + colorsTreeMap);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        /* Tries to remove a negative key and a key that is out of bounds.
        *  Returns null for both
        */
        try {
            System.out.println("Remove with negative int: "
                    + colorsTreeMap.remove(-1));
            System.out.println("Remove out of bounds: "
                    +  colorsTreeMap.remove(12));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
