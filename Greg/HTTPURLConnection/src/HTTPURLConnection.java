import java.io.*;
import java.net.*;

/**
 * Created by gvh57 on 10/29/2016.
 */
public class HTTPURLConnection {

    // Stored uA (User Agent) to Mozilla 5.0
    private final String uA = "Mozilla/5.0";

    public static void main(String args[]) {
        // Creates an instance of the HTTPURLConnection Class
        HTTPURLConnection connect = new HTTPURLConnection();
        try {
            // Calls the go method
            connect.go();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void go() throws Exception{

        // URL of Bing search for "cheese"
        URL url = new URL("http://www.bing.com/search?q=cheese");

        // Opens a connection to the URL
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true); //Allows POST

        conn.setRequestProperty("User-Agent", uA);

        // Stores the response from the server
        int responseNumber = conn.getResponseCode();

        // Prints a message saying that it is sending a request to server URL
        System.out.println("\nSending 'GET' request to URL: " + url);

        // Prints the response code from received from the server
        System.out.println("Response Server: " + responseNumber);

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

        // Prints the response input stream from the server in Java String.
        System.out.println(response.toString());



        // NASTY PATHS
        try{

            URL url2 = new URL(null);

            HttpURLConnection conn2 = (HttpURLConnection) url.openConnection();


        }catch(Exception e){
            System.out.println("MalformedURLException");
        }

        try{

            HttpURLConnection connection = (HttpURLConnection) url.openConnection(null);


        }catch(Exception e){
            System.out.println("InvalidArgumentException");
        }


    }

}
