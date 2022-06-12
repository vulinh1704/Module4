<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Linh
  Date: 6/12/2022
  Time: 12:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form method="post">
    <input type="checkbox" name="condiment" value="Lettuce">
    Lettuce
    <input type="checkbox" name="condiment" value="Tomato">
    Tomato
    <input type="checkbox" name="condiment" value="Mustard">
    Mustard
    <input type="checkbox" name="condiment" value="Sprouts">
    Sprouts
    <input type="submit" value="Save">
</form>
<hr style="width: 40%">
<h3>Bạn đã chọn : </h3>
<c:forEach items="${sandwich}" var="s">
<h3> ${s} </h3>
</c:forEach>
</body>
</html>
