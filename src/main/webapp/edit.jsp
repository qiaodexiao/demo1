<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/11
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>用户信息</h1>
<form action="/saveOrUpdate" method="post">
    <input type="hidden" name="id" value="${user.id}">
    用户电话:<input type="text" name="tel" value="${user.tel}"/><br/>
    用户姓名:<input type="text" name="tname" value="${user.tname}"/><br/>
    <input type="submit" value="保存"/>
</form>
</body>
</html>
