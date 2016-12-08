package folder;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

// folder.Servlet implementation class folder.ProductView
// @WebServlet("/folder.ProductView")
public class ProductView extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // HttpServlet doGet(HttpServletRequest request, HttpServletResponse response)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Content type
        response.setContentType("text/html");
        PrintWriter write = response.getWriter();

        // Prints HTML elements
        write.println("<link rel=stylesheet type=text/css href=style2.css>");
        write.println("<ul>");
        write.println("<li><a href=\"Home.html\">Home</a></li>");
        write.println("<li><a href=\"subForm.html\">Submit Product</a></li>");
        write.println("</ul>");
        write.println("<p>----------------------------------------------------------------------------------------------------</p>");

        write.println("<form method=\"get\" action=\"folder.deleteProduct\">");
        write.println("Specify Product Key To Delete It: <input name=\"delete\">");
        write.println("<input type=\"submit\">");
        write.println("</form>");

        write.println("<form method=\"get\" action=\"folder.deleteAllProducts\">");
        write.println("Delete Entire Database: <input type=\"submit\">");
        write.println("</form>");

        write.println("<p>----------------------------------------------------------------------------------------------------</p>");


        // Creates the table with information
        write.println("<table style=width:100%>");
        write.println("<tr>");
        write.println("<th>Key</th>");
        write.println("<th>Item</th>");
        write.println("<th>Description</th> ");
        write.println("<th>Quantity</th> ");
        write.println("</tr>");


        // Queries to DB
        updateDB.queryDB();

        // Creates a list
        List <product> item;
        item = updateDB.items;

        // Loops through all objects
        // Prints out contents
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

    }
}