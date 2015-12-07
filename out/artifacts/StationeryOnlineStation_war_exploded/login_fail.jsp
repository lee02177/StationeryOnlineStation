
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="LightGray">
    <jsp:include page="hander.jsp"/>
        Login fail
        <br/>
        <form action="login.jsp">
            <input type="submit" value="Back to Login"/>
        </form>
        <form action="index.jsp">
            <input type="submit" value="Back to home"/>
        </form>
    </body>
</html>
