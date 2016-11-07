import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.HashMap;

/**
 * Created by Victoria on 08.10.2016.
 */

@WebServlet(name = "ServletServer", urlPatterns = {"/ServletServer"})
public class ServletServer extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Content type
        response.setContentType("text/html");
        // Writer
        PrintWriter writer = response.getWriter();

        // Storage for variables
        HashMap<String, String> info = new HashMap<>();
        info.put("firstName", request.getParameter("first_name"));
        info.put("lastName", request.getParameter("last_name"));

        // HTML for page
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Servlet communicate with Server</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<p>Welcome to this page, " + info.get("firstName") + " " + info.get("lastName") + "</p>");
        writer.println("<p>P.S. It is an example how server interact with given information.</p>");
        writer.println("</body>");
        writer.println("</html>");

        writer.flush();
        writer.close();

    }
}