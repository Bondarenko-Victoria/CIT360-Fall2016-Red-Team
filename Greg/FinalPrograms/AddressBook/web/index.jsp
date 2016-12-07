<%@ page import="AddressBook.Contact" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: gvh574
  Date: 12/3/2016
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <link rel="stylesheet" href="/assets/css/bootstrap.min.css">
    <title>$Title$</title>
  </head>
  <body>

  <h1>Address Book</h1>



  <p>Add a Contact to your Address Book</p>
  <form action="RequestHandler" method="POST" >
      <label for="firstName">First Name: </label><input type="text" name="firstName" id="firstName"><br>
      <label for="lastName">Last Name: </label><input type="text" name="lastName" id="lastName"><br>
      <label for="phoneNumber">Phone Number: </label><input type="tel" name="phoneNumber" id="phoneNumber"><br>
      <label for="street">Street:</label><input type="text" name="street" id="street"><br>
      <label for="city">City: </label><input type="text" name="city" id="city"><br>
      <label for="state">State: </label><select name="state" id="state">
          <option value="">Select a state...</option>
          <option value="AL">Alabama</option>
          <option value="AK">Alaska</option>
          <option value="AZ">Arizona</option>
          <option value="AR">Arkansas</option>
          <option value="CA">California</option>
          <option value="CO">Colorado</option>
          <option value="CT">Connecticut</option>
          <option value="DE">Delaware</option>
          <option value="DC">District Of Columbia</option>
          <option value="FL">Florida</option>
          <option value="GA">Georgia</option>
          <option value="HI">Hawaii</option>
          <option value="ID">Idaho</option>
          <option value="IL">Illinois</option>
          <option value="IN">Indiana</option>
          <option value="IA">Iowa</option>
          <option value="KS">Kansas</option>
          <option value="KY">Kentucky</option>
          <option value="LA">Louisiana</option>
          <option value="ME">Maine</option>
          <option value="MD">Maryland</option>
          <option value="MA">Massachusetts</option>
          <option value="MI">Michigan</option>
          <option value="MN">Minnesota</option>
          <option value="MS">Mississippi</option>
          <option value="MO">Missouri</option>
          <option value="MT">Montana</option>
          <option value="NE">Nebraska</option>
          <option value="NV">Nevada</option>
          <option value="NH">New Hampshire</option>
          <option value="NJ">New Jersey</option>
          <option value="NM">New Mexico</option>
          <option value="NY">New York</option>
          <option value="NC">North Carolina</option>
          <option value="ND">North Dakota</option>
          <option value="OH">Ohio</option>
          <option value="OK">Oklahoma</option>
          <option value="OR">Oregon</option>
          <option value="PA">Pennsylvania</option>
          <option value="RI">Rhode Island</option>
          <option value="SC">South Carolina</option>
          <option value="SD">South Dakota</option>
          <option value="TN">Tennessee</option>
          <option value="TX">Texas</option>
          <option value="UT">Utah</option>
          <option value="VT">Vermont</option>
          <option value="VA">Virginia</option>
          <option value="WA">Washington</option>
          <option value="WV">West Virginia</option>
          <option value="WI">Wisconsin</option>
          <option value="WY">Wyoming</option>
      </select><br>
      <label for="zip">Zip: </label><input type="text" name="zip" id="zip"><br>
      <button type="submit" name="submit">Submit</button>
  </form>

  <p>See a list of contacts in your Address Book</p>
  <form action="RequestHandler" method="GET" >
      <button type="submit" name="submit">Submit</button>
  </form>

  <c:out value="hello" />
  <%--<!--  This series of loops all contacts retrieved   -->--%>
  <%--<%--%>
      <%--ArrayList<Contact> s = (ArrayList) session.getAttribute("addressBook");--%>
      <%--for(Contact contact : s){--%>
          <%--System.out.println(contact.getFirstName() + " " + contact.getLastName());--%>
<%--//          System.out.println(contact.getPhoneNumber());--%>
<%--//          System.out.println(contact.getStreet());--%>
<%--//          System.out.println(contact.getCity() + ", " + contact.getState() + " " + contact.getZip());--%>
<%--//          System.out.println();--%>
      <%--}--%>
  <%--%>--%>





  </body>
</html>
