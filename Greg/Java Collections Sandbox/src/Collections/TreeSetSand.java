package Collections;

import java.util.TreeSet;

public class TreeSetSand {
    public static void main(String[] args) {
        addToTreeSet();
        remove();
        contains();
        removeNon();
        addDouble();
        cloneTree();
        lastElement();
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

    // Nasty Path - Remove something that doesn't exist
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

    // Nasty Path - Adding Double. only keeps one
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

    // Happy Path - Clone a TreeSet
    public static void cloneTree()
    {
        try {
            TreeSet<String> tsInt = new TreeSet();
            tsInt.add("a");
            tsInt.add("b");
            tsInt.add("c");
            tsInt.add("d");

            TreeSet clone = (TreeSet)tsInt.clone();

            System.out.println("Print Clone of TreeSet");
            System.out.println(clone);
        }catch(Exception e)
        {
            System.out.println("Error: Cant mix up char and string types");

        }
    }

    // Happy Path - Return last element (usually highest)
    public static void lastElement()
    {
        try {
            TreeSet<Integer> tsInt = new TreeSet();
            tsInt.add(1);
            tsInt.add(10);
            tsInt.add(50);
            tsInt.add(99);

            System.out.println("Return last (highest) element of set");
            System.out.println(tsInt);
            System.out.println(tsInt.last());

        }catch(Exception e)
        {
            System.out.println("Error: Cant return last element");

        }
    }

}
