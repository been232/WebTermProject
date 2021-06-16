<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>대출 현황 조회</title>
</head>
<style>
    <%@include file ="/css/main.css" %>
</style>
<body>
<div id="loan">
    <div class="container">
        <div class="loan">
            <table>
                <thead>
                <tr>
                    <td>No</td>
                    <td>BookName</td>
                    <td>RentalDate</td>
                    <td>ReturnDate</td>
                </tr>
                </thead>
                <c:forEach var="rental" items="${rentals}">
                    <tr>
                        <td>${rental.rentalNum}</td>
                        <td>${rental.bookName}</td>
                        <td>${rental.rentalDate}</td>
                        <td>${rental.returndate}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
