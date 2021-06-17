<%@page import="java.util.List"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>Delete Book</title>
</head>

<form action="/front/BooksManagement/delete" method="POST"  align="center">
    <table align="center">
        <tr>
            <td>책 번호</td>
            <td><input type="text" name=num /></td>
        </tr>
        <tr>
            <td>책 ID</td>
            <td><input type="text" name=id /></td>
        </tr>
    </table>
    <input type ="submit" value = "삭제">
</form>

</html>