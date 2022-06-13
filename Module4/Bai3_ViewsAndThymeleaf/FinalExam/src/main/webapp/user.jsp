<%--
  Created by IntelliJ IDEA.
  User: Linh
  Date: 6/13/2022
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h4>Search All Employee</h4>
<br>
<form action="/users" method="post">
    <input type="text" name="idProject" placeholder="idProject">
    <button value="search" name = "action">Search</button>
</form>
<c:if test="${users != null}">
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Pro Skill</th>
            <th>Project Id</th>
            <th>Role</th>
        </tr>
        <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getFullName()}</td>
            <td>${user.getEmail()}</td>
            <td>${user.getPro_skill()}</td>
            <td>${user.getProjectId()}</td>
            <td>${user.getRole()}</td>
        </tr>
        </c:forEach>
    </table>
</c:if>
<br>
<form action="/users" method="post">
    <input type="submit" value="showManage" name="action" placeholder="Show Manage">
</form>
<c:if test="${usersManage != null}">
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Exp In Year</th>
            <th>Project Id</th>
            <th>Role</th>
        </tr>
        <c:forEach items="${usersManage}" var="user">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getFullName()}</td>
                <td>${user.getEmail()}</td>
                <td>${user.getExp_in_year()}</td>
                <td>${user.getProjectId()}</td>
                <td>${user.getRole()}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
