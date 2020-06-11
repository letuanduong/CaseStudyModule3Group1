<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/10/2020
  Time: 10:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div align="center">
    <h2>List of Product</h2>
    <table border="1" cellpadding="5">
        <tr>
            <td>username</td>
            <td>password</td>
            <td>role</td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>
                    <c:out value="${user.getUsername()}"/>
                </td>
                <td>
                    <c:out value="${user.getUsername()}"/>
                </td>
                <td>
                    <c:out value="${user.getRole()}"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
