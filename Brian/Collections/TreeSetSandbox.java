/**
 * Created by Brian on 09/23/2016.
 */
package Collections;
import java.util.ArrayList;
import java.util.TreeSet;

public class TreeSetSandbox {
    public static void main (String[] args) {

        // Creates a tree set called colorTreeSet
        TreeSet<String> colorTreeSet = new TreeSet<>();
        // Adds values to the tree set.
        colorTreeSet.add("blue");
        colorTreeSet.add("red");
        colorTreeSet.add("yellow");
        colorTreeSet.add("orange");


        // Creates array called colorArrayList.
        ArrayList<String> colorArrayList = new ArrayList<>();

        /* Happy paths */

        // Add values to the colorArrayList.
        colorArrayList.add("brown");
        colorArrayList.add("gray");
        colorArrayList.add("black");
        colorArrayList.add("white");

        // Happy path

        // Prints all the values from the colorTreeSet.
        System.out.println("Valid treeSet" + colorTreeSet);

        // Find if 'yellow' exists in the tree set
        // and returns true because it exists
        try{
            System.out.println("Yellow exists in the array list: "
                    + colorTreeSet.contains("yellow"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Get the last value from the tree set.
        // and returns 'yellow' which is the last value.
        try{
            System.out.println("Get the last value from the tree set: "
                    + colorTreeSet.last());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Get the first value from the tree set.
        // and returns 'blue' which is the first value.
        try{
            System.out.println("Get the first value from the tree set: "
                    + colorTreeSet.pollFirst());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Check if the tree set is empty.
        // and returns false because it is not empty.
        try{
            System.out.println("Check if tree set is empty: "
                    + colorTreeSet.isEmpty());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Check is the tree set contains 'black'
        // and returns false because 'black' doesn't exist.
        try{
            System.out.println("Check if 'black' exists: "
                    + colorTreeSet.contains("black"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Nasty paths*/

        // Add color that already exists.
        // Did not do anything because it cannot have duplicates.
        try{
            System.out.println("Add color that already exists: "
                    + colorTreeSet.add("blue") + colorTreeSet);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Removes a value that doesn't exist
        // and returns false
        try{
            System.out.println("Remove value that doesn't exist: "
                    + colorTreeSet.remove("gray"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Merges colorArrayList into the TreeSet
        try{
            colorTreeSet.addAll(colorArrayList);
            System.out.println("Merge : "
                    + colorTreeSet);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Removes all values of the colorArrayList from the colorTreeSet
        try{
            colorTreeSet.removeAll(colorArrayList);
            System.out.println("Remove all values of the " +
                    "colorArrayList from the colorTreeSet : "
                    + colorTreeSet);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Nasty Paths */

        // Adds empty string to the tree set to the beginning.
        try{
            colorTreeSet.add("");
            System.out.println("Add empty string to the tree set: "
                    + colorTreeSet);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Removes empty string to the tree set.
        try{
            colorTreeSet.remove("");
            System.out.println("Remove empty string to the tree set: "
                    + colorTreeSet);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Adding a null value to the tree set.
        // NullPointerException
        try {
            System.out.println("Add null to the tree set: "
                    + colorTreeSet.add(null));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Remove null value from the tree set.
        // NullPointerException
        try{
            System.out.println("Remove null value from the tree set: "
                    + colorTreeSet.remove(null));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Add all values from an empty tree set to the colorTreeSet.\
        // NullPointerException
        try{
            System.out.println("Add all values from a null tree set: "
                    + colorTreeSet.addAll(null));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Remove all null values from the tree set
        // NullPointerException
        try{
            System.out.println("Remove all null values from the tree set: "
                    + colorTreeSet.removeAll(null));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
