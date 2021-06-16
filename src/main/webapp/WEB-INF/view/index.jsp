<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>

<head>
    <meta charset="UTF-8">
    <title>도서관</title>
</head>
<style>
    <%@include file ="/css/index.css" %>
</style>
<body>
<div id="header">
    <div class="container">
        <div class="header">
            <div class="header_menu">     <%--나중에 로그인 상태면 로그아웃 하는거 보여주게 해야할듯? --%>
                <a href="/front/register">Register</a>
                <a href="/front/login">Login</a>
            </div>
            <div class="header_tit">
                <h1>키범 도서관</h1>
            </div>
        </div>
    </div>
</div>
<main>
    <div id="cont_left">
        <div class="container">
            <div class="column">
                <h4 class="col_tit">Menu</h4>
                <div class="menu">
                    <div class="item">
                        <a href="">전체 책 조회</a>
                    </div>
                    <div class="item">
                        <a href="">대출 현황 조회</a>
                    </div>
                    <div class="item">
                        <a href="">반납</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
</body>

</html>