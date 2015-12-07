package servlet;

import DB.CustomerDB;
import DB.OrderDB;
import DB.OrderProductDB;
import bean.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Lee on 7/12/2015.
 */
@WebServlet(urlPatterns = "/handleOrder")
public class HandleOrder extends HttpServlet {
    CustomerDB cdb = new CustomerDB();
    OrderDB odb = new OrderDB();
    OrderProductDB opdb = new OrderProductDB();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher dispatcher;
        try {
            if (action.equals("place")) {
                req.setAttribute("aaa", "999");
                dispatcher = req.getRequestDispatcher("/placeOrder.jsp");
                dispatcher.forward(req, resp);
            } else if (action.equals("submit")) {
                String date = req.getParameter("date");
                if (date == null || date.equals("")) {
                    dispatcher = req.getRequestDispatcher("/invalidDate.jsp");
                    dispatcher.forward(req, resp);
                } else {
                    CustomerBean user = (CustomerBean) req.getSession().getAttribute("user");
                    CustomerBean customer = cdb.getById(user.getId());
                    ShoppingCartBean scb = (ShoppingCartBean) req.getSession().getAttribute("shoppingCart" + user.getId());
                    if (customer.getCredit() < scb.getTotalAmount()) {
                        dispatcher = req.getRequestDispatcher("/notEnoughCredit.jsp");
                        dispatcher.forward(req, resp);
                    } else {
                        customer.setCredit(customer.getCredit()-scb.getTotalAmount());

                        OrderBean order = new OrderBean();
                        order.setId(odb.getLastId()+"");
                        order.setDate(date);
                        order.setStatus("unconfirmed");
                        order.setCustomerId(customer.getId());
                        odb.insert(order);

                        ArrayList<ProductBean> itemList = scb.getProductlist();
                        ArrayList<String> qtyList = scb.getQuantityList();
                        for(int i=0; i<itemList.size(); i++)
                        {
                            OrderProductBean orderProduct = new OrderProductBean();
                            orderProduct.setCustomerId(customer.getId());
                            orderProduct.setProductId(itemList.get(i).getId()+"");
                            orderProduct.setQty(qtyList.get(i)+"");
                            opdb.insert(orderProduct);
                        }
                        cdb.update(customer);
                        scb.claer();
                        resp.sendRedirect(req.getContextPath() + "/handleOrder?action=list");
                        return;
                    }
                }
            }else if (action.equals("list"))
            {
                ArrayList<OrderBean> orderlist = new OrderDB().getAll();
                req.setAttribute("orderlist", orderlist);
                dispatcher = req.getRequestDispatcher("/showOrder.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
