/**
 * Created by Brian on 09/20/2016.
 */

/* This program creates an object of a person that contains contact
*  information and it converts the string into a JSON string.
*  It also converts a JSON string that contains info for another person
*  into an instance of an object.
*/

import JavaBeans.PatientBean;
import org.quickconnectfamily.json.*;
import java.util.HashMap;


public class JSONSandbox {

    public static void main(String[] args)
            throws JSONException, ParseException {

        /* Create an instance of an object called aPerson that
        * has a name, id, date of birth, phone number,
        * street address, city, state, and zip code.
        */
        PatientBean aPatient = new PatientBean("Isaiah", "111-11-1111",
                "1978", "37", "123-456-7890");

        // JSON string with another person's contact
        String aPatientJSONString = "{\"name\":\"Bob\",\"SSN\":\"222-22-2222\"" +
                ",\"birthYear\":\"1970\",\"age\":\"62\",\"phone\":\"222-333-4000\"}";

        /* Create a hash map to store each key and value data from
        * a JSON string and saving each key and value as a string in
        * the hash map */
        HashMap aPatientMap = new HashMap();
        try {
            aPatientMap = (HashMap) JSONUtilities.parse(aPatientJSONString);
        } catch (org.quickconnectfamily.json.ParseException e) {
            e.printStackTrace();
        }
        String aName = (String)aPatientMap.get("name");
        String aSSN = (String)aPatientMap.get("SSN");
        String aBirthYear = (String)aPatientMap.get("birthYear");
        String patientAge = (String)aPatientMap.get("age");
        String aPhoneNumber = (String)aPatientMap.get("phone");

        /* Creates another instance of a person with parameters that will
        use each key and value from the hash map*/
        PatientBean anotherPerson = new PatientBean(aName, aSSN, aBirthYear,
                patientAge, aPhoneNumber);

        // Print the anotherPerson object with its values.
        System.out.println("Valid Patient bean JSON string " + anotherPerson);

        // Display the JSON string of the person.
        System.out.println("Valid JSON string = " + aPatientJSONString);

        try {
            /* Converts the string values from the aPerson object
            * into a JSON string */
            String ObjectJSONString = JSONUtilities.stringify(aPatient);
            // Prints the stringified string
            System.out.println("Valid patient bean = " + ObjectJSONString);
        }
        catch (Exception e){
            e.printStackTrace();
        }

            /* Nasty Paths*/
        try {
            // Does not stringify an object that does not exist and displays null.
            String NonExistingObject = JSONUtilities.stringify(null);
            System.out.println("Object does not exist = " + NonExistingObject);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // Does not stringify an empty string.
            String emptyString = JSONUtilities.stringify("");
            System.out.println("Empty string = " + emptyString);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // Does not stringify a negative integer.
            String negativeAge = JSONUtilities.stringify("-20");
            System.out.println("Negative age = " + negativeAge);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // Does not parse a negative integer string into an integer
            // and displays a null pointer exception.
            int negativePatientAge = Integer.parseInt("-62");
            System.out.println("Parsed negative age: " + negativePatientAge);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try {
            // Cannot parse an empty string into an integer and
            // displays a null format exception
            int emptyJSONStringAge = Integer.parseInt("");
            System.out.println("Null integer: " + emptyJSONStringAge);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // Cannot parse null to an integer and
            // displays a null format exception
            int emptyJSONStringAge = Integer.parseInt(null);
            System.out.println("Null integer: " + emptyJSONStringAge);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}


