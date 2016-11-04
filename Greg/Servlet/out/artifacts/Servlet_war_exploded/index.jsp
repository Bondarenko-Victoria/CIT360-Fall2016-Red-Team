<%--
  Created by IntelliJ IDEA.
  User: gvh574
  Date: 11/4/2016
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<p>Hello, pleas input your information below:</p>
<form id="form" method="GET" action="DisplayServlet">
    <input type="text" name="first_name" placeholder="First Name">
    <input type="text" name="last_name" placeholder="Last Name">
    <input type="text" name="birthday" placeholder="Birthday">
    <button type="submit" form ="form" value="Submit">Submit</button>
</form>
</body>
</html>
