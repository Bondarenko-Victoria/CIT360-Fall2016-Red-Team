/**
 * Created by Brian on 12/13/16.
 */
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

// Get method to store user data in firebase
@WebServlet(name = "RequestHandler", urlPatterns = {"/RequestHandler"})
public class RequestHandler extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create a firebase instance
        FirebaseConnectionTest firebase = new FirebaseConnectionTest();

        try {
            // initializes firebase
            firebase.initialize();
            // Stores
            ArrayList<User> userList = firebase.get();
            // Sets the username and password as attribute
            request.setAttribute("userList", userList);
            request.getSession().setAttribute("userList", userList);
            request.getRequestDispatcher("/index.jsp").forward(request, response);

        } catch (Exception e) {
        }

    }

    // Post method to store user data in firebase
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FirebaseConnectionTest firebase = new FirebaseConnectionTest();
        // Create a new user java bean.
        User newUser = new User();
        // sets the name as an attribute
        newUser.setName(request.getParameter("name"));
        // sets the username as an attribute
        newUser.setUsername(request.getParameter("username"));
        // sets the password as an attribute
        newUser.setPassword(request.getParameter("password"));
        // sets the email as an attribute
        newUser.setEmail(request.getParameter("email"));

        request.setAttribute("status", "Success");
        request.getRequestDispatcher("/index.jsp").forward(request, response);

        try{
            // Initializes firebase
            firebase.initialize();
            // Stores the user object in firebase.
            //firebase.post(newUser);
        }catch(Exception e){
        }
    }
    }
}

