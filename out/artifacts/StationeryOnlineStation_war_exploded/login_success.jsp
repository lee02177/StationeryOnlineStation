<%@ page import="bean.CustomerBean" %>
<%@ page import="bean.ShoppingCartBean" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="user" type="bean.UserBean" scope="request"/>
<%
    session.setAttribute("user", user);
    if (user instanceof CustomerBean)
    {
        ShoppingCartBean shoppingCart = new ShoppingCartBean();
        session.setAttribute("shoppingCart" + user.getId(), shoppingCart);
    }

%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body bgcolor="LightGray">
<jsp:include page="hander.jsp"/>
Successful login!
<form action="index.jsp" method="post">
    <input type="submit" value="go to shopping"/>
</form>
</body>
</html>
