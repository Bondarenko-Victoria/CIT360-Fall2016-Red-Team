<%@ page import="User" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Brian
  Date: 12/13/16
  Time: 12:44 PM
  This is the main page of my web app that the user will see
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>User Sign-Up</h1>

  <%--html form that contains text fields for username and password and a sign up button--%>
  <form action="RequestHandler" method="POST" >
    Name: <input type="text" name="name" id="name"><br>
    Username:<input type="text" name="username" id="username"><br>
    Password:<input type="text" name="password" id="password"><br>
    Email:<input type="text" name="email" id="email"><br><br>
    <button type="submit" name="submit">Sign Up</button>
  </form>
  </body>
</html>
