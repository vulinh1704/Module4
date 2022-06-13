<%--
  Created by IntelliJ IDEA.
  User: Linh
  Date: 6/13/2022
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form method="post" action="/users">
    <h4>Nhập Email</h4>
    <input type="text" name="email" pattern="[a-z]+\.[a-z]+@[a-z]+\.[a-z]+\.[a-z]+" title="Nhập đúng định dạng">
    <h4>Nhập PassWord</h4>
    <input type="password" name="password" pattern="[0-9]{6,12}" title="Nhập 6 - 12 số">
    <br>
    <br>
    <input type="submit" value="Login" name="action">
</form>
<h1 style="color:red">${alert}</h1>
</body>
</html>
