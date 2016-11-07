package JSON_QCJSON.src.json;

/**
 * Created by Victoria on 10.10.2016.
 */

import JSON_QCJSON.json.JSONException;
import JSON_QCJSON.json.JSONInputStream;
import JSON_QCJSON.json.JSONOutputStream;
import JSON_QCJSON.json.JSONUtilities;

import java.io.*;
import java.util.*;

public class JSONMainExample {
    public static void main(String[] args) {

        /* HAPPY PATH */
        // Writes an Object to command line (with json)
        // firstName, lastName, cardNumber, expiredDate
        JSONBankExample vicky = new JSONBankExample("Vicky", "Bond", "1234567890123456", "01/17");

        try {
            // Stores it in a string
            // Stringify takes any object and printed out/converts into json
            // object/string
            String js = JSONUtilities.stringify(vicky);
            // Prints the stringified string above
            System.out.println(js);
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }

        // Writes an Object (elijah) to file
        JSONBankExample elijah = new JSONBankExample("Elijah", "Kiva", "1234567890123457", "02/17");

        // File that I made bankTest.json
        File bankTest = new File("bankTest.json");

        try {
            // Creates FileOutputStream to the file
            FileOutputStream fos = new FileOutputStream(bankTest);
            // Needs to writes to json
            // Can be imported everywhere
            JSONOutputStream jos = new JSONOutputStream(fos);
            // write Object(elijah) out to the file
            jos.writeObject(elijah);
            // Close the string
            jos.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        // Reads an Object (back in) from file
        try {
            // Creates FileInputStream
            FileInputStream fis = new FileInputStream(bankTest);
            // Creates JSONInputStream
            JSONInputStream jis = new JSONInputStream(fis);

            // Creates HashMap, it reads in this libary back in
            // Object in json HashMap
            HashMap mapJson = (HashMap)jis.readObject();
            jis.close();

            // I can pull things
            // Creates new object
            // I have all things from json HashMap
            // I need to cast it each time I take it from my HashMap what I made above
            JSONBankExample elijah2 = new JSONBankExample();
            elijah2.setFirstName((String)mapJson.get("firstName"));
            elijah2.setLastName((String)mapJson.get("lastName"));
            elijah2.setCardNumber((String)mapJson.get("cardNumber"));
            elijah2.setExpiredDate((String)mapJson.get("expiredDate"));

            // Once I stringify object above, I can print it out
            String js1 =  JSONUtilities.stringify(elijah2);
            System.out.println(js1);


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        /* NASTY PATH */
        // Reads a File without permissions
        try {
            FileInputStream fis = new FileInputStream("withoutPermissions.json");
            JSONInputStream jis = new JSONInputStream(fis);

            jis.close();

        }
        catch(Exception e)
        {
            System.out.println("Unable to read file without permissions!");
        }

        // Writes to a File without permissions
        try {

            FileOutputStream fos = new FileOutputStream("withoutPermissions.json");
            JSONOutputStream jos = new JSONOutputStream(fos);
            jos.writeObject(elijah);
            jos.close();

        }
        catch(Exception e)
        {
            System.out.println("Unable to write file without permissions!");
        }



        // Reads an Image
        try {
            FileInputStream fis = new FileInputStream("readImage.jpg");
            JSONInputStream jis = new JSONInputStream(fis);

            jis.close();

        }
        catch(Exception e)
        {
            System.out.println("Unable to read an image!");
        }



        // Reads null object
        try {
            FileInputStream fis = new FileInputStream("readNull.txt");
            JSONInputStream jis = new JSONInputStream(fis);

            HashMap mapJson = (HashMap)jis.readObject();
            jis.close();


        }
        catch(Exception e)
        {
            System.out.println("Unable to read null object!");
        }



        // Not stringify object that does not exist,
        // and displays a null value
        try {
            // Does not stringify an object that does not exist and displays null.
            String notExisting = JSONUtilities.stringify(null);
            System.out.println("Not existing Object = " + notExisting);
        }
        catch (Exception e) {
            e.printStackTrace();
        }



        // Not stringify empty String
        try {
            String empty = JSONUtilities.stringify("");
            System.out.println("An empty String = " + empty);
        }
        catch (Exception e) {
            e.printStackTrace();
        }



        // Does not disassemble a negative integer string into an integer
        // and shows a NullPointerException
        try {
            int negative = Integer.parseInt("-5");
            System.out.println("Negative integer/string: " + negative);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}