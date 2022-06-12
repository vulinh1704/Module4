<%--
  Created by IntelliJ IDEA.
  User: Linh
  Date: 6/12/2022
  Time: 12:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<h1>Caculator</h1>
<form method="post">
<input type="text" name="number1">
<input type="text" name="number2">
<br>
    <input type="submit" value="Addition(+)" name="operator">
    <input type="submit" value="Subtraction(-)" name="operator">
    <input type="submit" value="Multiplication(X)" name="operator">
    <input type="submit" value="Division(/)" name="operator">
</form>
Result ${operator} : ${result}
</body>
</html>
