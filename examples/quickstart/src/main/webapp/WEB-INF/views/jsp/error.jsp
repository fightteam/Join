<%--
  Created by IntelliJ IDEA.
  User: lzy77_000
  Date: 13-5-5
  Time: 上午10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title></title>
</head>
<body>

<div class="row">
    <div class="span12">
        <div class="hero-unit">
            <h1>Oops! An error encountered!</h1>
            <br/>
            <h2>${exception}</h2>
            <br/>
        </div>
        <p>${stack}</p>
        <br/>
    </div>
</div>
</body>
</html>