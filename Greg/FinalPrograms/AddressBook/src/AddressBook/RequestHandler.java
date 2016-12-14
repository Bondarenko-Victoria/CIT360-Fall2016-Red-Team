package AddressBook;
 import Firebase.Firebase;

 import javax.servlet.*;
 import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.*;
 import java.io.IOException;
 import java.util.ArrayList;
 import java.util.HashMap;

/**
 * Created by gvh574 on 12/3/2016.
 */
@WebServlet(name = "RequestHandler", urlPatterns = {"/RequestHandler"})
public class RequestHandler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Firebase firebase = new Firebase();
        Contact newContact = new Contact();
        newContact.setFirstName(request.getParameter("firstName"));
        newContact.setLastName(request.getParameter("lastName"));
        newContact.setPhoneNumber(request.getParameter("phoneNumber"));
        newContact.setStreet(request.getParameter("street"));
        newContact.setCity(request.getParameter("city"));
        newContact.setState(request.getParameter("state"));
        newContact.setZip(request.getParameter("zip"));
        request.setAttribute("status", "Success");
        request.getRequestDispatcher("/index.jsp").forward(request, response);

        try{
            firebase.initialize();
            System.out.println(firebase.post(newContact));

        }catch(Exception e){
            System.out.println("didnt work");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Firebase firebase = new Firebase();


        if (request.getParameter("download").equals("download")){
            try {
                firebase.initialize();
                ArrayList<Contact> addressBook = firebase.get();
                DownloadThread download = new DownloadThread(addressBook);
                download.run();
                request.getRequestDispatcher("/index.jsp").forward(request, response);

            } catch (Exception e) {
                System.out.println("didnt work");
            }

        }else {
            try {
                firebase.initialize();
                ArrayList<Contact> addressBook = firebase.get();
                request.setAttribute("addressBook", addressBook); // Will be available as ${addressBook} in JSP
                request.getSession().setAttribute("addressBook", addressBook);
                request.getRequestDispatcher("/index.jsp").forward(request, response);

            } catch (Exception e) {
                System.out.println("didnt work");
            }
        }

    }
}
