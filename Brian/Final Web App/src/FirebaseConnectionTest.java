import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONUtilities;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;
/**
 * Created by Brian on 12/13/16.
 */
public class FirebaseConnectionTest {

    private URL url;
    private String apiKey;
    private String response = "";
    HashMap users = new HashMap();
    ArrayList<User> userList = new ArrayList<>();

    public void initialize() throws Exception {
        // API key for my web app project
        apiKey = "AIzaSyB4O5KNer7VY88AS30Z5F7eRCRf3xbX_s8";
    }

    public ArrayList<User> get() {

        try {
            url = new URL("https://test-75c56.firebaseio.com/Users.json");
            HttpURLConnection theConnection = (HttpURLConnection) url.openConnection();
            theConnection.setReadTimeout(15000);
            theConnection.setConnectTimeout(15000);
            theConnection.setRequestMethod("GET");
            theConnection.setDoInput(true);
            theConnection.setDoOutput(true);
            theConnection.setRequestProperty("Content-Type", "application/json");
            theConnection.setRequestProperty("Authorization", "key=" + apiKey);
            theConnection.connect();

            String responseMessage = theConnection.getResponseMessage();

            int responseCode = theConnection.getResponseCode();

            System.out.println(responseCode + " " + responseMessage);

            // Creates buffer reader and stores the input stream from the server
            BufferedReader inputBuffer = new BufferedReader(
                    new InputStreamReader(theConnection.getInputStream()));

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
            users = (HashMap) jsonIn.readObject();

            //ArrayList<String> keyList = new ArrayList<>();
            HashMap newHash = new HashMap();

            Iterator<Map.Entry<Integer, String>> iterator = users.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<Integer, String> entry = iterator.next();
                newHash = (HashMap) users.get(entry.getKey());

                User newContact = new User();
                newContact.setName(newHash.get("name").toString());
                newContact.setUsername(newHash.get("username").toString());
                newContact.setPassword(newHash.get("password").toString());
                newContact.setEmail(newHash.get("email").toString());
                userList.add(newContact);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }
}
