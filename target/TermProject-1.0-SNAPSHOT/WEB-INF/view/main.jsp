<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>

<head>
    <meta charset="UTF-8">
    <title>도서관</title>
</head>
<style>
    <%@include file ="/css/main.css" %>
</style>
<body>
<div class = "wrapper">
    <jsp:include page="./Layout/header.jsp"/>
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
    <jsp:include page="./Layout/footer.jsp"/>
</div>
</body>

</html>