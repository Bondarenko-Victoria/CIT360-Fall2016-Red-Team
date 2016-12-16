package folder;

import java.sql.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class connectDB {

    // Set up DB
    public static void connectDB(){
        // jdbc Driver
        final String BC_DRIVER="com.mysql.jdbc.Driver";
        // URL of database
        final String URL="jdbc:mysql://localhost:3306/shop?useSSL=false";

        // DB username and password
        final String USER = "root";
        final String PASS = "";

        try{
            // Register the jdbc Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open connection
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
        }

        catch (ClassNotFoundException e) {
            // Auto-generated catch blocks
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}