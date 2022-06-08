<%--
  Created by IntelliJ IDEA.
  User: Linh
  Date: 6/8/2022
  Time: 9:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Danh sách sản phẩn khuyển mãi 10%</h1>
<c:forEach var="product" items="${productsOver200}">
    <h3>${product.getName()} , ${product.getPrice()} - Khuyến mãi 10%</h3>
</c:forEach>
<hr>
<h1>Danh sách sản phẩn khuyển mãi 20%</h1>
<c:forEach var="product" items="${productsLess200}">
    <h3>${product.getName()} , ${product.getPrice()} - Khuyến mãi 20%</h3>
</c:forEach>
<hr>
<h1>Tìm kiếm theo tên gần đúng</h1>
<form method="post" action="/products">
    <input type="text" name="name">
    <button type="submit">Nhấn mẹ đi</button>
</form>
<c:forEach var="product" items="${productsApproximateName}">
    <h3>${product.getName()}</h3>
</c:forEach>
<h1>Tìm kiếm theo khoảng giá</h1>
<form method="post" action="/products">
    Giá từ :
    <input type="number" name="price1">
    Đến :
    <input type="number" name="price2">
    <button type="submit">Nhấn mẹ đi</button>
</form>
<c:forEach var="product" items="${productsPriceRange}">
    <h3>${product.getName()}</h3>
</c:forEach>
</body>
</html>
