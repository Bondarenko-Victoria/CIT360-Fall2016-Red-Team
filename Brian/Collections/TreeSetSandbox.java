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
        
        // Adds values to the colorTreeSet.
        colorTreeSet.add("blue");
        colorTreeSet.add("red");
        colorTreeSet.add("yellow");
        colorTreeSet.add("orange");


        // Creates an arrayList called colorArrayList.
        ArrayList<String> colorArrayList = new ArrayList<>();

        // Add values to the colorArrayList.
        colorArrayList.add("brown");
        colorArrayList.add("gray");
        colorArrayList.add("black");
        colorArrayList.add("white");

        // Happy paths

        // Prints all the values from the colorTreeSet.
        System.out.println("Valid treeSet" + colorTreeSet);

        /* Looks for a specific string value 'yellow' 
        *  in the colorTreeSet and prints true because it exists
        */
        try{
            System.out.println("Yellow exists in the array list: "
                    + colorTreeSet.contains("yellow"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Get the last value from the colorTreeSet
        *  and prints 'yellow' which is the last value.
        */
        try{
            System.out.println("Get the last value from the tree set: "
                    + colorTreeSet.last());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Gets the first value from the tree set.
        *  and prints 'blue' which is the first value.
        */
        try{
            System.out.println("Get the first value from the tree set: "
                    + colorTreeSet.pollFirst());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Checks if the tree set is empty.
        *  and returns false because it is not empty.
        */
        try{
            System.out.println("Check if tree set is empty: "
                    + colorTreeSet.isEmpty());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Checks if the tree set contains 'black' as a string
        * value and returns false because 'black' doesn't exist.
        */
        try{
            System.out.println("Check if 'black' exists: "
                    + colorTreeSet.contains("black"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Nasty paths*/

        /* Tries to add a string value that already exists.
        *  It didn't add it because it cannot have duplicates.
        */
        try{
            System.out.println("Add color that already exists: "
                    + colorTreeSet.add("blue") + colorTreeSet);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Tries to remove a value that doesn't exist in the colorTreeSet
        *  and returns false because the string value
        *  'gray' doesn't exist.
        */
        try{
            System.out.println("Remove value that doesn't exist: "
                    + colorTreeSet.remove("gray"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Merges colorArrayList into the colorTreeSet
        *  and prints all the keys and values
        *  of the colorTreeSet which now includes the values
        *  from the colorArrayList.
        */
        try{
            colorTreeSet.addAll(colorArrayList);
            System.out.println("Merge : "
                    + colorTreeSet);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Removes all values of the colorArrayList from the colorTreeSet
        *  and prints the values to make sure the values that were merged 
        *  from the colorArrayList were removed from the colorTreeSet.
        */
        try{
            colorTreeSet.removeAll(colorArrayList);
            System.out.println("Remove all values of the " +
                    "colorArrayList from the colorTreeSet : "
                    + colorTreeSet);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Adds an empty string to the beginning of the colorTreeSet
        *  and prints all the values to make sure the empty string was
        *  added
        */
        try{
            colorTreeSet.add("");
            System.out.println("Add empty string to the tree set: "
                    + colorTreeSet);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Removes the empty string from the colorTreeSet and prints
        *  all the values to make sure the empty string was removed
        */
        try{
            colorTreeSet.remove("");
            System.out.println("Remove empty string to the tree set: "
                    + colorTreeSet);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Tries to add a null value to the tree set.
        *  Throws a NullPointerException because it cannot have
        *  null values
        */
        try {
            System.out.println("Add null to the tree set: "
                    + colorTreeSet.add(null));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Removes a null value from the tree set.
        *  and throws a NullPointerException because
        *  there is not a null value because it cannot have null values
        */
        try{
            System.out.println("Remove null value from the tree set: "
                    + colorTreeSet.remove(null));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Tries to add all null values to the colorTreeSet.
        *  and throws a NullPointerException because it cannot have null values
        */
        try{
            System.out.println("Add all values from a null tree set: "
                    + colorTreeSet.addAll(null));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Tries to remove all null values from the tree set
        *  and throws a NullPointerException because it doesn't have
        *  null values since it cannot have null values
        */
        try{
            System.out.println("Remove all null values from the tree set: "
                    + colorTreeSet.removeAll(null));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
