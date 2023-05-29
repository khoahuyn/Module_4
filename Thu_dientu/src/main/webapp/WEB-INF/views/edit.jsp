<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 5/28/2023
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit mail</title>
</head>
<body>

<h1>Edit mail</h1>
<form:form action="/mail/edit" method="post" modelAttribute="mail">
    <table>
        <tr>
            <form:hidden path="id"/>
        </tr>

        <tr>
            <td>LANGUAGES</td>
            <td><form:select path="languages">
                <form:option value="English">English</form:option>
                <form:option value="Vietnamese">Vietnamese</form:option>
                <form:option value="Japanese">Japanese</form:option>
                <form:option value="Chinese">Chinese</form:option>
            </form:select></td>
        </tr>
        <tr>
            <td>PAGESIZE</td>
            <td><form:label path="pageSize">Show
                <form:select path="pageSize">
                    <form:option value="5">5</form:option>
                    <form:option value="20">20</form:option>
                    <form:option value="50">50</form:option>
                    <form:option value="100">100</form:option>
                </form:select> emails per page</form:label></td>

        </tr>
        <tr>
            <td>SIGNATURE</td>
            <td><form:input size="50px" path="signature"/></td>
        </tr>
        <tr>
            <td><input type="reset" value="Reset"></td>
            <td><input type="submit" value="Edit"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
