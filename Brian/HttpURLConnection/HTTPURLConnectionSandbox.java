import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Brian on 10/21/2016.
 */
public class HTTPURLConnectionSandbox {

    // Stored user agent to Mozilla 5.0
    private final String userAgent = "Mozilla/5.0";

    public static void main(String args[]) {
        // Creates an instance of the Class
        HTTPURLConnectionSandbox connect = new HTTPURLConnectionSandbox();
        try {
            // Calls the go method
            connect.go();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void go() throws Exception{

        // URL of Google search for "snow" keyword stored
        URL url = new URL("https://www.google.com/search?q=snow");

        // Opens a connection to the URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true); //Allows POST

        connection.setRequestProperty("User-Agent", userAgent);

        // Stores the response code received from the server
        int responseNumber = connection.getResponseCode();
        // Prints a message saying that it is sending a response to server URL
        System.out.println("\nSending 'GET' response to URL: " + url);
        // Prints the response code from received from the server
        System.out.println("Response: " + responseNumber);

        // Creates buffer reader and stores the input stream from the server
        BufferedReader myBuffer = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));

        String input;
        // Saves the input stream from the server
        StringBuffer response = new StringBuffer();

        //
        while((input = myBuffer.readLine()) != null) {
            response.append(input);
        }

        myBuffer.close();
        // Prints the response input stream from the server in Java String.
        System.out.println(response.toString());


        // NASTY PATHS

        // Pass null to openConnection, you get an IllegalArgumentException
        //HttpURLConnection connection = (HttpURLConnection) url.openConnection(null);

        // Empty String URL, you get a MalformedURLException
        // URL url = new URL("");

        // Null URL, you get a MalformedURLException caused by a NullPointerException
        // URL url = new URL(null);

        // Local machine with port 80, you get a SocketException
        //URL url = new URL("http://localhost:80");

        // URL that does not exist, you get an UnknownHostException
        //URL url = new URL("http://thismyou.com/");

    }

}
