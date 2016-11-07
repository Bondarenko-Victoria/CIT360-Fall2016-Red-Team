// Import required java libraries
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

/**
 * Created by Victoria on 08.10.2016.
 */

// Extend HttpServlet class
@WebServlet(name = "ServletsExample")
public class ServletsExample extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // Actual logic goes here
        try (PrintWriter writer = response.getWriter()) {

            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\" />");
            writer.println("<title>ServletsExample.java:doGet(): Servlet code!</title>");
            writer.println("</head>");
            writer.println("<body>");

            writer.println("<h1>This is an example of my java servlet.</h1>");

            writer.println("</body>");
            writer.println("</html>");
        }
    }
}