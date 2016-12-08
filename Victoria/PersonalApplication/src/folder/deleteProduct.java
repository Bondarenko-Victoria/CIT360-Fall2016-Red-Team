package folder;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Servlet implementation class of deleteProduct
// @WebServlet("/folder.deleteProduct")
public class deleteProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    //HttpServlet doGet(HttpServletRequest request, HttpServletResponse response)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try{
            // Take user product id ( calls as "delete") from Servlet
            // and stores it in rowDeletion
            int rowDeletion = Integer.parseInt(request.getParameter("delete"));
            // Calls deleteDB method from updateDB class
            updateDB.deleteDB(rowDeletion);
            // If the user does not enter anything
            // or inputs have invalid characters
            // program will redirect to the page ProductView
        }
        catch(Exception ex){
            // Redirect to "/folder.ProductView" to make sure it was deleted
            RequestDispatcher dispatcher = request.getRequestDispatcher("/folder.ProductView");
            dispatcher.forward(request, response);
        }
    }
}