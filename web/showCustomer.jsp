<%-- 
    Document   : showCustomer
    Created on : Nov 28, 2015, 5:24:28 PM
    Author     : IBM888HK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bean.*, java.util.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stationsry Station - Customer List</title>
    </head>
    <body>
        <%

            ArrayList<CustomerBean> customer
                    = (ArrayList<CustomerBean>) request.getAttribute("customer");

            out.println(customer.size() + " elements in table customer");

            out.println("<table border='1' cellspacing='0'>");

            out.println("<th>Client ID</th>"
                    + "<th>Name</th>"
                    + "<th>Password</th>"
                    + "<th>Phone No.</th>"
                    + "<th>Address</th>"
                    + "<th>Bonus Point</th>");
            for (int i = 0; i < customer.size(); i++) {
                CustomerBean cb = customer.get(i);
                out.println("<tr>");

                out.println("<td>" + cb.getCustId() + "</td>");
                out.println("<td>" + cb.getName() + "</td>");
                out.println("<td>" + cb.getPassword() + "</td>");
                out.println("<td>" + cb.getTel() + "</td>");
                out.println("<td>" + cb.getAddress() + "</td>");
                out.println("<td>" + cb.getBonus() + "</td>");

                out.println("</tr>");
            }
            out.println("</table>");
        %>

        <!--a href="brandController?action=list>show brand</a-->
    </body>
</html>
