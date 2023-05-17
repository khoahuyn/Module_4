<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 5/15/2023
  Time: 7:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ứng Dụng Tính Tiền</title>
</head>
<body>
<form action="/search" method="get">
    <input path="search" name="search" /> Hãy nhập giá trị
    <button type="submit">Search</button>
    <h2>Kết quả: ${result} </h2>

</form>
</body>
</html>
