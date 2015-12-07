<%@ page import="bean.CustomerBean" %>
<%@ page import="bean.ShoppingCartBean" %>
<%@ page import="bean.ProductBean" %>
<%@ page import="java.util.ArrayList" %>
<%
    String aaa = (String) request.getAttribute("aaa");
    if (aaa == null)
        aaa = "888";
    if (session.getAttribute("user") != null) {
        CustomerBean user = (CustomerBean) session.getAttribute("user");
        ShoppingCartBean shoppingCart = (ShoppingCartBean) session.getAttribute("shoppingCart" + user.getId());
        out.println("<table border='1'>");
        if (!aaa.equals("999"))
            out.println("<caption>Shopping Cart</caption>");
        else
            out.println("<caption>Your order</caption>");
        out.println("<tr>"
                + "<th>Product Name</th>"
                + "<th>Price</th>"
                + "<th>Quantity</th>"
                + "<th>Subtotal</th>");
        if (shoppingCart.size() > 0 && !aaa.equals("999"))
            out.println("<th>&nbsp;</th>");
        out.println("<tr>");
        if (shoppingCart.size() > 0) {
            ArrayList<ProductBean> itemList = shoppingCart.getProductlist();
            ArrayList<String> quantityList = shoppingCart.getQuantityList();
            int sum = 0;
            for (int i = 0; i < itemList.size(); i++) {
                ProductBean p = itemList.get(i);
                int q = Integer.parseInt(quantityList.get(i));
                sum += p.getPrice() * q;
                out.println("<tr>"
                        + "<td>" + p.getName() + "</td>"
                        + "<td>" + p.getPrice() + "</td>"
                        + "<td>" + q + "</td>"
                        + "<td>" + (p.getPrice() * q) + "</td>");
                if (!aaa.equals("999"))
                    out.println("<td><a href=handleShoppingCart?action=remove&id=" + p.getId() + ">x</a></td>"
                    );
            }
            out.println("<tr>");
            if (!aaa.equals("999"))
                out.println("<td><a href=handleShoppingCart?action=clear>clear all</a></td>");
            else
                out.println("<td>&nbsp;</td>");
            out.println("<td>&nbsp;</td>"
                    + "<td>Total:</td>"
                    + "<td>" + sum + "</td>");

            if (!aaa.equals("999"))
                out.println("<td><a href=handleShoppingCart?action=buy>Buy</a></td>");
            out.println("</tr>");
        } else {
            out.println("<td colspan=4> Empty</td");
        }
    }
%>

