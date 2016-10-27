package Collections;

/**
 * Created by Victoria on 26.09.2016.
 */

import java.util.ArrayList;
import java.util.TreeSet;

public class TreeSetExample {

    public static void main (String[] args) {

        // Creates a TreeSet of "ordinalNumbers".
        TreeSet<String> ordinalNumbers = new TreeSet<>();

        // Adds values to the "ordinalNumbers" TreeSet.
        ordinalNumbers.add("first");
        ordinalNumbers.add("second");
        ordinalNumbers.add("third");
        ordinalNumbers.add("fourth");

        // Creates an ArrayList of "ordinalNumbersArrayList".
        ArrayList<String> ordinalNumbersArrayList = new ArrayList<>();


        /* HAPPY PATHS */

        // Adds values to the "ordinalNumbersArrayList".
        ordinalNumbersArrayList.add("second");
        ordinalNumbersArrayList.add("first");
        ordinalNumbersArrayList.add("fourth");
        ordinalNumbersArrayList.add("third");

        // Prints all the values from the "ordinalNumbers".
        System.out.println("Here is a valid TreeSet" + ordinalNumbers);

        // Finds if "second" exists in the TreeSet
        // and returns true because it exists.
        try{
            System.out.println("\"Second\" exists in the TreeSet: "
                    + ordinalNumbers.contains("second"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Gets the last value from the TreeSet.
        // It returns "fourth" which is the last value.
        try{
            System.out.println("Gets the last value from the TreeSet: "
                    + ordinalNumbers.last());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Gets the first value from the "ordinalNumbers".
        // It returns "first" which is the first value.
        try{
            System.out.println("Gets the first value from the TreeSet: "
                    + ordinalNumbers.pollFirst());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Checks if the TreeSet is empty.
        // It returns false since it is not empty.
        try{
            System.out.println("Checks if the \"ordinalNumbers\" is empty: "
                    + ordinalNumbers.isEmpty());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Checks is the TreeSet contains "seventh".
        // It returns false since "seventh" doesn't exist.
        try{
            System.out.println("Check if \"seventh\" exists: "
                    + ordinalNumbers.contains("seventh"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        /* NASTY PATHS */

        // Adds a number that already exists.
        // Did not do anything since it cannot have duplicates.
        try{
            System.out.println("Adds a number that already exists: "
                    + ordinalNumbers.add("fourth") + ordinalNumbers);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Removes a value that doesn't exist.
        // It returns false.
        try{
            System.out.println("Removes a value that doesn't exist: "
                    + ordinalNumbers.remove("sixth"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Merges "ordinalNumbersArrayList" into the "ordinalNumbers" TreeSet.
        // Prints all the keys and values since "ordinalNumbersArrayList"  is a
        // part of the "ordinalNumbers" TreeSet.
        try{
            ordinalNumbers.addAll(ordinalNumbersArrayList);
            System.out.println("Merges : "
                    + ordinalNumbers);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Removes all values of the "ordinalNumbersArrayList" from the "ordinalNumbers".
        // Prints the values.
        try{
            ordinalNumbers.removeAll(ordinalNumbersArrayList);
            System.out.println("Removes all values of the " +
                    "\"ordinalNumbersArrayList\" from the \"ordinalNumbers\" : "
                    + ordinalNumbers);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Adds empty string to the TreeSet.
        // Prints all the values.
        try{
            ordinalNumbers.add("");
            System.out.println("Adds empty string to the TreeSet: "
                    + ordinalNumbers);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Removes empty string from the TreeSet.
        // Prints all the values.
        try{
            ordinalNumbers.remove("");
            System.out.println("Removes empty string from the TreeSet: "
                    + ordinalNumbers);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Adds a null value to the TreeSet.
        // It throws NullPointerException (cannot have null values).
        try {
            System.out.println("Adds null value to the TreeSet: "
                    + ordinalNumbers.add(null));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Removes null value from the TreeSet.
        // It throws NullPointerException (cannot have null values).
        try{
            System.out.println("Removes null value from the TreeSet: "
                    + ordinalNumbers.remove(null));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Adds all null values to the TreeSet of "ordinalNumbers".
        // It throws NullPointerException (cannot have null values).
        try{
            System.out.println("Adds all values to the TreeSet: "
                    + ordinalNumbers.addAll(null));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Removes all null values from the TreeSet.
        // It throws NullPointerException (cannot have null values).
        try{
            System.out.println("Removes all null values from the TreeSet: "
                    + ordinalNumbers.removeAll(null));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}