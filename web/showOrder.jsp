<%-- 
    Document   : showOrder
    Created on : Nov 29, 2015, 5:06:44 PM
    Author     : IBM888HK
--%>

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
                = (ArrayList<OrderBean>)request.getAttribute("orderlist");

        out.println("you have " + orderlist.size() + " order");


        out.println("<table border='1' cellspacing='0'>");

        out.println("<th>Order No.</th>"
                + "<th>Client ID</th>"
                + "<th>Delivery Date</th>"
                + "<th>Status</th>");
        for (int i = 0; i < orderlist.size(); i++) {
            OrderBean ob = orderlist.get(i);
            CustomerBean c = ob.getCustomerById();
            out.println("<tr>");
            out.println("<td>" + ob.getId() + "</td>");
            out.println("<td>" + c.getName() + "</td>");
            out.println("<td>" + ob.getDate() + "</td>");
            out.println("<td>" + ob.getStatus() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
</body>
</html>
