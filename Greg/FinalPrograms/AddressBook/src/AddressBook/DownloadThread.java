package AddressBook;

import Firebase.Firebase;
import qcJSON.json.*;

import java.io.*;
import java.util.*;
import java.util.ArrayList;

/**
 * Created by gvh574 on 12/14/2016.
 */
public class DownloadThread implements Runnable {

    Thread dl;
    private String threadName;
    ArrayList<Contact> addressBook;
    FileOutputStream fileStream;
    JSONOutputStream jsonOut;


    DownloadThread( ArrayList<Contact> name) {
        addressBook = name;
    }

    public void run() {

        try {
            // Create File
            File download = new File("addressBook.json");
            fileStream = new FileOutputStream(download);
            jsonOut = new JSONOutputStream(fileStream);

            // write each contact to addressbook
            for (Contact contact : addressBook) {
                jsonOut.writeObject(contact);
            }

            //close Output stream
            jsonOut.close();
            System.out.println("Download Successful");;
        }
        catch (Exception e) {
            System.out.println("Download Unsuccessful");
        }
    }

}
