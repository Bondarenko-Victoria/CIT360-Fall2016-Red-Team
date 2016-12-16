package folder;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

// @WebServlet("/folder.Servlet")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // HttpServlet doGet(HttpServletRequest request, HttpServletResponse response)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Content type
        response.setContentType("text/html");
        PrintWriter write = response.getWriter();

        // Takes/grabs values from the form from html page
        // Stores it in variables
        try{
            // Passes parameters to a Servlet
            int key = Integer.parseInt(request.getParameter("key"));
            String item = request.getParameter("item");
            String description = request.getParameter("description");
            // Parse to Integer
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            // useDB method in updateDB class
            // Passes variables from input to save in DB
            try{
                // Adds values to DB
                // It is handle updating the DB
                updateDB.useDB(key, item, description, quantity);
            } catch(Exception ex){
                // Catches error and displays the Error Page
                // If DB is not updated
                write.println("<h1>Database is not updated.</h1>");
                write.println(ex.getMessage());
            }
        }
        catch(Exception e){
            // Displays Error Page
            // If all fields are not fill
            write.println("<h1>ERROR!</h1>");
            write.println("<p>Please, fill all fields in the form.</p>");
            write.println("<a href=\"subForm.html\">Go Back To Submission Form</a>");

            return;
        }

        // Verification
        // Prints out successful results
        write.println("<link rel=stylesheet type=text/css href=style2.css>");
        write.println("<h2>Information Successfully Added to Database!!!</h2>");
        write.println("<p>----------------------------------------------------------------------------------------------------</p>");

        //Deletion
        // Forms that allow the user to remove specific items from the table
        // Redirect to "/folder.deleteProduct"
        write.println("<form method=\"get\" action=\"folder.deleteProduct\">");
        write.println("Specify 'Key' To Delete: <input name=\"delete\">");
        write.println("<input type=\"submit\">");
        write.println("</form>");

        // html that is creates a table to be shown
        write.println("<table style=width:100%>");
        write.println("<tr>");
        write.println("<th>Key</th>");
        write.println("<th>Item</th>");
        write.println("<th>Description</th> ");
        write.println("<th>Quantity</th> ");
        write.println("</tr>");

        // queryDB method from updateDB class
        // Queries the whole DB
        updateDB.queryDB();

        // Stores the results in a list
        List <product> item;
        item = updateDB.items;

        // Prints each column of the row in the table
        for (product result : item){
            System.out.println("Object: " + result);
            write.println("<tr>");
            write.println("<td>" + result.key + "</td>");
            write.println("<td>" + result.item + "</td>");
            write.println("<td>" + result.description + "</td>");
            write.println("<td>" + result.quantity + "</td>");
            write.println("</tr>");

        }
        write.println("</table>");
        write.println("<a href=\"subForm.html\">Submit More Products</a>");

    }
}