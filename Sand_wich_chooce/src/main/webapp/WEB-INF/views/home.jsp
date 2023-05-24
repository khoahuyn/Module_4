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
    <title>SandWich Condiments</title>
</head>
<body>

<form action="/save" method="post">
    <label>
        <input type="checkbox" name="condiment" value="Lettuce" >Lettuce
    </label>
    <label>
        <input type="checkbox" name="condiment" value="Tomato" >Tomato
    </label>
    <label>
        <input type="checkbox" name="condiment" value="Mustard" >Mustard
    </label>
    <label>
        <input type="checkbox" name="condiment" value="Sprouts" >Sprouts
    </label>
    <button type="submit">Save</button>

</form>
</body>
</html>
