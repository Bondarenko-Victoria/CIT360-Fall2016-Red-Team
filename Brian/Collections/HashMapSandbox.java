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
        
        // Adds keys and values to the animalHashMap
        animalHashMap.put(1, "dog");
        animalHashMap.put(2, "cat");
        animalHashMap.put(3, "dolphin");
        animalHashMap.put(4, "snake");

        // Creates a HashMap called colorHashMap.
        HashMap<Integer, String> colorHashMap = new HashMap<>();
        
        // Adds keys and values to the colorHashMap.
        animalHashMap.put(7, "black");
        animalHashMap.put(8, "gray");
        animalHashMap.put(9, "white");
        animalHashMap.put(10, "brown");

        /* Prints all the keys with their respective values 
        *from the animalHashMap.
        */
        System.out.println("Valid Hashmap: " + animalHashMap);

        // Creates an arrayList called colorArrayList.
        ArrayList<String> colorArrayList = new ArrayList<>();

        /* Happy paths */

        // Adds values to the colorArrayList.
        colorArrayList.add("brown");
        colorArrayList.add("gray");
        colorArrayList.add("black");
        colorArrayList.add("white");

        /* Adds a new key and value to the animalHashMap
        *  and prints all the keys and values 
        */
        try {
            animalHashMap.put(5, "elephant");
            // Prints all values including the new key and value added.
            System.out.println("Add a new key and value: "
                    + animalHashMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Gets the 3rd key and value and prints it
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

        /* Checks if the animalHashMap is empty and return false because
        * it is not empty
        */
        try {
            System.out.println("Check if the hashmap is empty: "
                    + animalHashMap.isEmpty());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Looks for a fourth key in the animalHashMap
        * and returns true because '4' exists as a key and has value 'snake'
        */
        try {
            System.out.println("Contains key 4: "
                    + animalHashMap.containsKey(4));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Looks for a specific value in the animalHashMap 
        *  and returns true because there is a 'cat' value
        */
        try {
            System.out.println("Contains value 'cat': "
                    + animalHashMap.containsValue("cat"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Replaces the first value 'dog' with 'tiger'
        *  and prints all the keys and values to make sure
        *  'dog' was replaced with 'tiger'
        */
        try {
            animalHashMap.replace(1, "dog", "tiger");
            System.out.println("Replace the first value: "
                    + animalHashMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Puts all the values from the colorHashMap into the 
        *  animalHashMap and prints all the keys and values
        *  from the animalHashMap to make sure the values from the
        *  colorHashMap were added to the animalHashMap
        */
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

        /* Adds a null key and a null value to the animalHashMap 
        *  and prints all the keys and values to make sure the new
        *  key with its value was added
        */
        try {
            animalHashMap.put(null, null);
            System.out.println("Add a null key with null value: "
                    + animalHashMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Adds a new key with a null value to the animalHashMap
        *  and prints all they keys and values to make sure
        *  the new key with a null value was added
        */
        try {
            animalHashMap.put(6, null);
            System.out.println("Add a new key with a null value: "
                    + animalHashMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Adds a null key with a value and prints all the 
        *  keys and values to make sure the key with its value
        *  was added
        */
        try {
            animalHashMap.put(null, "bobcat");
            System.out.println("Add a null key with a value: "
                    + animalHashMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Tries to remove a null key and null value.
        *  It doesn't remove it because there is not a null key 
        *  associated with a null value.
        */
        try {
            animalHashMap.remove(null, null);
            System.out.println("Removed a null key and null value: "
                    + animalHashMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Tries to remove a non-existing key with an empty value.
        *  It doesn't remove it because there is not an empty value 
        *  associated with the 9th key.
        */
        try {
            animalHashMap.remove(9, "");
            System.out.println("Remove a non-existing key " +
                    "with an empty value: " + animalHashMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Tries to remove a non-existing key with an empty value.
        *  It doesn't remove it because there is not a negative key 
        *  associated with an empty value.
        */
        try {
            animalHashMap.remove(-1, "");
            System.out.println("Remove a negative key with " +
                    "an empty value: " + animalHashMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Tries to put non existing hashmap keys and values into
        * the animalHashMap. It doesn't add them and throws a NullPointerException
        * because it doesn't know what to do and where to add the nulls.
        */
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
