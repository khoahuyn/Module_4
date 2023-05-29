<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 28/05/2023
  Time: 12:18 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form:form action="/yte/update" method="post" modelAttribute="declaration">

    <h3>Họ và tên(Ghi chữ IN HOA)<span class="note">(*)</span></h3>
    <form:input path="name" cssStyle="width: 100%"/>
    <br>
    <table style="width: 100%">
        <tr style="text-align: left">
            <th>Năm sinh<span class="note">(*)</span></th>
            <th>Giới tính<span class="note">(*)</span></th>
            <th>Quốc tịch<span class="note">(*)</span></th>
        </tr>

        <tr>
            <td style="width: 33.3%"><form:select path="yearOfBirth" items="${yearOfBirthList}" cssStyle="width: 500px"/></td>
            <td style="width: 33.3%"><form:select path="gender" items="${genderList}" cssStyle="width: 500px"/></td>
            <td style="width: 33.3%"><form:select path="nationality" items="${nationalityList}" cssStyle="width: 500px"/></td>
        </tr>
    </table>

    <h3>Số CMND<span class="note">(*)</span></h3>
    <form:input path="identifyCard" cssStyle="width: 100%"/>


    <h3>Thông tin đi lại<span class="note">(*)</span></h3>
    <form:radiobuttons path="vehicle" items="${vehicleList}"/>


    <h3>Số hiệu phương tiện: </h3>
    <form:input path="licensePlate" cssStyle="width: 100%"/>

    <h3>Số ghế ngồi: </h3>
    <form:input path="seats" cssStyle="width: 100%"/>

    <table style="width: 100%">
        <tr style="text-align: left">
            <th>Ngày khởi hành<span class="note">(*)</span></th>
            <th>Ngày kết thúc<span class="note">(*)</span></th>
        </tr>

        <tr>
            <td style="width: 50%"><form:input path="startDate" cssStyle="width: 750px"/></td>
            <td style="width: 50%"><form:input path="endDate" cssStyle="width: 750px"/></td>
        </tr>
    </table>

    <h3>Thông tin di chuyển <span class="note">(*)</span> </h3>
    <form:input path="information" cssStyle="width: 100%"/>

    <table style="width: 100%">
        <tr style="text-align: left">
            <th>Tỉnh/thành phố<span class="note">(*)</span></th>
            <th>Quận/huyện<span class="note">(*)</span></th>
            <th>Phường/xã<span class="note">(*)</span></th>
        </tr>

        <tr>
            <td style="width: 33.3%"><form:input path="province" cssStyle="width: 500px"/></td>
            <td style="width: 33.3%"><form:input path="district" cssStyle="width: 500px"/></td>
            <td style="width: 33.3%"><form:input path="ward" cssStyle="width: 500px"/></td>
        </tr>
    </table>

    <h3>Địa chỉ nơi ở <span class="note">(*)</span> </h3>
    <form:input path="address" cssStyle="width: 100%"/>


    <h3>Điện thoại<span class="note">(*)</span></h3>
    <form:input path="phoneNumber" cssStyle="width: 100%"/>


    <h3>Email: </h3>
    <form:input path="email" cssStyle="width: 100%"/>


    <h3><form:button>Save</form:button></h3>

</form:form>
</body>
</html>