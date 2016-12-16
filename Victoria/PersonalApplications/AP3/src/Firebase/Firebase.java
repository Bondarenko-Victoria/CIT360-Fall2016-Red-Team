package Firebase;

import PersonalInformation.Contacts;
import qcJSON.json.*;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.*;
import java.util.*;

public class Firebase {
    private URL url;
    private String apiKey;
    private String response = "";
    HashMap contacts = new HashMap();
    ArrayList<Contacts> personalInformation = new ArrayList<>();

    public void initialize() throws Exception {
        apiKey = "AIzaSyCVhDOSdh9LSvEYiiut1o82mySdt6gUvHA";
    }

    public ArrayList<Contacts> get() {

        try {
            url = new URL("https://personalinformation-e7442.firebaseio.com/Contacts.json");
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


            // Creates BufferedReader
            // Stores the InputStream from the Server
            BufferedReader inputBuffer = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));


            // Saves the InputStream from the Server
            StringBuffer response = new StringBuffer();

            String input;

            // While "input" is not null, then add to response
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

                Contacts newContact = new Contacts();
                newContact.setFirstName(newHash.get("firstName").toString());
                newContact.setLastName(newHash.get("lastName").toString());
                newContact.setWeight(newHash.get("weight").toString());
                newContact.setHeight(newHash.get("height").toString());
                newContact.setAge(newHash.get("age").toString());
                personalInformation.add(newContact);
            }




        } catch (Exception e) {
            e.printStackTrace();
        }

        return personalInformation;
    }


    public String post(Contacts contacts){
        {
            try {
                String name = contacts.getFirstName().toLowerCase() + "-" + contacts.getLastName().toLowerCase();
                url = new URL("https://personalinformation-e7442.firebaseio.com/Contacts/"+name+".json");
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


                String jsonContact = JSONUtilities.stringify(contacts);
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


    private String getPostDataString(HashMap<String, String> params)
            throws UnsupportedEncodingException{
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Map.Entry<String, String> entry : params.entrySet()){
            if (first)
                first = false;
            else
                result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));

            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        System.out.println(result);
        return result.toString();
    }
}