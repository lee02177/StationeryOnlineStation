<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="LightGray">
<jsp:include page="hander.jsp"/>
update unsuccess

<form action="handleCustomer" method="get">
    <input type="hidden" value="list" name="action">
    <input type="submit" value="back to profile">
</form>
<form action="index.jsp">
    <input type="submit" value="back to home">
</form>
</body>
</html>
