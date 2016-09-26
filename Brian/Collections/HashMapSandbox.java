/**
 * Created by Brian on 09/23/2016.
 */
package Collections;
import java.util.ArrayList;
import java.util.HashMap;

public class HashMapSandbox {

    public static void main(String[] args) {

        // Creates a HashMap called animalHashMap.
        HashMap<Integer, String> animalHashMap = new HashMap<>();
        // Add keys and values to the animalHashMap
        animalHashMap.put(1, "dog");
        animalHashMap.put(2, "cat");
        animalHashMap.put(3, "dolphin");
        animalHashMap.put(4, "snake");

        // Creates a HashMap called colorHashMap.
        HashMap<Integer, String> colorHashMap = new HashMap<>();
        // Add keys and values to the colorHashMap.
        animalHashMap.put(7, "black");
        animalHashMap.put(8, "gray");
        animalHashMap.put(9, "white");
        animalHashMap.put(10, "brown");

        // Prints all values from the animalHashMap.
        System.out.println("Valid Hashmap: " + animalHashMap);

        // Creates arrayList called colorArrayList.
        ArrayList<String> colorArrayList = new ArrayList<>();

        /* Happy paths */

        // Add values to the colorArrayList.
        colorArrayList.add("brown");
        colorArrayList.add("gray");
        colorArrayList.add("black");
        colorArrayList.add("white");

        // Adds a new key and value
        try {
            animalHashMap.put(5, "elephant");
            // Prints all values including the new key and value added.
            System.out.println("Add a new key and value: "
                    + animalHashMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Gets the 3rd key and value
        try {
            System.out.println("Get the 3rd key and value: "
                    + animalHashMap.get(3));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Removes the 5th key and value
        try {
            animalHashMap.remove(5);
            System.out.println("Remove the 5th key and value: "
                    + animalHashMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Check if hashmap is empty and return false because
        // it is not empty
        try {
            System.out.println("Check if the hashmap is empty: "
                    + animalHashMap.isEmpty());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Contains '4' as a key
        // and returns true because '4' exists as a key and has value 'snake'
        try {
            System.out.println("Contains key 4: "
                    + animalHashMap.containsKey(4));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Contains 'cat' as value and returns true because there is a 'cat' value
        try {
            System.out.println("Contains value 'cat': "
                    + animalHashMap.containsValue("cat"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Replaces the first value with 'tiger'
        try {
            animalHashMap.replace(1, "dog", "tiger");
            System.out.println("Replace the first value: "
                    + animalHashMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Put all keys with each values from the
        // colorHashMap into the animalHashMap
        try {
            animalHashMap.putAll(colorHashMap);
            System.out.println("Put all keys and values from " +
                    "the colorHashMap to the animalHashMap: "
                    + animalHashMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Nasty paths */

        // Adds a null key and a null value
        try {
            animalHashMap.put(null, null);
            System.out.println("Add a null key with null value: "
                    + animalHashMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Adds a new key with a null value
        try {
            animalHashMap.put(6, null);
            System.out.println("Add a new key with a null value: "
                    + animalHashMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Adds a null key with a value
        try {
            animalHashMap.put(null, "bobcat");
            System.out.println("Add a null key with a value: "
                    + animalHashMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Removes a null key and null value
        // Does nothing because there is not a null key associated with a null value.
        try {
            animalHashMap.remove(null, null);
            System.out.println("Removed a null key and null value: "
                    + animalHashMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Remove a non-existing key with an empty value
        // Does nothing because there is not an empty value associated with the 9th key.
        try {
            animalHashMap.remove(9, "");
            System.out.println("Remove a non-existing key " +
                    "with an empty value: " + animalHashMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Remove a non-existing key with an empty value
        // Doesn't do anything because there is not a negative key associated with an empty value.
        try {
            animalHashMap.remove(-1, "");
            System.out.println("Remove a negative key with " +
                    "an empty value: " + animalHashMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Pull non existing hashmap keys and values into
        // the animalHashMap
        // Does not do anything
        // NullPointerException
        try {
            animalHashMap.putAll(null);
            System.out.println("Pull non existing hashmap keys " +
                    "and values into the animalHashMap: "
                    + animalHashMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
