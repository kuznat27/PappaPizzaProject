<%--
  Created by IntelliJ IDEA.
  User: kuznetsovanatalia
  Date: 01/02/2024
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>Registration</h1>
<form action="RegistrationServlet" method="post">
    <label for="username">User name:</label>
    <input type="text" id="username" name="username" required><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>

    <input type="submit" value="Submit">
</form>

<c:if test="${param.error == '1'}">
    <p style="color: red;">Error. Try again.</p>
</c:if>
</body>
</html>

