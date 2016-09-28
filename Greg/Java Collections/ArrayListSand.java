package Collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListSand {

    public static void main(String[] args) {

        stringArrayList();
        stringArrayListNull();
        removeArrayListNull();
        addObject();
        remove();
        add();
        addNegIndex();
        listAnyType();

    }


    // Happy Path - assign strings to ArrayList
    public static void stringArrayList()
    {
        try {

            ArrayList<String> footballTeams = new ArrayList<>();
            footballTeams.add("New York Jets");
            footballTeams.add("Tampa Bay Buccaneers");
            footballTeams.add("New England Patriots");

            for (String object : footballTeams) {
                System.out.println(object);
            }
        }catch (Exception e)
        {
            System.out.println("Error Printing Teams");
            e.fillInStackTrace();
        }

    }

    // Happy Path - assign strings to ArrayList with Null value
    public static void stringArrayListNull()
    {
        try {

            ArrayList<String> footballTeams = new ArrayList<>();
            footballTeams.add("Tampa Bay Buccaneers");
            footballTeams.add("New England Patriots");
            footballTeams.add(null);

            for (String object : footballTeams) {
                System.out.println(object);
            }
        }catch (Exception e)
        {
            System.out.println("Error Printing Teams");
            e.fillInStackTrace();
        }
    }

    // Happy Path - remove strings from ArrayList with Null value
    public static void removeArrayListNull()
    {
        try {
            System.out.println("\nBefore:");
            ArrayList<String> footballTeams = new ArrayList<>();
            footballTeams.add("Tampa Bay Buccaneers");
            footballTeams.add("New England Patriots");
            footballTeams.add(null);

            for (String object : footballTeams) {
                System.out.println(object);
            }

            System.out.println("\nAfter:");
            footballTeams.remove(null);

            for (String object : footballTeams) {
                System.out.println(object);
            }
        }catch (Exception e)
        {
            System.out.println("Error Printing Teams");
            e.fillInStackTrace();
        }
    }

    //Happy Path - Adding Object to ArrayList
    public static void  addObject()
    {
        System.out.println("\nObjects in Array List");
        Game PackersVsJets = new Game(45,"Home");
        Game PatriotsVsJets = new Game(12,"Away");

        // list hold any value

        //Change acceptable type to CollectionsSand.Game
        List<Game> footballTeams = new ArrayList<>();

        footballTeams.add(PackersVsJets);
        footballTeams.add(PatriotsVsJets);

        System.out.println("Packers score: " + footballTeams.get(0).gameScore);
        System.out.println("Game was " + footballTeams.get(0).where);
        System.out.println("Patriots score: " + footballTeams.get(1).gameScore);
        System.out.println("Game was " + footballTeams.get(1).where);
    }

    //Nasty Path - Remove something that doesn't exist
    public static void remove()
    {
        try {
            List<Game> game = new ArrayList<>();
            game.remove(0);
        }
        catch(Exception e)
        {
            System.out.println("Can't remove something that doesn't exist");
        }
    }

    //Nasty Path - Add to something that doesn't exist
    public static void add()
    {
        try {
            Game team = new Game();
            List<Game> game = new ArrayList<>();
            game.add(50, team);
        }
        catch(Exception e)
        {
            System.out.println("Can't add something to and index that doesn't exist ");
        }
    };

    //Nasty Path - Add something to negative index
    public static void addNegIndex()
    {
        try {
            Game negTeam = new Game();
            List<Game> negGame = new ArrayList<>();
            negGame.add(-1, negTeam);
        }
        catch(Exception e)
        {
            System.out.println("Can't add something to a negative index value");
        }
    }

    //Happy Path - List with various data types, no List Data Type given
    public static void listAnyType()
    {
        try {
            List anyType = new ArrayList<>();
            anyType.add(0, 2);
            anyType.add(1, "hello");

            System.out.println("Test: " + anyType.get(0));
            System.out.println("Test 2: " + anyType.get(1));
        }
        catch(Exception e)
        {
            System.out.println("Blah");
        }
    }


}
