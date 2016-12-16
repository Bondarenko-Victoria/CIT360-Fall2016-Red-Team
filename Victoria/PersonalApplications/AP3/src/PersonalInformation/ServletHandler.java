package PersonalInformation;

import Firebase.Firebase;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet(name = "ServletHandler", urlPatterns = {"/ServletHandler"})
public class ServletHandler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Firebase firebase = new Firebase();
        Contacts newContact = new Contacts();
        newContact.setFirstName(request.getParameter("firstName"));
        newContact.setLastName(request.getParameter("lastName"));
        newContact.setWeight(request.getParameter("weight"));
        newContact.setHeight(request.getParameter("height"));
        newContact.setAge(request.getParameter("age"));
        request.setAttribute("status", "Success");
        request.getRequestDispatcher("/index.jsp").forward(request, response);

        try{
            firebase.initialize();
            System.out.println(firebase.post(newContact));

        }catch(Exception e){
            System.out.println("Doesn't work");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Firebase firebase = new Firebase();

        try{
            firebase.initialize();
            ArrayList<Contacts> personalInformation = firebase.get();
            request.setAttribute("personalInformation", personalInformation);
            request.getSession().setAttribute("personalInformation", personalInformation);
            request.getRequestDispatcher("/index.jsp").forward(request, response);

        }catch(Exception e){
            System.out.println("Doesn't work");
        }
    }
}