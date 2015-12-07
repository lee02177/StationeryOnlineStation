package servlet;

import DB.ProductDB;
import bean.CustomerBean;
import bean.ShoppingCartBean;
import bean.UserBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(urlPatterns = "/handleShoppingCart")
public class HandleShoppingCart extends HttpServlet {
    ProductDB db = new ProductDB();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        UserBean user = (UserBean) req.getSession().getAttribute("user");
        ShoppingCartBean scb = (ShoppingCartBean) req.getSession().getAttribute("shoppingCart" + user.getId());
        String id = req.getParameter("id");
        RequestDispatcher dispatcher;
        try {
            if (action.equals("add")) {
                scb.add(db.getById(id), 1 + "");
                resp.sendRedirect(req.getContextPath() + "/handleProduct?action=list");
                return;
            } else if (action.equals("update")) {
                String quantity = req.getParameter("quantity");
                dispatcher = req.getRequestDispatcher("shoppingCart.jsp");
                dispatcher.forward(req, resp);
            } else if (action.equals("remove")) {
                scb.removeById(id);
                resp.sendRedirect(req.getContextPath() + "/handleProduct?action=list");
                return;
            } else if (action.equals("clear")) {
                scb.claer();
                resp.sendRedirect(req.getContextPath() + "/handleProduct?action=list");
                return;
            } else if (action.equals("buy")) {
                if (id != null)
                    scb.add(db.getById(id), 1 + "");
                resp.sendRedirect(req.getContextPath() + "/handleOrder?action=place");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
