
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="hander.jsp"/>
You not enough credit to buy
<form action="index.jsp">
    <input type="submit" value="back to home">
</form>

<form action="handleProduct" method="get">
    <input type="hidden" name="action" value="list">
    <input type="submit" value="back to shopping">
</form>
</body>
</html>
