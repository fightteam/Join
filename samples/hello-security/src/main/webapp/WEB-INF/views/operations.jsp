<%--
  Created by IntelliJ IDEA.
  User: faith
  Date: 14-2-20
  Time: 下午7:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>操作管理</title>
</head>
<body>
<ul>
    <li><a href="users">用户</a></li>
    <li><a href="roles">角色</a></li>
    <li><a href="permissions">权限</a></li>
    <li><a href="resources">资源</a></li>
    <li><a href="operations">操作</a></li>
</ul>
<form method="post">
    <input type="text" name="name"/>
    <button type="submit">提交</button>
</form>
</body>
</html>
