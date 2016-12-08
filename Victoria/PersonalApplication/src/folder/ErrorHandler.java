package folder;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

// Servlet implementation class of ErrorHandler
// @WebServlet("/folder.ErrorHandler")
public class ErrorHandler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // HttpServlet doGet(HttpServletRequest request, HttpServletResponse response)
    // Handle page errors, 404, 500, etc.
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Content type
        response.setContentType("text/html");
        PrintWriter write = response.getWriter();

        write.println("<h1>ERROR!!!</h1>");

        // Push the page out
        // Stream takes too long
        write.flush();
        return;
    }
}