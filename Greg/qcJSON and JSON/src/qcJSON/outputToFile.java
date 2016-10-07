package qcJSON;
import qcJSON.org.quickconnectfamily.json.*;

import java.io.*;
import java.util.*;


public class outputToFile {

    public static void main(String[] args) {

        // Happy Path - Write Object to command line
        Person greg = new Person(24, "4356555941", "Greg", "Hall");

        try {
            String jsonString = JSONUtilities.stringify(greg);
            System.out.println(jsonString);
        }catch(JSONException e)
        {
            e.printStackTrace();
        }

        // Happy Path - Write Object to file
        Person jon = new Person(24, "4356555941", "Jon", "Hall");

        File personFile = new File("personFile.json");

        try {
            FileOutputStream fileStream = new FileOutputStream(personFile);
            JSONOutputStream jsonOut = new JSONOutputStream(fileStream);
            jsonOut.writeObject(jon);
            jsonOut.close();

        }catch(Exception e)
        {
            e.printStackTrace();
        }

        // Happy Path - Read Object from file

        try {
            FileInputStream fileStream = new FileInputStream(personFile);
            JSONInputStream jsonIn = new JSONInputStream(fileStream);

            HashMap jsonMap = (HashMap)jsonIn.readObject();
            jsonIn.close();

            Person jackie = new Person();
            long age = (long)jsonMap.get("age");
            jackie.setAge((int)age);
            jackie.setPhone((String)jsonMap.get("phone"));
            jackie.setFirstName((String)jsonMap.get("firstName"));
            jackie.setLastName((String)jsonMap.get("lastName"));

            String jsonString1 =  JSONUtilities.stringify(jackie);
            System.out.println(jsonString1);


        }catch(Exception e)
        {
            e.printStackTrace();
        }

//        // Nasty Path - Read File without permissions

        try {
            FileInputStream fileStream = new FileInputStream("noPerm.json");
            JSONInputStream jsonIn = new JSONInputStream(fileStream);

            // Always close files.
            jsonIn.close();

        }catch(Exception e)
        {
            System.out.println("Error: Could not read file // Permission Denied");
        }


//        // Nasty Path - Write to File without permissions

        try {

            FileOutputStream fileStream = new FileOutputStream("noPerm.json");
            JSONOutputStream jsonOut = new JSONOutputStream(fileStream);
            jsonOut.writeObject(jon);
            jsonOut.close();

        }catch(Exception e)
        {
            System.out.println("Error: Could not write to file // Permission Denied");
        }



//        // Nasty Path - Read Image

        try {
            FileInputStream fileStream = new FileInputStream("img.jpg");
            JSONInputStream jsonIn = new JSONInputStream(fileStream);

            // Always close files.
            jsonIn.close();

        }catch(Exception e)
        {
            System.out.println("Error: Could not read file: IMG");
        }



        // Read object null

        try {
            FileInputStream fileStream = new FileInputStream("text.txt");
            JSONInputStream jsonIn = new JSONInputStream(fileStream);

            HashMap jsonMap = (HashMap)jsonIn.readObject();
            jsonIn.close();


        }catch(Exception e)
        {
            System.out.println("Error: Can't read NULL file/object");
        }

    }
}
