<%-- 
    Document   : login
    Created on : Nov 28, 2015, 4:33:31 PM
    Author     : IBM888HK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body bgcolor="LightGray">
<jsp:include page="hander.jsp"/>
<p align="center">Login account can place order</p>
<form method="post" action="handleLogin">
    <input type="hidden" value="login" name="action"/>
    Username:
    <input type="text" name="username" maxlength="10" size="15"><br/>

    Password:

    <input type="password" name="password" maxlength="10" size="16">
    <br/>
    <input type="submit" value="Login">
</form>
</body>
</html>
