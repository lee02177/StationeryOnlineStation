
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="LightGray">
<jsp:include page="hander.jsp"/>
    Successful redeem gift!
    <form action="handleGift">
        <input type="hidden" name="action" value="list">
        <input type="submit" value="continue redeem gift">
    </form>
    <form action="index.jsp">
        <input type="submit" value="back to home">
    </form>
</body>
</html>
