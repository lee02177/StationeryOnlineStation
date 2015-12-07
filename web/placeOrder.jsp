<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 7/12/2015
  Time: 下午11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <jsp:include page="showShoppingCart.jsp"/>
</div>
<div>
    <form action="handleOrder" method="post">
        <table border="1">
            <tr><input type="date" name="date"></tr>
        </table>
    </form>
</div>
</body>
</html>
