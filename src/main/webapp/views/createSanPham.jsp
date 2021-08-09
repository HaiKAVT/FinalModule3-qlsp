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
    <form action="/sanpham?action=create" method="post">
    <table class="table table-condensed">
        <thead>
        <tr>
            <th>#</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Catagory</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><input type="text" placeholder="Nhập id" name="id"></td>
            <td><input type="text" placeholder="Nhập tên" name="ten"></td>
            <td><input type="text" placeholder="Nhập giá" name="gia"></td>
            <td><input type="text" placeholder="Nhập số lượng" name="soluong"></td>
            <td><input type="text" placeholder="Nhập màu sắc" name="mauSac"></td>
            <td><input type="text" placeholder="Nhập mô tả" name="mota"></td>
            <td>
                <select name="danhmuc">
                    <option disabled="disabled" selected>Chọn danh mục</option>
                    <c:forEach items="${listCategory}" var="c">
                        <option value="${c}">${c}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <button type="submit" class="btn btn-success">Thêm</button>
            </td>
        </tr>
        </tbody>
    </table>
    </form>
</div>

</body>
</html>
