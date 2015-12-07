<%-- 
    Document   : showOrder
    Created on : Nov 29, 2015, 5:06:44 PM
    Author     : IBM888HK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ict.bean.*, java.util.*, java.sql.Date" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stationary Station - Order List</title>
    </head>
    <body>
        <%
            ArrayList<OrderBean> orderlist 
                    = (ArrayList<OrderBean>) request.getAttribute("orderlist");
            
            out.println(orderlist.size() + " elements in table orderlist");
            
            
            out.println("<table border='1' cellspacing='0'>");

            out.println("<th>Order No.</th>"
                    + "<th>Client ID</th>"
                    + "<th>Type</th>"
                    + "<th>Delivery Date</th>"
                    + "<th>Delivery Status</th>");
            for (int i = 0; i < orderlist.size(); i++) {
                OrderBean ob = orderlist.get(i);
                out.println("<tr>");
                out.println("<td>"+ ob.getOrderNo() +"</td>");
                out.println("<td>"+ ob.getId() +"</td>");
                out.println("<td>"+ ob.getType() +"</td>");
                out.println("<td>"+ ob.getdDate()+"</td>");
                out.println("<td>"+ ob.getStatus()+"</td>");
                
                out.println("</tr>");
            }
            out.println("</table>");
            
        %>
    </body>
</html>
