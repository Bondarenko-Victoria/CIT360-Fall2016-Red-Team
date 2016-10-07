/**
 * Created by Brian on 10/07/2016.
 */

import JavaBeans.PatientBean;
import org.quickconnectfamily.json.*;
import org.quickconnectfamily.json.ParseException;
import java.io.*;
import java.util.HashMap;

public class QCJSONSandbox {

    public static void main(String[] args)
            throws JSONException, ParseException {

        /* Create an instance of an object called aPerson that
        * has a name, id, date of birth, phone number,
        * street address, city, state, and zip code.
        */
        PatientBean aPatient = new PatientBean("Sarah", "555-55-5555",
                "1991", "24", "123-444-7777");

        /* Happy paths */

        try {
            // Create a new json file called Patient
            File happyPatientList = new File("src/Patient.json");
            // Wraps happyPatientStream JSONOutputStream in the jsonOut FileOutputStream
            FileOutputStream happyPatientStream = new FileOutputStream(happyPatientList);
            JSONOutputStream happyJSONOut = new JSONOutputStream(happyPatientStream);
            // Writes a serializable Patient object to the Patient json file.
            happyJSONOut.writeObject(aPatient);
            happyJSONOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        /* Reads a JSON file called JeffPatientBean */
        try {
            // Create a FileInputSteam for the JeffPatientBean json file.
            FileInputStream objectFileStream = new FileInputStream("src/JeffPatientBean.json");
            JSONInputStream jeffIn = new JSONInputStream(objectFileStream);
            // Create a hash map and call the readObject method to read the object in a hash map.
            HashMap jeffHashMap = (HashMap)jeffIn.readObject();
            // Create a new patientBean using the hash map data.
            PatientBean jeffBean = new PatientBean(jeffHashMap);
            // call the toString method to convert the hash map into a string.
            jeffBean.toString();
            jeffIn.close();
            // Display jeffBean object.
            System.out.println(jeffBean);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.quickconnectfamily.json.ParseException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        // NASTY PATHS

        // Writing null to a JSON file called NullPatient does not write
        // anything, but it only creates an empty JSON file.
        try {
            // Create a new json file called NullPatient
            File nullPatientList = new File("src/NullPatient.json");
            // Wraps nullPatientStream JSONOutputStream in the nullJSONOut FileOutputStream
            FileOutputStream nullPatientStream = new FileOutputStream(nullPatientList);
            JSONOutputStream nullJSONOut = new JSONOutputStream(nullPatientStream);
            // Writes a null object to the NullPatient json file.
            nullJSONOut.writeObject(null);
            nullJSONOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Writing an empty string to a JSON file called EmptyStringPatient
        // writes an empty string to the new file created.
        try {
            // Create a new json file called EmptyStringPatient
            File emptyStringPatientList = new File("src/EmptyStringPatient.json");
            // Wraps emptyStreamPatientStream JSONOutputStream in the emptyStringJSONOut FileOutputStream
            FileOutputStream emptyStreamPatientStream = new FileOutputStream(emptyStringPatientList);
            JSONOutputStream emptyStringJSONOut = new JSONOutputStream(emptyStreamPatientStream);
            // Writes a serializable empty string to the EmptyStringPatient json file.
            emptyStringJSONOut.writeObject("");
            emptyStringJSONOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Try to write JSON to a file that you don't have write permissions to that file.
        // Permission denied FileNotFoundException
        try {
            // Wraps nullPatientStream JSONOutputStream in the nullJSONOut FileOutputStream
            // NOTE: I CREATED THE FILE IN MY DESKTOP BECAUSE I HAD ERRORS WHEN I PUT IT IN THE SRC FOLDER
            FileOutputStream forbiddenStream = new FileOutputStream("/Users/Brian/Desktop/ForbiddenJSON.json");
            JSONOutputStream happyJSONOut = new JSONOutputStream(forbiddenStream);
            // Writes a serializable Patient object to the Patient json file.
            happyJSONOut.writeObject(aPatient);
            happyJSONOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        /* Reads a text file called NotJSONPatientBean. Since the first line of text is a JSON string,
         * it reads that line and is displayed later. The other lines in the file are not JSON strings,
         * therefore, it does not read anything that is not a JSON string, so only the JSON string is
         * displayed */
        try {
            // Create a FileInputSteam for the NotJSONPatientBean text file.
            FileInputStream objectFileStream = new FileInputStream("src/NotJSONPatientBean.txt");
            JSONInputStream noJSONFileIn = new JSONInputStream(objectFileStream);
            // Create a hash map and call the readObject method to read the object in a hash map.
            HashMap txtFileHashMap = (HashMap)noJSONFileIn.readObject();
            // Create a new patientBean using the hash map data.
            PatientBean PeterBean = new PatientBean(txtFileHashMap);
            noJSONFileIn.close();
            // Display the data from PeterBean object.
            System.out.println(PeterBean);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.quickconnectfamily.json.ParseException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        // Try to read a file that you don't have read permissions to that file.
        // Permission denied FileNotFoundException
        try {
            // Create a FileInputSteam for the Forbidden text file.
            // NOTE: I CREATED THE FILE IN MY DESKTOP BECAUSE I HAD ERRORS WHEN I PUT IT IN THE SRC FOLDER
            FileInputStream objectFileStream = new FileInputStream("/Users/Brian/Desktop/ForbiddenJSON.json");
            JSONInputStream forbiddenFileIn = new JSONInputStream(objectFileStream);
            // Create a hash map and call the readObject method to read the object in a hash map.
            HashMap forbiddenFileHashMap = (HashMap)forbiddenFileIn.readObject();
            // Create a new patientBean using the hash map data.
            PatientBean JessicaBean = new PatientBean(forbiddenFileHashMap);
            forbiddenFileIn.close();
            // Display the data from PeterBean object.
            System.out.println(JessicaBean);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.quickconnectfamily.json.ParseException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
    }
}
