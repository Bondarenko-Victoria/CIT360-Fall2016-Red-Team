package Collections;

/**
 * Created by Victoria on 26.09.2016.
 */

import java.util.ArrayList;

public class ArrayListExample {

    public static void main(String[] args) {

        // Creates ArrayList of "ordinalNumbers" with type of String.
        ArrayList<String> ordinalNumbers = new ArrayList<>();

        /* HAPPY PATHS */

        // Adds 4 values to the "ordinalNumbers" ArrayList.
        ordinalNumbers.add("first");
        ordinalNumbers.add("second");
        ordinalNumbers.add("third");
        ordinalNumbers.add("fourth");

        //Prints all values from the "ordinalNumbers" ArrayList.
        System.out.println("Here is valid ArrayList of ordinal numbers: "
                + ordinalNumbers);

        // Creates ArrayList of "relatives" with type of String.
        ArrayList<String> relatives = new ArrayList<>();

        // Adds values to the "relatives" ArrayList.
        relatives.add("grand grandfather");
        relatives.add("grandfather");
        relatives.add("father");
        relatives.add("son");

        // Find if a value exists in the "ordinalNumbers".
        // It will print true because "first" exists in the ordinalNumbers.
        try{
            System.out.println("First value exists in the " +
                    "\"ordinalNumbers\" ArrayList: " +
                    ordinalNumbers.contains("first"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Verifies if the "ordinalNumbers" ArrayList is empty.
        // It will print false because the "ordinalNumbers" is not empty.
        try{
            System.out.println("Checks if the \"ordinalNumbers\" " +
                    "is empty: " + ordinalNumbers.isEmpty());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Prints the 2nd value from the "ordinalNumbers" ArrayList
        // which is "second".
        try{
            System.out.println("Get the 2nd value from " +
                    "the \"ordinalNumbers\" ArrayList: " +
                    ordinalNumbers.get(1));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Loops through the "ordinalNumbers" ArrayList and
        // prints each element.
        try{
            for (String numbers : ordinalNumbers) {
                System.out.println("Ordinal numbers: " + numbers);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Adds all values from the "relatives" ArrayList to
        // the "ordinalNumbers"  ArrayList and
        // prints the "relatives" values including the values that were
        // added from the "ordinalNumbers" ArrayList.
        try{
            ordinalNumbers.addAll(relatives);
            System.out.println("Adds all values from the " +
                    "\"relatives\" ArrayList to the \"ordinalNumbers\"" +
                    "ArrayList: "
                    + relatives);
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        /* NASTY PATHS */

        // Adds an empty (null) value to the "ordinalNumbers" ArrayList.
        //  and then prints all values in the "ordinalNumbers" ArrayList.
        try {
            ordinalNumbers.add(null);
            System.out.println("Adds a null value to the " +
                    "\"ordinalNumbers\" ArrayList: "
                    + ordinalNumbers);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Gets a value that does not exist in the "ordinalNumbers" ArrayList.
        // and it throws an IndexOutOfBoundsException.
        // It is only 8 elements in our ArrayList.
        try{
            ordinalNumbers.get(15);
            System.out.println("Trying to get non-existing " +
                    "value in the \"ordinalNumbers\" ArrayList: " + ordinalNumbers);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Removes a null value from the "ordinalNumbers" ArrayList
        // and prints all the values from the "ordinalNumbers"
        // to see that the null was removed.
        try{
            ordinalNumbers.remove(null);
            System.out.println("Removes the null " +
                    "value from the \"ordinalNumbers\" ArrayList: " + ordinalNumbers);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Removes a value from the "ordinalNumbers" ArrayList with
        // a negative index.
        // Returns ArrayIndexOutOfBoundsException.
        // There is no negative indexes existing.
        try{
            System.out.println("Removes value with " +
                    "negative index: "
                    + ordinalNumbers.remove(-5));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Removes all null values from the "ordinalNumbers" ArrayList.
        // Returns NullPointerException since our ArrayList
        // doesn't have (or no more has) any null elements.
        try{
            ordinalNumbers.removeAll(null);
            System.out.println("Removes all null " +
                    "values from the \"ordinalNumbers\" " +
                    "ArrayList: " + ordinalNumbers);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Adds null values to the end of the elements  of the "ordinalNumbers" ArrayList.
        // Returns NullPointerException because it does not know where to put all of them.
        try{
            ordinalNumbers.addAll(null);
            System.out.println("Add all null " +
                    "values to the \"ordinalNumbers\" " +
                    "ArrayList: " + ordinalNumbers);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}