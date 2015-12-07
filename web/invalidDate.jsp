<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 7/12/2015
  Time: 下午11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Invalid date!
    <form action="handleShoppingCart" method="post">
        <input type="hidden" name="action" value="buy">
        <input type="submit" value="input again">
    </form>

    <form action="handleProduct?action=list" method="get">
        <input type="submit" value="back to shopping">
    </form>
    <form action="index.jsp">
        <input type="submit" value="to home">
    </form>
</body>
</html>
