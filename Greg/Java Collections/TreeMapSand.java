package Collections;

import java.util.TreeMap;

public class TreeMapSand {
    public static void main(String[] args) {
        add();
        addDouble();
        nullKey();
        nullValue();
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

    // Happy Path - Add double key to TreeMap
    public static void addDouble()
    {
        try {
            TreeMap<String, Integer> map = new TreeMap();
            map.put("Apple", 9);
            map.put("Five", 5);
            map.put("Eight", 8);
            map.put("Nine", 9);
            map.put("Apple", 9);


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

}
