<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 7/12/2015
  Time: 下午11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="hander.jsp"/>
You not enough credit to buy
<form action="index.jsp">
    <input type="submit" value="back to home">
</form>

<form action="handleProduct" method="get">
    <input type="hidden" name="action" value="list">
    <input type="submit" value="back to shopping">
</form>
</body>
</html>
