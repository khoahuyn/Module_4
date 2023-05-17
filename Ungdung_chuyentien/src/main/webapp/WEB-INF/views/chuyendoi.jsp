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
<form action="/money" method="get">
    <input path="usd" name="usd" /> Hãy nhập giá trị
    <button type="submit">Chuyển tiền</button>
    <h2>Bạn nhận được ${result} đồng</h2>

</form>
</body>
</html>
