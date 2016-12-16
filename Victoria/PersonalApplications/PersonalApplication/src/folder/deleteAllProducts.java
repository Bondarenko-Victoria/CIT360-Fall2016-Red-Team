package folder;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

// Servlet implementation class of deleteAllProducts
// @WebServlet("/folder.deleteAllProducts")
public class deleteAllProducts extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // HttpServlet doGet(HttpServletRequest request, HttpServletResponse response)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Content type
        response.setContentType("text/html");
        PrintWriter write = response.getWriter();

        // When the user hit submit to delete the whole table
        // it redirects to this servlet

		// It prints information to the confirmation page of deletion
        // with opportunity to go back to the Product Page
        // or confirmation of deletion of the entire page
        // and redirect to "folder.confirmationDel"
        write.println("<form method=\"get\" action=\"folder.confirmationDel\">");
        write.println("<h1>WARNING!!!! You are going to delete all data from the Product Table!</h1>");
        write.println("Return to Product Page <a href=\"folder.ProductView\">Go to Product Page</a>");
        write.println("<br>");
        write.println("Click SUBMIT to confirm the removal of the Product Table: <input type=\"submit\">");
        write.println("</form>");
    }
}