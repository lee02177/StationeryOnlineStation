<%--
    Document   : login_success
    Created on : 2015/12/3, 下午 07:21:19
    Author     : Lee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="user" type="bean.UserBean" scope="request"/>
<%
    if (user == null)
        session.setAttribute("user", null);
    else
        session.setAttribute("user", user);
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
Successful login!
<form action="index.jsp" method="post">
    <input type="submit" value="go to shopping"/>
</form>
</body>
</html>
