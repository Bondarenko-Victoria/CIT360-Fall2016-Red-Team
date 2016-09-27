/**
 * Created by Brian on 09/23/2016.
 */
package Collections;
import java.util.ArrayList;

public class ArrayListSandbox {
    public static void main(String[] args) {

        // ArrayList type String called colorArrayList.
        ArrayList<String> colorArrayList = new ArrayList<>();

        /* Happy paths */

        // Add values to the colorArrayList.
        colorArrayList.add("brown");
        colorArrayList.add("gray");
        colorArrayList.add("black");
        colorArrayList.add("white");

        /* Print the values from the colorArrayList to make sure 
        *  the values were added 
        */
        System.out.println("Valid array list: "
                + colorArrayList);

        // ArrayList type String called animalArrayList.
        ArrayList<String> animalArrayList = new ArrayList<>();

        // Add values to the animalArrayList
        animalArrayList.add("horse");
        animalArrayList.add("cat");
        animalArrayList.add("panther");
        animalArrayList.add("dog");


        /* Looks for a specific String exists in the colorArrayList.
        * It returns true because "white" is one of the string elements
        * in the colorArrayList.
        */
        try{
            System.out.println("White exists in the " +
                    "array list: " + colorArrayList.contains("white"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Checks if colorArrayList is empty.
        * It retusn false because the colorArrayList is not empty.
        */
        try{
            System.out.println("Check if colorArrayList " +
                    "is empty: " + colorArrayList.isEmpty());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Prints the 4th element from the colorArrayList which is "white"
        try{
            System.out.println("Get the 4th value from " +
                    "the colorArrayList: " + colorArrayList.get(3));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Loops through the colorArrayList and print each element
        try{
            for (String colors : colorArrayList) {
                System.out.println("Color: " + colors);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Adds all the elements from the animalArrayList into the colorArrayList
        * and then prints the animalArrayList elements including the new elements 
        * added from the colorArrayList
        */
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

        /* Adds an null as a new element to the colorArrayList
        *  and then prints all the elements
        */
        try {
            colorArrayList.add(null);
            System.out.println("Add null value: "
                    + colorArrayList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Tries to get a value that does not exist in the colorArrayList
        *  and throws an IndexOutOfBoundsException because there
        *  is not a 9th index or element in the arrayList. There 
        *  are only 8 elements
        */
        try{
            colorArrayList.get(9);
            System.out.println("Get non-existing " +
                    "value: " + colorArrayList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Tries to remove a null value from the array list.
        *  Removes the null value that is in the arrayList since
        *  a null was added as a new element before, and then 
        *  prints all the elements from the colorArrayList to make sure
        *  the null was removed.
        */
        try{
            colorArrayList.remove(null);
            System.out.println("Removes the null " +
                    "value: " + colorArrayList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Tries to remove an element from the colorArrayList with a negative index.
        *  It throws an ArrayIndexOutOfBoundsException because it's out of
        *  range since you cannot have a negative index only positive indexes.
        */
        try{
            System.out.println("Removed value with " +
                    "negative integer: "
            + colorArrayList.remove(-1));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Tries to remove all the null elements from the colorArrayList
        *  It throws a NullPointerException because there are no
        *  more null elements in the colorArrayList
        */
        try{
            colorArrayList.removeAll(null);
            System.out.println("Removes all null " +
                    "values: " + colorArrayList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        /* Tries to add null values to the end of the elements of the 
        *  colorArrayList and then throws a NullPointerException because
        *  it is not possible to add all null elements because it does not
        *  know where to put them
        */
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
