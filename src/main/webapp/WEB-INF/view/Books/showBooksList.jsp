<%--
  Created by IntelliJ IDEA.
  User: lsmin
  Date: 2021-06-17
  Time: 오후 3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Show Book List</title>
</head>
<body>
<form action="/front/Books" method="LOOK"  align="center">
    <table align="center">
        <thead>
        <tr>
            <td>No</td>
            <td>BookName</td>
            <td>Writer</td>
            <td>Publisher</td>
            <td>Place</td>
        </tr>
        </thead>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${books.num}</td>
                <td>${books.name}</td>
                <td>${books.writer}</td>
                <td>${books.publisher}</td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
<jsp:include page= "../Layout/footer.jsp"/>
</html>
