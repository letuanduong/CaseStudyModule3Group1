<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>

    <jsp:body>
        <table class="table">
            <tr>
                <td>username</td>
                <td>password</td>
                <td></td>
            </tr>
            <c:forEach items="${users}" var="user" varStatus="loop">
                <tr>
                    <td>
                        <c:out value="${loop.index + 1}"></c:out>
                    </td>
                    <td>
                        <c:out value="${user.getUsername()}"></c:out>
                    </td>
                    <td>
                        <a href="./users?command=delete&id=${user.getUsername()}">Xoá</a>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </jsp:body>

</t:layout>