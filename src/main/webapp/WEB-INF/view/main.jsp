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
                        <form class = "form" action="/front/Books/show" target="iframe1">
                            <div class="items">
                                <div class="item-heading">
                                    <button type="submit" class="button">전체 책 정보 조회</button>
                                    <div class="item">
                                        <iframe class="iframe" name="iframe1">
                                        </iframe>
                                    </div>
                                </div>
                            </div>
                        </form>
                        <form class = "form" action="/front/RentalManagement/loan" target="iframe2" onsubmit="return isLogin(${userID})">
                            <div class="items">
                                <div class="item-heading">
                                    <button name="id" type="submit" class="button" value="${userNum}">대출 현황 조회
                                    </button>
                                    <div class="item">
                                        <iframe class="iframe" name="iframe2">
                                        </iframe>
                                    </div>
                                </div>
                            </div>
                        </form>
                        <form class = "form" action="" target="iframe3">
                            <div class="items">
                                <div class="item-heading">
                                    <button type="submit" class="button">반납</button>
                                    <div class="item">
                                        <iframe class="iframe" name="iframe3">

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
                    <div id="hidden-frame">
                        <div class="item">
                            <iframe class="iframe" name="iframe4">
                            </iframe>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id = "cont_menu">
            <div class="container">
                <div class = "column man">
                    <div id = "sideNav" class = "sidebar">
                        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                    </div>
                    <h4 class = "open" onclick="openNav()">Manager Menu</h4>
                </div>
                <div class = "column man2">
                    <h4 class = "col_man">Manager Menu</h4>
                    <div class = "menu">
                        <form class = "form1" action="/front/BooksManagement/create" target="iframe5">
                            <div class="items">
                                <div class="item-heading">
                                    <button type="submit" class="button">책 추가</button>
                                    <div class="item">
                                        <iframe class="iframe" name="iframe5">
                                        </iframe>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <jsp:include page="./Layout/footer.jsp"/>
</div>
<script>
    <%@include file ="/script/script.js" %>
</script>
</body>

</html>