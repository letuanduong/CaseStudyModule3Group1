<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form method="post">
    <input type="text" name="username" placeholder="Username Here"/>
    <input type="password" name="password"/>
    <button type="submit">Login</button>
    <c:out value="${message}"/>
</form>
</body>
</html>