<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="LightGray">
<jsp:include page="hander.jsp"/>
Invalid data!
<form action="handleCustomer" method="get">
    <input type="hidden" name="action" value="list">
    <input type="submit" value="back to profile">
</form>
<form action="index.jsp">
    <input type="submit" value="back to home">
</form>
</body>
</html>
