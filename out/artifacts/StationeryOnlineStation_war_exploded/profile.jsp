<%@ page import="bean.CustomerBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="LightGray">
<jsp:include page="hander.jsp"/>
<%
    CustomerBean user = (CustomerBean) session.getAttribute("user");
%>

<form action="handleCustomer" method="post">
    <input type="hidden" value="update" name="action">
    <table border="1">
        <caption>Profile</caption>
        <tr>
            <td>User id:</td>
            <td><%=user.getId()%>
            </td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="<%=user.getName()%>"></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><input type="text" name="tel" value="<%=user.getTel()%>"></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><textarea name="address" id="" cols="30" rows="10"><%=user.getAddress()%></textarea></td>
        </tr>
        <tr>
            <td>Bonus Point:</td>
            <td><%=user.getBonus()%>
            </td>
        </tr>
        <tr>
            <td>Credit Amount:</td>
            <td><%=user.getCredit()%></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><input type="submit" value="Update"></td>
        </tr>
    </table>
</form>
</body>
</html>
