package Collections;

/**
 * Created by Victoria on 26.09.2016.
 */

import java.util.ArrayList;
import java.util.TreeMap;

public class TreeMapExample {

    public static void main(String[] args) {

        // Creates a TreeMap of "ordinalNumbers".
        TreeMap<Integer,String> ordinalNumbers = new TreeMap<Integer, String>();

        // Adds keys and values to the "ordinalNumbers" TreeMap.
        ordinalNumbers.put(1, "first");
        ordinalNumbers.put(2, "second");
        ordinalNumbers.put(3, "third");
        ordinalNumbers.put(4, "fourth");

        // Creates an ArrayList of "ordinalNumbersArrayList".
        ArrayList<String> ordinalNumbersArrayList = new ArrayList<>();

        /* HAPPY PATHS */

        // Adds values to the "ordinalNumbersArrayList".
        ordinalNumbersArrayList.add("second");
        ordinalNumbersArrayList.add("first");
        ordinalNumbersArrayList.add("fourth");
        ordinalNumbersArrayList.add("third");

        // Prints all the values of the "ordinalNumbers".
        System.out.println("Here is a valid TreeMap: "
                + ordinalNumbers);

        // Gets the first key from the the "ordinalNumbers".
        // Prints it.
        try {
            System.out.println("The first key from the \"ordinalNumbers\": "
                    + ordinalNumbers.firstKey());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Gets the first key and value of the "ordinalNumbers".
        // Prints it.
        try {
            System.out.println("The first key and value from " +
                    "the \"ordinalNumbers\": "
                    + ordinalNumbers.firstEntry());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Gets the 3rd value from the "ordinalNumbers".
        // Prints it.
        try {
            System.out.println("Gets the 3rd value from the \"ordinalNumbers\": "
                    + ordinalNumbers.get(3));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Verifies if the "ordinalNumbers" contains "second"
        // and it returns true since it exists in the "ordinalNumbers".
        try {
            System.out.println("The \"ordinalNumbers\" contains \"second\": "
                    + ordinalNumbers.containsValue("second"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Verifies if the "ordinalNumbers" contains a key of "4" in the ordinalNumbers
        // and it returns true since there is a "4" as a key.
        try {
            System.out.println("The \"ordinalNumbers\" contains a key of \"4\": "
                    + ordinalNumbers.containsKey(4));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Replaces the 3rd value "third" from the "ordinalNumbers" with "sixth".
        try {
            ordinalNumbers.replace(3, "sixth");
            System.out.println("Replaces the 3rd value with \"sixth\": "
                    + ordinalNumbers);
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        /* NASTY PATHS */

        // Adds a key with a null value to the "ordinalNumbers".
        // Prints it.
        try {
            ordinalNumbers.put(6, null);
            System.out.println("Adds key with null value to " +
                    "the \"ordinalNumbers\": "
                    + ordinalNumbers);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // Adds the null key and number value to the "ordinalNumbers".
        // It throws NullPointerException (cannot have null key).
        try {
            System.out.println("Adds a null key and number value to the" +
                    " \"ordinalNumbers\": "
                    + ordinalNumbers.put(null, "seventh"));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // Gets a value from a non-existing key.
        // Returns null.
        try {
            System.out.println("Gets a value that does not exist " +
                    "in the \"ordinalNumbers\": "
                    + ordinalNumbers.get(15));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // Adds a key and value that already exist.
        // Did not do anything because it cannot have duplicates.
        try {
            ordinalNumbers.put(1, "first");
            System.out.println("Adds a key and value that already exist " +
                    "to the \"ordinalNumbers\": "
                    + ordinalNumbers);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // Replaces a null key with null value.
        // It throws NullPointerException (cannot have null keys).
        try {
            ordinalNumbers.replace(null, null);
            System.out.println("Replaces a null key with null value " +
                    "in the \"ordinalNumbers\": "
                    + ordinalNumbers);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // Puts the null keys and values to the "ordinalNumbers".
        // It throws NullPointerException (cannot have null keys).
        try {
            ordinalNumbers.putAll(null);
            System.out.println("Puts the null keys and values to the" +
                    " \"ordinalNumbers\": "
                    + ordinalNumbers);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // Removes a negative key.
        // Removes a key and value that out of bounds.
        // Returns null for both of them.
        try {
            System.out.println("Removes with negative key: "
                    + ordinalNumbers.remove(-5));
            System.out.println("Removes a key and value that out of bounds: "
                    +  ordinalNumbers.remove(15));
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}