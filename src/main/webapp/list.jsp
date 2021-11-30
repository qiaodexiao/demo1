<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/11
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script>
        function goPage(page) {
            //设置当前页的值
            document.getElementById("currentPage").value = page;
            //提交表单
            var form = document.getElementById("searchForm");
            form.submit();   //提交表单
        }
    </script>

</head>
<body>
<h1>用户信息</h1>
<form id="searchForm" action="/querys" method="post">

    用户电话:<input type="text" name="userTel" value="${qo.userTel}"/>
    用户姓名:<input type="text" name="userName" value="${qo.userName}"/>
    <input type="submit" value="搜索">


    <br/>


<a href="/edit">新增</a>
<table border="1px" width="60%">
    <tr>
        <th>用户编号</th>
        <th>用户电话</th>
        <th>用户姓名</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${result.list}" var="user" varStatus="index">
        <tr>
            <td>${user.id}</td>
            <td>${user.tel}</td>
            <td>${user.tname}</td>
            <td align="center">
                <a href="/edit?id=${user.id}">修改</a>
                <a href="/delete?id=${user.id}">删除</a>
            </td>
        </tr>
    </c:forEach>

    <tr>
        <td colspan="4">
            <a href="javascript:void(0);" onclick="goPage(1)">首页</a>
            <a href="javascript:void(0);" onclick="goPage(${result.prevPage})">上页</a>
            <a href="javascript:void(0);" onclick="goPage(${result.nextPage})">下页</a>
            <a href="javascript:void(0);" onclick="goPage(${result.totalPages})">尾页</a>

            <input type="text" name="currentPage" id="currentPage" value="${qo.currentPage}"/> <input type="submit" value="跳转"/>

            每页显示:
            <select name="pageSize" onchange="goPage(1)">
                <option value="2" ${qo.pageSize == 2?'selected':''}>2</option>
                <option value="3" ${qo.pageSize == 3?'selected':''}>3</option>
                <option value="5" ${qo.pageSize == 5?'selected':''}>5</option>
            </select>

            当前${result.currentPage}页/共${result.totalPages}页/共${result.totalCount}条
        </td>
    </tr>


</table>
</form>
</body>
</html>
