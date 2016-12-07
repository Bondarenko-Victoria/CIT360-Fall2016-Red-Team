package Firebase;


import AddressBook.Contact;
import qcJSON.json.JSONInputStream;
import qcJSON.json.JSONUtilities;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created by gvh574 on 12/3/2016.
 */
public class Firebase {
    private URL url;
    private String apiKey;
    private String response = "";
    HashMap contacts = new HashMap();
    ArrayList<Contact> addressBook = new ArrayList<>();

    public void initialize() throws Exception {
        apiKey = "AIzaSyBhsC7UnAIytRylacRaKF9FaZNimYSu4Hw";
    }

    public ArrayList<Contact> get() {

        try {
            url = new URL("https://addressbook-19c5d.firebaseio.com/Contacts.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "key=" + apiKey);
            conn.connect();

            String responseMessage = conn.getResponseMessage();
            int responseCode = conn.getResponseCode();
            System.out.println(responseCode + " " + responseMessage);


            // Creates buffer reader and stores the input stream from the server
            BufferedReader inputBuffer = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));


            // Saves the input stream from the server
            StringBuffer response = new StringBuffer();

            String input;

            // While input is not null, add to response
            while((input = inputBuffer.readLine()) != null) {
                response.append(input);
            }

            inputBuffer.close();

            byte[] bytes = response.toString().getBytes();
            InputStream inputStream = new ByteArrayInputStream(bytes);

            JSONInputStream jsonIn = new JSONInputStream(inputStream);
            contacts = (HashMap) jsonIn.readObject();


            ArrayList<String> keyList = new ArrayList<>();
            HashMap newHash = new HashMap();



            Iterator<Map.Entry<Integer, String>> iterator = contacts.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<Integer, String> entry = iterator.next();
                newHash = (HashMap) contacts.get(entry.getKey());

                Contact newContact = new Contact();
                newContact.setFirstName(newHash.get("firstName").toString());
                newContact.setLastName(newHash.get("lastName").toString());
                newContact.setPhoneNumber(newHash.get("phoneNumber").toString());
                newContact.setState(newHash.get("state").toString());
                newContact.setCity(newHash.get("city").toString());
                newContact.setStreet (newHash.get("street").toString());
                newContact.setZip(newHash.get("zip").toString());
                addressBook.add(newContact);
            }




        } catch (Exception e) {
            e.printStackTrace();
        }

        return addressBook;
    }


    public String post(Contact contact){
        {
            try {
                String name = contact.getFirstName().toLowerCase() + "-" + contact.getLastName().toLowerCase();
                url = new URL("https://addressbook-19c5d.firebaseio.com/Contacts/"+name+".json");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("PUT");
                conn.setDoInput(true);
                conn.setDoOutput(true);
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Authorization", "key=" + apiKey);
                conn.connect();


            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));


            String jsonContact = JSONUtilities.stringify(contact);
            writer.write(jsonContact);

            writer.flush();
            writer.close();
            os.close();
                String responseMessage = conn.getResponseMessage();
                int responseCode = conn.getResponseCode();
                System.out.println(responseCode + " " + responseMessage);


            } catch (Exception e) {
                e.printStackTrace();
            }

            return response;
        }
    }


    private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException{
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Map.Entry<String, String> entry : params.entrySet()){
            if (first)
                first = false;
            else
//                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
//            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        System.out.println(result);
        return result.toString();
    }
}

