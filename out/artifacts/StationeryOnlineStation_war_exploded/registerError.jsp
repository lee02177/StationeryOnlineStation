<%-- 
    Document   : registerError
    Created on : 2015年11月30日, 上午02:23:55
    Author     : IBM888HK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="LightGray">
    <jsp:include page="hander.jsp"/>
        Invalid data!
        <br>
        <form action="register.jsp" method="post">
            <input type="submit" value="Register again">
        </form>
        <form action="index.jsp">
            <input type="submit" value="Back to home">
        </form>
    </body>
</html>
