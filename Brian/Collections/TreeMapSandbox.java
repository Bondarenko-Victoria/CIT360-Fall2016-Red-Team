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

        // Prints all the values of the colorsTreeMap
        System.out.println("Valid tree map"
                + colorsTreeMap);

        // Gets the first key from the the colorsTreeMap
        try {
            System.out.println("First key: "
                    + colorsTreeMap.firstKey());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Gets the first entry of the colorsTreeMap
        try {
            System.out.println("First entry: "
                    + colorsTreeMap.firstEntry());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Gets the 2nd value from the colorsTreeMap
        try {
            System.out.println("Get the second value: "
                    + colorsTreeMap.get(2));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Check if the colorsTreeMap contains "yellow"
        // and returns true because it exists in the colorsTreeMap
        try {
            System.out.println("Contains 'yellow': "
                    + colorsTreeMap.containsValue("yellow"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Contains a key of '3' in the colorsTreeMap
        // and returns true because there is a '3' as a key
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

        // Add a key with a null value adds a key with a null value
        // Added key with "null" as value.
        try {
            colorsTreeMap.put(5, null);
            System.out.println("Adds key with null value: "
                    + colorsTreeMap);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // Adds an null key and color value to the TreeMap
        // NullPointerException
        try {
            System.out.println("Add a null key and color value to the TreeMap: "
                    +colorsTreeMap.put(null, "brown"));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // Gets a value from a key that does not exist.
        // Returns null
        try {
            System.out.println("Get a value from a non-existing key: "
                    +colorsTreeMap.get(10));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // Add a key and value that already exist
        // Did not do anything because it cannot have duplicates
        try {
            colorsTreeMap.put(1, "blue");
            System.out.println("Add a key and value that already exist: "
                    + colorsTreeMap);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // Replace a null key with null value
        // NullPointerException
        try {
            colorsTreeMap.replace(null, null);
            System.out.println("Replace a null key with null value: "
                    + colorsTreeMap);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // Put non-existing Tree Map values to the TreeMap
        // NullPointerException
        try {
            colorsTreeMap.putAll(null);
            System.out.println("Put non-existing Tree Map values to the TreeMap: "
                    + colorsTreeMap);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // Remove a negative key and remove key and value out of bounds
        // Returns null for both
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
