<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="bean.*, java.util.*" %>
<%@ page import="java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Stationary Station - Order List</title>
</head>
<body bgcolor="#D3D3D3">
<jsp:include page="hander.jsp"/>
<%
    try {
        ArrayList<OrderBean> orderlist
                = (ArrayList<OrderBean>) request.getAttribute("orderlist");

        out.println("you have " + orderlist.size() + " order");


        out.println("<table border='1' cellspacing='0'>");
        out.println("<tr>");
        out.println("<th>Order No.</th>"
                + "<th>Client </th>"
                + "<th>Delivery Date</th>"
                + "<th>Status</th>");
        if (orderlist.size() > 1)
            out.println("<th>&nbsp;</th>");
        out.println("</tr>");
        for (int i = 0; i < orderlist.size(); i++) {
            OrderBean ob = orderlist.get(i);
            CustomerBean c = ob.getCustomerById();
            out.println("<tr>");
            out.println("<td>" + ob.getId() + "</td>");
            out.println("<td>" + c.getName() + "</td>");
            out.println("<td>" + ob.getDate() + "</td>");
            out.println("<td>" + ob.getStatus() + "</td>");
            if (ob.getStatus().equals("cancel"))
                out.println("<td>&nbsp;</td>");
            else
                out.println("<td><a href='handleOrder?action=cancel&id=" + ob.getId() + "'>x</a></td>");
            out.println("</tr>");
        }
        out.println("</table>");
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
</body>
</html>
