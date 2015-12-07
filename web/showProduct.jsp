<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 7/12/2015
  Time: 上午1:33
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="bean.*, java.util.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Stationery Station</title>
</head>
<body bgcolor="LightGray">
<jsp:include page="hander.jsp"/>
<%
    //    if ((session.getAttribute("userId") == null) || (session.getAttribute("userId") == "")) {
%>
<div style="display: flex; justify-content: space-between;">

    <div>
        <%
            ArrayList<ProductBean> itemList
                    = (ArrayList<ProductBean>) request.getAttribute("itemList");

            out.println("<table border='1' cellspacing='0'>");
            out.println("<th>Item Name</th>"
                    + "<th>Category</th>"
                    + "<th>Price</th>"
                    + "<th>Description</th>"
            );
            if (session.getAttribute("user") != null) {
                out.println("<th>&nbsp;</th>"
                        + "<th>&nbsp;</th>");
            }

            for (int i = 0; i < itemList.size(); i++) {
                ProductBean p = itemList.get(i);
                out.println("<tr>");
                out.println("<td>" + p.getName() + "</td>");
                out.println("<td>" + p.getCategory() + "</td>");
                out.println("<td>" + p.getPrice() + "</td>");
                out.println("<td>" + p.getInfo() + "</td>");
                if (session.getAttribute("user") != null) {
                    out.println("<td><a href='handleShoppingCart?action=add&id=" + p.getId() + "'>add</a></td>");
                    out.println("<td><a href='handleShoppingCart?action=buy&id=" + p.getId() + "'>buy</a></td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");
        %>
    </div>
    <div>
        <jsp:include page="showShoppingCart.jsp"/>
    </div>
</div>

</body>
</html>
