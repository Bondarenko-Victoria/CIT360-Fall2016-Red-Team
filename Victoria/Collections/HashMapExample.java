package Collections;

/**
 * Created by Victoria on 26.09.2016.
 */

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapExample {

    public static void main(String[] args) {

        // Creates a HashMap of "relatives".
        HashMap<Integer, String> relatives = new HashMap<>();

        // Add keys and values to the "relatives" HashMap.
        relatives.put(1, "grand grandfather");
        relatives.put(2, "grandfather");
        relatives.put(3, "father");
        relatives.put(4, "son");

        // Creates a HashMap of "ordinalNumbers".
        HashMap<Integer, String> ordinalNumbers = new HashMap<>();

        // Add keys and values to the "ordinalNumbers" HashMap.
        ordinalNumbers.put(11, "second");
        ordinalNumbers.put(12, "first");
        ordinalNumbers.put(13, "fourth");
        ordinalNumbers.put(14, "third");

        // Prints all keys and values from the "relatives" HashMap.
        System.out.println("Here is valid HashMap: " + relatives);

        // Creates ArrayList of the "ordinalNumbersArrayList".
        ArrayList<String> ordinalNumbersArrayList = new ArrayList<>();

        /* HAPPY PATHS */

        // Add values to the "ordinalNumbersArrayList".
        ordinalNumbersArrayList.add("first");
        ordinalNumbersArrayList.add("second");
        ordinalNumbersArrayList.add("third");
        ordinalNumbersArrayList.add("fourth");

        // Adds a new key and value to the "relatives" HashMap.
        try {
            relatives.put(5, "daughter");
            // Prints all keys and values form the "relatives"
            // including the new key and value that was added.
            System.out.println("Adds a new key and value to " +
                    "the \"relatives\" HashMap: "
                    + relatives);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Gets the 2nd key and value from the "relatives" and prints it.
        try {
            System.out.println("Gets the 2nd key and value from " +
                    "the \"relatives\" HashMap: "
                    + relatives.get(2));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Removes the 4th key and value from the "relatives" and prints it.
        try {
            relatives.remove(4);
            System.out.println("Removes the 4th key and value from " +
                    "the \"relatives\" HashMap: "
                    + relatives);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Verifies if the "relatives" HashMap is empty.
        // It return false because it is not empty.
        try {
            System.out.println("Verifies if the \"relatives\" " +
                    "HashMap is empty: "
                    + relatives.isEmpty());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Contains "3" as a key.
        // and returns true since "3" is as a key and has value "father".
        try {
            System.out.println("Contains a key \"3\": "
                    + relatives.containsKey(3));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Contains "grandfather" as value and returns true since
        // there is a "grandfather" value in the "relatives" HashMap.
        try {
            System.out.println("Contains value \"grandfather\": "
                    + relatives.containsValue("grandfather"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Replaces the first value with "grand grandfather".
        // Prints all the keys and values from the "relatives" HashMap.
        // "grand grandfather" was replaced by "grand grandmother".
        try {
            relatives.replace(1, "grand grandfather", "grand grandmother");
            System.out.println("Replaces the first value in the " +
                    "\"relatives\" HashMap: "
                    + relatives);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Puts all keys with each values from the "ordinalNumbers"
        // into the "relatives".
        // Prints all the keys and values from the "relatives" HashMap.
        // The keys and values from the "ordinalNumbers" were added.
        try {
            relatives.putAll(ordinalNumbers);
            System.out.println("Puts all keys and values from " +
                    "the \"ordinalNumbers\" to the \"relatives\": "
                    + relatives);
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        /* NASTY PATHS */

        // Adds a null key and a null value to the "relatives" HashMap.
        // Prints all the keys and values.
        try {
            relatives.put(null, null);
            System.out.println("Adds a null key with null value to the " +
                    "\"relatives\" HashMap: "
                    + relatives);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Adds a new key with a null value to the "relatives" HashMap.
        // Prints all the keys and values.
        try {
            relatives.put(7, null);
            System.out.println("Adds a new key with a null value to " +
                    "the \"relatives\" HashMap: "
                    + relatives);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Adds a null key with a value to the "relatives" HashMap.
        // Prints all the keys and values.
        try {
            relatives.put(null, "mother");
            System.out.println("Adds a null key with a value to " +
                    "the \"relatives\" HashMap: "
                    + relatives);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Removes a null key and null value from the "relatives" HashMap.
        // Does nothing because there is not a null key associated with a null value.
        try {
            relatives.remove(null, null);
            System.out.println("Removes a null key and null value from " +
                    "the \"relatives\" HashMap: "
                    + relatives);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Removes a non-existing key with an empty value from the "relatives" HashMap.
        // Does nothing because there is not an empty value associated with the 10th key.
        try {
            relatives.remove(10, "");
            System.out.println("Removes a non-existing key " +
                    "with an empty value from the \"relatives\" " +
                    "HashMap: " + relatives);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Removes a non-existing key with an empty value.
        // Doesn't do anything because there is not a negative key
        // associated with an empty value.
        // Also there is no negative keys existing.
        try {
            relatives.remove(-5, "");
            System.out.println("Removes a negative key with " +
                    "an empty value from the \"relatives\" " +
                    "HashMap: " + relatives);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Pulls non-existing HashMap keys and values into the "relatives".
        // It does not do anything.
        // Throws NullPointerException.
        // It doesn't know where to add all nulls.
        try {
            relatives.putAll(null);
            System.out.println("Pulls non-existing HashMap keys " +
                    "and values into the \"relatives\" HashMap: "
                    + relatives);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}