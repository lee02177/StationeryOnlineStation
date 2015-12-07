<%@ page import="bean.UserBean" %>
<%@ page import="bean.CustomerBean" %>
<div style="display: flex; justify-content: space-between">
    <h1>Stationery Online Station </h1>

    <%
        UserBean user = (UserBean) session.getAttribute("user");
        if ((session.getAttribute("user") == null)) {
    %>
    <a href="handleProduct?action=list">Products</a>
    <a href="handleGift?action=list">Gifts</a>
    <a href="register.jsp">Register</a>
    <a href="login.jsp">Login</a>

    <%
    } else {
    %>
    <%
        if (user instanceof CustomerBean) {
    %>
    <a href="handleProduct?action=list">Products</a>
    <a href="handleGift?action=list">Gifts</a>
    <a href="handleOrder?action=list">My order</a>
    <a href="handleShoppingCart?action=list">Shopping cart</a>
    <div>
        Hello,
        <a href=""><%=user.getName()%>
        </a>
    </div>
    <%
    } else {
    %>
    <a href="">Maintain Products</a>
    <a href="">Maintain Gifts</a>
    <a href="">Maintain Orders</a>
    <a href="">Maintain Member</a>
    <a href="">Maintain Register</a>
    Hello, <%=user.getName()%>
    <%
        }
    %>

    <a href="handleLogin?action=logout">Logout</a>
    <%
        }
    %>
</div>