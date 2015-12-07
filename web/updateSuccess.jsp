<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 8/12/2015
  Time: 上午4:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="LightGray">
<jsp:include page="hander.jsp"/>
update success

<form action="handleCustomer" method="get">
    <input type="hidden" value="list" name="action">
    <input type="submit" value="back to profile">
</form>
<form action="index.jsp">
    <input type="submit" value="back to home">
</form>
</body>
</html>
