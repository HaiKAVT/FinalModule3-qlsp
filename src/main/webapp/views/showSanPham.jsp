<%--
  Created by IntelliJ IDEA.
  User: Win10
  Date: 8/9/2021
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Product Table</h2>
    <a href="/sanpham?action=create">create</a>
    <table class="table table-condensed">
        <thead>
        <tr>
            <th>#</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Catagory</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listSP}" var="sp" varStatus="loop" >
            <tr>
                <td>${sp.getId()}</td>
                <td>${sp.getTen()}</td>
                <td>${sp.getGia()}</td>
                <td>${sp.getSoLuong()}</td>
                <td>${sp.getMauSac()}</td>
                <td>${sp.getMota()}</td>
                <td>${sp.getIdDanhMuc()}</td>
                <td><a href="/sanpham?action=edit&index=${loop.index}">edit</a></td>
                <td><a href="/sanpham?action=delete&id=${sp.id}" >delete</a></td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
