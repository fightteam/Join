<%--
  Created by IntelliJ IDEA.
  User: lzy77_000
  Date: 13-4-28
  Time: 下午1:21
  默认样式
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title><sitemesh:title/></title>
    <sitemesh:head></sitemesh:head>
</head>

<body>
<%@ include file="/WEB-INF/layouts/common/header.jsp"%>
        <sitemesh:body></sitemesh:body>
<%@ include file="/WEB-INF/layouts/common/footer.jsp"%>
</body>
</html>