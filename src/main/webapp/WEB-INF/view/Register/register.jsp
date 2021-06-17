<%--
  Created by IntelliJ IDEA.
  User: 4012s
  Date: 2021-06-17
  Time: 오후 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>회원가입 - Member Register</title>
    <style>
        a {
            text-decoration:none
        }

        body{
            font-size:12px;
            font-family:'Arial';
        }
        #login_wrapper
        {
            display : flex;
            height : 100vh;
            justify-content: center;
            align-items : center;
        }
        #registerTbl{
            width:600px;
            height:500px;
            border:1px solid #e2e2e2;
            text-align:center;
            margin:1px;
        }
        *{ box-sizing: border-box; margin: 0px; }
        div{
            text-align:center;
        }
    </style>
</head>

<body>

<style>
    <%@include file ="/css/login.css" %>
</style>

<div id="login_wrapper">
    <form action = "/front/Register/register" method = "post">
        <table id="registerTbl">
            <colgroup>
                <col width="30%"/>
                <col width="35%"/>
                <col width="35%"/>
            </colgroup>
            <tr>
                <td colspan = 3; bgColor = "F3F3F3">
                    <h4>회원가입 화면</h4>
                </td>
            </tr>
            <tr height = "10%">
                <td colspan = 3; style="border-top:1px solid #e2e2e2">
                </td>
            </tr>
            <tr height = "15%">
                <td colspan = 1; style = "border-top:1px solid #e2e2e2; text-align:center;">
                    아이디<br>(userID)
                </td>
                <td colspan = 2; style="border-left:1px solid #e2e2e2; border-top:1px solid #e2e2e2; text-align:center;">
                    <input type="text" name="id" style="width:90%; height:60%" placeholder="userID">
                </td>
            </tr>
            <tr height = "15%">
                <td colspan = 1; style="border-top:1px solid #e2e2e2; text-align:center;">
                    비밀번호<br>(password)
                </td>
                <td colspan = 2; style="border-left:1px solid #e2e2e2; border-top:1px solid #e2e2e2; text-align:center;">
                    <input type="password" name="pw" style="width:90%; height:60%" placeholder="password">
                </td>
            </tr>
            <tr height = "15%">
                <td colspan = 1; style = "border-top:1px solid #e2e2e2; text-align:center;">
                    이름<br>(userName)
                </td>
                <td colspan = 2; style="border-left:1px solid #e2e2e2; border-top:1px solid #e2e2e2; text-align:center;">
                    <input type="text" name="name" style="width:90%; height:60%" placeholder="userID">
                </td>
            </tr>
            </tr>
            <tr height = "10%">
                <td colspan = 3; style="border-top:1px solid #e2e2e2">
                </td>
            </tr>
            <tr>
                <td colspan = 3; style="border-top:1px solid #e2e2e2; text-align:center;" bgColor = "F3F3F3">
                    <input type="submit" value="회원가입(Register)" style = "width:50%; height : 60%">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>

</html>
