<%@ page import="PersonalInformation.Contacts" %>
<%@ page import="java.util.ArrayList" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="/assets/css/bootstrap.min.css">
  <title>Personal Information</title>
</head>
<body>

<h1>Personal Information</h1>



<p>Add a Personal Information</p>
<form action="ServletHandler" method="POST" >
  <label for="firstName">First Name: </label><input type="text" name="firstName" id="firstName"><br>
  <label for="lastName">Last Name: </label><input type="text" name="lastName" id="lastName"><br>
  <label for="weight">Weight: </label><input type="text" name="weight" id="weight"><br>
  <label for="height">Height:</label><input type="text" name="height" id="height"><br>
  <label for="age">Age: </label><input type="text" name="age" id="age"><br>
  <button type="submit" name="submit">Submit</button>
</form>

<p>See a list of Personal Information</p>
<form action="ServletHandler" method="GET" >
  <button type="submit" name="submit">Submit</button>
</form>

</body>
</html>