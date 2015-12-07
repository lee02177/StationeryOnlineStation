<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 7/12/2015
  Time: 下午4:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Logout
<%
    session.setAttribute("user", null);
%>
<form action="index.jsp">
    <input type="submit" value="Go to Home">
</form>
</body>
</html>
