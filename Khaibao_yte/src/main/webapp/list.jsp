<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>Medical Declaration</title>
</head>
<body>
<%--<h1>TỜ KHAI Y TẾ</h1>--%>
<%--<h2>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DICH BÊNH TRUYỀN NHIỄM</h2>--%>
<%--<h4 style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể bị xử lý hình sự</h4>--%>
<table>
    <tr>
        <th>Họ Tên</th>
        <th>Năm sinh</th>
        <th>Giới tính</th>
        <th>Quốc tịch</th>
        <th>Số CMND</th>
        <th>Thông tin đi lại</th>
        <th>Số hiệu phương tiện</th>
        <th>Số ghế ngồi</th>
        <th>Ngày khởi hành</th>
        <th>Ngày kết thúc</th>
        <th>Thông tin di lại</th>
        <th>Tỉnh/thành</th>
        <th>Quận/huyện</th>
        <th>Phường/xã</th>
        <th>Địa chỉ nhà</th>
        <th>Điện thoại</th>
        <th>Email</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${declaration}" var="d">
        <tr>
            <td>${d.name}</td>
            <td>${d.yearOfBirth}</td>
            <td>${d.gender}</td>
            <td>${d.nationality}</td>
            <td>${d.identifyCard}</td>
            <td>${d.vehicle}</td>
            <td>${d.licensePlate}</td>
            <td>${d.seats}</td>
            <td>${d.startDate}</td>
            <td>${d.endDate}</td>
            <td>${d.information}</td>
            <td>${d.province}</td>
            <td>${d.district}</td>
            <td>${d.ward}</td>
            <td>${d.address}</td>
            <td>${d.phoneNumber}</td>
            <td>${d.email}</td>
            <td><a href="/yte/update?iCard=${d.identifyCard}">Update</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>