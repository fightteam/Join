<%--
  Created by IntelliJ IDEA.
  User: faith
  Date: 14-2-20
  Time: 下午6:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title></title>
</head>
<body>
<ul>
    <li><a href="users">用户</a></li>
    <li><a href="roles">角色</a></li>
    <li><a href="permissions">权限</a></li>
    <li><a href="resources">资源</a></li>
    <li><a href="operations">操作</a></li>
</ul>

</body>
</html>
