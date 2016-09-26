/**
 * Created by Brian on 09/23/2016.
 */
package Collections;
import java.util.ArrayList;

public class ArrayListSandbox {
    public static void main(String[] args) {

        // Array list of colors
        ArrayList<String> colorArrayList = new ArrayList<>();

        /* Happy paths */

        // Add values to the colorArrayList.
        colorArrayList.add("brown");
        colorArrayList.add("gray");
        colorArrayList.add("black");
        colorArrayList.add("white");

        System.out.println("Valid array list: "
                + colorArrayList);

        // Array list called animalArrayList
        ArrayList<String> animalArrayList = new ArrayList<>();

        // Add values to the animalArrayList
        animalArrayList.add("horse");
        animalArrayList.add("cat");
        animalArrayList.add("panther");
        animalArrayList.add("dog");


        // Find if a value exists in the colorArrayList.
        // It will print true because "white" exists in the colorArrayList.
        try{
            System.out.println("White exists in the " +
                    "array list: " + colorArrayList.contains("white"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Check if colorArrayList is empty.
        // It will print false because the colorArrayList is not empty.
        try{
            System.out.println("Check if colorArrayList " +
                    "is empty: " + colorArrayList.isEmpty());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Prints the 4th value from the colorArrayList which is "white"
        try{
            System.out.println("Get the 4th value from " +
                    "the colorArrayList: " + colorArrayList.get(3));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Loop through the colorArrayList and print each element
        // and print each element
        try{
            for (String colors : colorArrayList) {
                System.out.println("Color: " + colors);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Adds all values from the animalArrayList to the colorArrayList
        // and prints the animalArrayList values including the values added
        // from the colorArrayList array.
        try{
            colorArrayList.addAll(animalArrayList);;
            System.out.println("Add all values from the " +
                    "animalArrayList to the colorArrayList: "
                    + colorArrayList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Nasty Paths */

        // Add an empty value to the array list.
        // Adds a null value and then prints all values.
        try {
            colorArrayList.add(null);
            System.out.println("Add null value: "
                    + colorArrayList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Gets a value that does not exist in the array list.
        // IndexOutOfBoundsException
        try{
            colorArrayList.get(9);
            System.out.println("Get non-existing " +
                    "value: " + colorArrayList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Remove a null value from the array list.
        // Removes the null value and prints all the values from the colorArrayList.
        try{
            colorArrayList.remove(null);
            System.out.println("Removes the null " +
                    "value: " + colorArrayList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Removes a value from the array list with a negative integer.
        // Returns ArrayIndexOutOfBoundsException
        try{
            System.out.println("Removed value with " +
                    "negative integer: "
            + colorArrayList.remove(-1));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Remove all null values from the array list.
        // Returns NullPointerException
        try{
            colorArrayList.removeAll(null);
            System.out.println("Removes all null " +
                    "values: " + colorArrayList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Add null values to the end of the values of the colorArrayList.
        // Returns NullPointerException
        try{
            colorArrayList.addAll(null);
            System.out.println("Add all null " +
                    "values: " + colorArrayList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
