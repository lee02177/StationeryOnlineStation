
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="LightGray">
<jsp:include page="hander.jsp"/>
    have not enough bonus!
    <form action="index.jsp">
        <input type="submit" value="Back to home">
    </form>

    <form action="gift" method="get">
        <input type="hidden" value="list" name="action">
        <input type="submit" value="back to choose">
    </form>
</body>
</html>
