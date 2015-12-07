package servlet;

import DB.CustomerDB;
import DB.ManagerDB;
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


@WebServlet(urlPatterns = "/handleLogin")
public class HandleLogin extends HttpServlet {
    ManagerDB mdb = new ManagerDB();
    CustomerDB cdb = new CustomerDB();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        RequestDispatcher dispatcher;

        try {
            if (action.equals("login")) {
                if (username == null || username.equals("") || password == null || password.equals("")) {
                    dispatcher = req.getRequestDispatcher("/login_fail.jsp");
                    dispatcher.forward(req, resp);
                } else if (mdb.validate(username, password)) {
                    UserBean user = mdb.getById("1");
                    req.setAttribute("user", user);
                    dispatcher = req.getRequestDispatcher("/login_success.jsp");
                    dispatcher.forward(req, resp);
                } else if (cdb.validate(username, password)) {
                    UserBean user = cdb.getByName(username);
                    req.setAttribute("shoppingCart", new ShoppingCartBean());
                    req.setAttribute("user", user);
                    dispatcher = req.getRequestDispatcher("/login_success.jsp");
                    dispatcher.forward(req, resp);
                } else {
                    dispatcher = req.getRequestDispatcher("/login_fail.jsp");
                    dispatcher.forward(req, resp);
                }
            } else if (action.equals("logout"))
            {
                dispatcher = req.getRequestDispatcher("/logout.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
