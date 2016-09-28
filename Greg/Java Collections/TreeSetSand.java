package Collections;

import java.util.TreeSet;

public class TreeSetSand {
    public static void main(String[] args) {
        addToTreeSet();
        remove();
        contains();
        removeNon();
        addDouble();
    }

    public static void addToTreeSet()
    {
        //String TreeSet
        TreeSet<String> ts = new TreeSet();

        // Add elements to the tree set
        ts.add("Z");
        ts.add("K");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");

        // Add special characters
        ts.add("*");
        ts.add("≤");
        ts.add("ª");

        System.out.println(ts);

        //Integer TreeSet
        TreeSet<Integer> tsInt = new TreeSet();
        tsInt.add(1);
        tsInt.add(4);
        tsInt.add(8);
        tsInt.add(5);

        System.out.println(tsInt);

        //addALL TreeSet Function
        TreeSet<String> addMe = new TreeSet();
        addMe.addAll(ts);


    }

    // Happy Path - Remove from TreeSet
    public static void remove()
    {
        TreeSet<Integer> tsInt = new TreeSet();
        tsInt.add(1);
        tsInt.add(4);
        tsInt.add(8);
        tsInt.add(5);

        tsInt.remove(8);

        System.out.println(tsInt);
    }

    // Happy Path - Does the Set contain a value
    public static void contains()
    {
        TreeSet<Integer> tsInt = new TreeSet();
        tsInt.add(4);
        tsInt.add(8);
        tsInt.add(5);

        System.out.println(tsInt.contains(8));
    }

    // Happy Path - Remove something that doesnt exist
    public static void removeNon()
    {
        try {
            TreeSet<Integer> tsInt = new TreeSet();
            tsInt.add(4);
            tsInt.add(8);
            tsInt.add(5);
            tsInt.remove(1);

            System.out.println(tsInt);
        }catch(Exception e)
        {
            System.out.println("Error: Cant remove something that doesn't exist");

        }
    }

    // Happy Path - Adding Double. only keeps one
    public static void addDouble()
    {
        try {
            TreeSet<Integer> tsInt = new TreeSet();
            tsInt.add(4);
            tsInt.add(8);
            tsInt.add(5);
            tsInt.add(8);

            System.out.println(tsInt);
        }catch(Exception e)
        {
            System.out.println("Error: Cant add something that already exists");

        }
    }
}
