
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="LightGray">
<jsp:include page="hander.jsp"/>
Logout
<%
    session.setAttribute("user", null);
%>
<form action="index.jsp">
    <input type="submit" value="Go to Home">
</form>
</body>
</html>
