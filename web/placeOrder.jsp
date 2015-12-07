<%@ page import="bean.ShoppingCartBean" %>
<%@ page import="bean.CustomerBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="#d3d3d3">
<div>
    <jsp:include page="hander.jsp"/>
</div>
<div>
    <jsp:include page="showShoppingCart.jsp"/>
</div>
<%
    CustomerBean user = (CustomerBean) session.getAttribute("user");
    ShoppingCartBean shoppingCart = (ShoppingCartBean) session.getAttribute("shoppingCart" + user.getId());
    int i = shoppingCart.getTotalAmount();
    out.println("You can get " + ((int) (i / 1000)) * 100 + " bonus");
%>
<div>
    <form action="handleOrder" method="post">
        <table border="1">
            <input type="hidden" name="action" value="submit">
            <tr>
                <td>Select delivery date:</td>
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
