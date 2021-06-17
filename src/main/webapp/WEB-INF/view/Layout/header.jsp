<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>

<head>
    <meta charset="UTF-8">
    <title>도서관</title>
</head>
<style>
    <%@include file ="/css/header.css" %>
</style>
<body>
<div id="header">
    <div class="container">
        <div class="header">
            <c:if test="${userID eq null}">
                <div class="header_menu">     <%--나중에 로그인 상태면 로그아웃 하는거 보여주게 해야할듯? --%>
                    <a href="/front/register">Register</a>
                    <a href="/front/Login/login">Login</a>
                </div>
            </c:if>
            <c:if test="${userID ne null}">
                <div class="header_menu">
                    <a href="/front/Logout/logout">Logout</a>
                    <a>${userName} 님 로그인중</a>
                </div>
            </c:if>
            <div class="header_tit">
                <h1>키범 도서관</h1>
            </div>
        </div>
    </div>
</div>
</body>

</html>