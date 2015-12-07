<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="bean.*, java.util.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="LightGray">
<jsp:include page="hander.jsp"/>
<%
    ArrayList<GiftBean> giftList
            = (ArrayList<GiftBean>) request.getAttribute("giftList");
    out.println("<table border='1' cellspacing='0'>");
    out.println("<th>Gift Name</th>"
            + "<th>Points Required</th>");
    if (session.getAttribute("user") != null)
        out.println("<th>&nbsp;</th>");
    for (int i = 0; i < giftList.size(); i++) {
        GiftBean g = giftList.get(i);
        out.println("<tr>");
        out.println("<td>" + g.getName() + "</td>");
        out.println("<td>" + g.getPointsRequired() + "</td>");
        if (session.getAttribute("user") != null)
            out.println("<td><a href='handleGift?action=redeem&id=" + g.getId() + "'>redeem</a></td>");
        out.println("</tr>");
    }
    out.println("</table>");
%>
</body>
</html>
