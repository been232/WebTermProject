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
<div class="wrapper">
    <jsp:include page="./Layout/header.jsp"/>
    <main>
        <div id="cont_top">
            <div class="container">
                <div class="column">
                    <h4 class="col_tit">Menu</h4>
                    <div class="menu">
                        <form id="form1" action="/front/Books" target="iframe1">
                            <div class="items">
                                <div class="item-heading">
                                    <button type="submit" class="button">전체 책 정보 조회</button>
                                    <div class="item">
                                        <iframe class = "iframe" name = "iframe1">
                                            <jsp:include page="./Books/showBooksList.jsp"/>
                                        </iframe>
                                    </div>
                                </div>
                            </div>
                        </form>
                        <form id="form2" action="/front/RentalManagement/laon" target="iframe2">
                            <div class="items">
                                <div class="item-heading">
                                    <button name = "id" type="submit" class="button" onsubmit="isLogin(${userID})" value = "${userID}">대출 현황 조회</button>
                                    <div class="item">
                                        <iframe class = "iframe" name="iframe2">
                                            <jsp:include page="./RentalManagement/loan.jsp"/>
                                        </iframe>
                                    </div>
                                </div>
                            </div>
                        </form>
                        <form id="form3" action="" target="iframe3">
                            <div class="items">
                                <div class="item-heading">
                                    <button type="submit" class="button">반납</button>
                                    <div class="item">
                                        <iframe class = "iframe" name = "iframe3">

                                        </iframe>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div id="cont_bottom">
            <div class="container">
                <div class="column">
                    <div id = "hidden-frame">
                        <div class = "item">
                            <iframe class = "iframe" name = "iframe4">
                                <jsp:include page = "./RentalManagement/loan.jsp"/>
                            </iframe>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <jsp:include page="./Layout/footer.jsp"/>
</div>
</body>
<script>
    <%@include file ="/script/script.js" %>
</script>
</html>