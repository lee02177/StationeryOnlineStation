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
<body bgcolor="#d3d3d3">
<div>
    <jsp:include page="hander.jsp" />
</div>
<div>
    <jsp:include page="showShoppingCart.jsp"/>
</div>
<div>
    <form action="handleOrder" method="post">
        <table border="1">
            <input type="hidden" name="action" value="submit">
            <tr>
                <td>Select delivery date: </td>
                <td><input type="date" name="date" placeholder="yyyy-MM-dd"></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>
                    <input type="submit" value="Place">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
