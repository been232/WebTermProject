<%@page import="java.util.List"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>Insert Book</title>
</head>

<form action="/front/BooksManagement/create" method="POST"  align="center">
    <table align="center">
        <tr>
            <td>책 번호</td>
            <td><input type="text" name=id /></td>
        </tr>
        <tr>
            <td>책 이름</td>
            <td><input type="text" name=name /></td>
        </tr>
        <tr>
            <td>작가</td>
            <td><input type="text" name=writer /></td>
        </tr>
        <tr>
            <td>출판사</td>
            <td><input type="text" name=publisher /></td>
        </tr>
        <tr>
            <td>도서 위치</td>
            <td><input type="text" name=place /></td>
        </tr>
    </table>
    <input type ="submit" value = "작성">
</form>

<jsp:include page= "../Layout/footer.jsp"/>
</html>