<%-- 
    Document   : registerAccount
    Created on : Nov 28, 2015, 4:33:47 PM
    Author     : IBM888HK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function goBack() {
                window.history.back();
            }
        </script>
    </head>
    <body bgcolor="LightGray">
    <jsp:include page="hander.jsp"/>
        <fieldset>
            <legend>Registraion Form</legend>
            <form method="post" action = "handleRegister">
                Full Name:   <input name="name" type="text" ><br/><br/>
                Phone No:<input name="tel" type="text" ><br/><br/>
                Address:     <input name="address" type="text" ><br/><br/>
                Credit Amount: <input name="credit" type="text" ><br>
                <input type="submit" value="Register" /> &nbsp;
            </form>
            <form action="index.jsp">
                <input type="submit" value="Back">
            </form>
        </fieldset>
    </body>
</html>
