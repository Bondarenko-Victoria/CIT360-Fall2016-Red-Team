package Collections;

import java.util.TreeMap;

public class TreeMapSand {
    public static void main(String[] args) {
        add();
        addDouble();
        nullKey();
        nullValue();
        anyType();
    }

    // Happy Path - Add to TreeMap
    public static void add()
    {
        try {
            TreeMap<String, Integer> map = new TreeMap();
            map.put("Five", 5);
            map.put("Six", 6);
            map.put("Seven", 7);
            map.put("Eight", 8);
            map.put("Nine", 9);
            map.put("Apple", 9);

            System.out.println(map);
        }catch(Exception e)
        {
            System.out.println("Error: Cant add");

        }
    }

    // Nasty Path - Add double key to TreeMap
    public static void addDouble()
    {
        try {
            TreeMap<String, Integer> map = new TreeMap();
            map.put("Apple", 9);
            map.put("Five", 5);
            map.put("Eight", 8);
            map.put("Nine", 9);
            map.put("Apple", 10);

            System.out.println("If you have 2 keys that are the same, the most recently added key will override the previously existing key and value");

            System.out.println(map);
        }catch(Exception e)
        {
            System.out.println("Error: Cant add two of same key");

        }
    }

    // Nasty Path - Add null key to TreeMap
    public static void nullKey()
    {
        try {
            TreeMap<String, Integer> map = new TreeMap();
            map.put(null, 9);
            map.put("Five", 5);
            map.put("Six", 6);
            map.put("Seven", 7);
            map.put("Eight", 8);
            map.put("Nine", 9);
            map.put("Apple", 9);


            System.out.println(map);
        }catch(Exception e)
        {
            System.out.println("Error: Cant have null as key");

        }
    }

    // Happy Path - Add double key to TreeMap
    public static void nullValue()
    {
        try {
            TreeMap<String, Integer> map = new TreeMap();
            map.put("Five", 5);
            map.put("Six", 6);
            map.put("Seven", 7);
            map.put("Eight", 8);
            map.put("Nine", null);
            map.put("Apple", 9);


            System.out.println(map);

        }catch(Exception e)
        {
            System.out.println("Error: Cant have null as value");

        }
    }


    // Happy & Nasty Path - No Type declare upon TreeMap creation
    public static void anyType()
    {
        // Happy Path - Key types
        try {
            // Key must be same type, value can be any type
            // rest of key's must be same type as first key type
            TreeMap map = new TreeMap();
            map.put("One", 1);
            map.put("Greg", 'G');
            map.put("A", 8);
            map.put("Test", 3.5);


            System.out.println(map);

        }catch(Exception e)
        {
            System.out.println("Error: Cant mix types");

        }

        // Nasty Path - Different Key types
        try {
            // Key as different type, value can be any type
            // rest of key's must be same type as first key type
            TreeMap map = new TreeMap();
            map.put(1 , 1);
            map.put("Greg", 'G');
            map.put(3.5, 8);
            map.put("Test", 3.5);

            System.out.println(map);

        }catch(Exception e)
        {
            System.out.println("Error: Cant mix key types");

        }
    }

}
