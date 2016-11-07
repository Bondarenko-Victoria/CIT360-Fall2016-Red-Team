<%--
  Created by IntelliJ IDEA.
  User: Victoria
  Date: 08.10.2016
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
<p>Here is information for submission:</p>
<%--Basic Form--%>
<%--make sure to send with GET method--%>
<form id="form" method="GET" action="ServletServer">
  <input type="text" name="first_name" placeholder="First Name">
  <input type="text" name="last_name" placeholder="Last Name">
  <button type="submit" form ="form" value="Submit">Click On Me</button>
</form>
</body>
</html>