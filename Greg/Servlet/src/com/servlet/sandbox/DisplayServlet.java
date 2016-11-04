package com.servlet.sandbox;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;

/**
 * Created by gvh574 on 11/4/2016.
 */
@WebServlet(name = "DisplayServlet", urlPatterns = {"/DisplayServlet"})
public class DisplayServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        set content type
        response.setContentType("text/html");
//        create writer
        PrintWriter writer = response.getWriter();

//        create storage for variables, easy access
        HashMap<String, String> info = new HashMap<>();
        info.put("firstName", request.getParameter("first_name").toUpperCase());
        info.put("lastName", request.getParameter("last_name").toUpperCase());
        info.put("birthday", request.getParameter("birthday"));

//        write html to page
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Display Info Servlet</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1>Hello</h1>");
        writer.println("<p>Welcome " + info.get("firstName") + " " + info.get("lastName") + "</p>");
        writer.println("<p>Your Birthday is " + info.get("birthday") +"</p>");
        writer.println("</body>");
        writer.println("</html>");

        writer.flush();
        writer.close();

    }
}
