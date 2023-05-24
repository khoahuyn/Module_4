<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 5/22/2023
  Time: 7:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>

<form action="/calculate" method="post">

    <input type="text" name="number1" value=${number1} >
    <input type="text" name="number2" value=${number2} >
    <button type="submit" value="+" name="calculation">Addition(+)</button>
    <button type="submit" value="-" name="calculation">Subtraction(-)</button>
    <button type="submit" value="*" name="calculation">Multiplication(*)</button>
    <button type="submit" value="/" name="calculation">Division(/)</button>
</form>
<p>Result revision :${result}</p>
</body>
</html>
