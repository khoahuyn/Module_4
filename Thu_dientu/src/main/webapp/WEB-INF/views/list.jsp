<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--

  Created by IntelliJ IDEA.
  User: This PC
  Date: 5/26/2023
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mail details</title>
</head>
<body>
<h2>Mail information</h2>


    <table>
        <tr>
            <td>ID</td>
            <td>Languages</td>
            <td>Page Size</td>
            <td>Signature</td>
            <td>Action</td>

        </tr>
        <c:forEach var="mail" items="${mails}">
            <tr>
                <td>${mail.id}</td>
                <td>${mail.languages}</td>
                <td>${mail.pageSize}</td>
                <td>${mail.signature}</td>
                <td><a href="/mail/edit?id=${mail.id}">Edit mail</a></td>
            </tr>
        </c:forEach>

    </table>

</body>
</html>
