package folder;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

// @WebServlet("/folder.confirmationDel")
public class confirmationDel extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // HttpServlet doGet(HttpServletRequest request, HttpServletResponse response)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Calls deleteTable method from updateDB class
        // to delete all information from the product
        updateDB.deleteTable();

        // Redirect after deletion to the "/folder.ProductView"
        RequestDispatcher dispatcher = request.getRequestDispatcher("/folder.ProductView");
        dispatcher.forward(request, response);
    }
}