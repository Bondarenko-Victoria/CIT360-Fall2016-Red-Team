package HTTP_URL_Connection;

/**
 * Created by Victoria on 20.10.2016.
 */

import java.net.*;
import java.io.*;

// An example how to upload content from a specific url-address
public class HttpUrlConnectionExample {

    // Stores user agent
    private final String agent = "Mozilla/5.0";

    public static void main(String[] args) {

        // Creates an instance
        HttpUrlConnectionExample connection = new HttpUrlConnectionExample();

        try {
            // Calls the go and httpUrl methods
            connection.go();
            connection.httpUrl();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void go() throws Exception {

        // URL of lds.org (Russian)
        URL ldsUrl = new URL("https://www.lds.org/?lang=rus");
        // Opens connection to the lgsURL
        HttpURLConnection connection = (HttpURLConnection) ldsUrl.openConnection();
        /* NASTY PATHS */
        // Gets MalformedURLException
        // If we will pass empty String URL
        // URL ldsUrl = new URL("");

        // Gets MalformedURLException (Caused by: NullPointerException)
        // If we will pass Null URL
        // URL ldsUrl = new URL(null);


        // Gets IllegalArgumentException, proxy can not be null
        // If we will pass null to openConnection
        // HttpURLConnection connection = (HttpURLConnection) ldsUrl.openConnection(null);

        //Allows POST
        connection.setDoOutput(true);

        connection.setRequestProperty("agent", agent);

        // Stores (response) code got from a server
        int responseCode = connection.getResponseCode();
        // Prints a message that it is sending to a server URL
        System.out.println("\nSending 'GET' response to URL: " + ldsUrl);
        // Prints the (response) code that received from a server
        System.out.println("Response: " + responseCode);
        System.out.println();
    }

    // Creates httpUrl method
    private void httpUrl(){

        // Attributes
        String ldsUrl = "https://www.lds.org/?lang=rus";
        URL url;

        try {
            // Connect our Object with String
            url = new URL(ldsUrl);

            // openConnection method
            // Returns a URLConnection instance that represents a connection to
            // the remote object referred to by the URL.
            HttpURLConnection huc = (HttpURLConnection)url.openConnection();

            // Calls printURL_content method below
            printURL_content(huc);

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Creates printURL_content method
    private void printURL_content(HttpURLConnection huc){
        // If our HttpURLConnection doesn't null, print url content
        if(huc != null){

            try {
                System.out.println("URL Content of LDS.ORG:");
                // getInputStream method
                // Returns an input stream that reads from this open connection
                BufferedReader buffer = new BufferedReader(new InputStreamReader(huc.getInputStream()));

                String s;

                // While String s doesn't null read our String
                while ((s = buffer.readLine()) != null){
                    System.out.println(s);
                }
                // Always close
                buffer.close();

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}