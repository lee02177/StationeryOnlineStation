<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 8/12/2015
  Time: 上午3:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="LightGray">
<jsp:include page="hander.jsp"/>
    Successful redeem gift!
    <form action="handleGift">
        <input type="hidden" name="action" value="list">
        <input type="submit" value="continue redeem gift">
    </form>
    <form action="index.jsp">
        <input type="submit" value="back to home">
    </form>
</body>
</html>
