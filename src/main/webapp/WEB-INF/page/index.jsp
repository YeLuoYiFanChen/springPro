<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h4>用户列表</h4>
    <a href="/edit.do">添加用户</a>


    <table>
        <tr>
            <th>用户名</th>
            <th>密码</th>
            <th>性别</th>
            <th>年龄</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${users}" var="item">
            <tr>
                <td>${item.get("username")}</td>
                <td>${item.get("password")}</td>
                <td>${item.get("sex")}</td>
                <td>${item.get("age")}</td>
                <td><a href="/edit.do?id=${item.get("id")}">编辑</a>
                <a href="/detail.do?id=${item.get("id")}">查看</a>
                <a href="/delete.do?id=${item.get("id")}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
