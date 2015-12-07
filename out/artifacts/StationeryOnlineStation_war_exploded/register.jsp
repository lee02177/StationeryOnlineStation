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
    <body>
        <fieldset>
            <legend>Registraion Form</legend>
            <form method="post" action = "handleCustomer?action=registerSuccess">
                Full Name:   <input name="name" type="text" ><br/><br/>
                Username:    <input name="id" type="text" ><br/><br/>
                Password:    <input name="password" type="password" ><br/><br/>
                Phone No:<input name="tel" type="text" ><br/><br/>
                Address:     <input name="address" type="text" ><br/><br/>
                <input name="bonus" type="hidden" value="0" >
                <input type="submit" value="Register" /> &nbsp;
                <button onclick="goBack()">Back</button>
            </form>
        </fieldset>
    </body>
</html>
