package Collections;

import java.util.Map;
import java.util.HashMap;

public class HashMapSand {
    public static void main(String[] args) {
        addHashMap();
        remove();
        removeNon();
        addObj();
        nullKey();
        nullValue();

    }

    // Happy Path - Adding Values
    public static void addHashMap()
    {
        try {
            Map game = new HashMap();
            game.put("Jets", "New York");
            game.put("Packers", "Green Bay");
            game.put("Broncos", "Denver");

            System.out.println("\n" + game);
        }
        catch (Exception e)
        {
            System.out.println("Error: Can't Add to HashMap");
        }
    }


    // Happy Path - Remove item
    public static void remove()
    {
        try {
            Map game = new HashMap();
            game.put("Jets", "Green Bay");
            game.remove("Jets");


            System.out.println("\n" + game);
        }
        catch (Exception e)
        {
            System.out.println("Error: Can't remove item");
        }
    }

    // Nasty Path - Remove item that doesn't exist
    public static void removeNon()
    {
        try {
            Map<String, Game> game = new HashMap<>();
            game.remove("Nothing");

        }
        catch (Exception e)
        {
            System.out.println("Error: Can't remove non-existent item");
        }
    }

    // Happy Path - Add Objects to Map - get map item by key
    public static void addObj()
    {
        try {
            Map<String, Game> game = new HashMap<>();
            game.put("Game1", new Game(50, "Home"));
            game.put("Game2", new Game(55, "Away"));
            game.put("Game3", new Game(0, "Home"));

            Game newGame;
            newGame = game.get("Game1");

            System.out.println("\n" + newGame.getWhere());
            System.out.println("\n" + game.get("Game2").getGameScore());
        }
        catch (Exception e)
        {
            System.out.println("Error: Can't remove non-existent item");
        }
    }


    // Nasty Path - Null Key & Empty String
    public static void nullKey()
    {
        try {
            Map game = new HashMap();
            game.put("Jets", "New York");
            game.put(null,"Green Bay");
            game.put("","Bay");

            System.out.println("\n" + game);
        }
        catch (Exception e)
        {
            System.out.println("Error: Can't Add Null to HashMap");
        }
    }

    // Nasty Path - Null Value & Empty String
    public static void nullValue()
    {
        try {
            Map game = new HashMap();
            game.put("Jets", "New York");
            game.put("Packers", null);
            game.put("Test", "");

            System.out.println("\n" + game);
        }
        catch (Exception e)
        {
            System.out.println("Error: Can't Add Null to HashMap");
        }
    }


}
