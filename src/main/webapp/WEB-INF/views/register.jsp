<%--
  Created by IntelliJ IDEA.
  User: Hh
  Date: 2018/1/23
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user" , method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input name="userName" type="text"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input name="password" type="password"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="注册"></td>
        </tr>
    </table>
</form>
</body>
</html>
