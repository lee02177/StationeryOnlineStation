<%@ page import="bean.UserBean" %><%--
    Document   : index
    Created on : Nov 27, 2015, 08:07:28 PM
    Author     : IBM888HK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%
    UserBean user = (UserBean) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Index</title>
</head>
<body bgcolor="LightGray"/>
<h1>Stationery Online Station </h1>
<a href="handleProduct?action=list">Show Product</a> <br/>
<a href="handleCustomer?action=list">Show Customer</a><br/>
<a href="handleOrder?action=list">Show Order List</a><br/>
<%
    if ((session.getAttribute("user") == null)) {
%>
<a href="login.jsp">Login</a></br>
<%
} else {
%>
<label>Hello <%=user.getName()%> </label>
<a href="login?action=logout">Logout</a></br>
<%
    }
%>
<a href="register.jsp">Register</a>
</body>
</html>
