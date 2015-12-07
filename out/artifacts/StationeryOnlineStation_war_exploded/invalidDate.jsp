
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="LightGray">
<jsp:include page="hander.jsp"/>
Invalid date!
<form action="handleShoppingCart" method="post">
    <input type="hidden" name="action" value="buy">
    <input type="submit" value="input again">
</form>

<form action="handleProduct" method="get">
    <input type="hidden" value="list" name="action">
    <input type="submit" value="back to shopping">
</form>
<form action="index.jsp">
    <input type="submit" value="to home">
</form>
</body>
</html>
