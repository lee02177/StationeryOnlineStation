package servlet;

import DB.CustomerDB;
import bean.CustomerBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Lee on 7/12/2015.
 */
@WebServlet(urlPatterns = "/handleCustomer")
public class HandleCustomer extends HttpServlet {
    CustomerDB cdb = new CustomerDB();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        CustomerBean user = (CustomerBean) req.getSession().getAttribute("user");
        CustomerBean customer;
        RequestDispatcher dispatcher;
        try {
            if (action.equals("list")) {
                customer = cdb.getById(user.getId());
                req.setAttribute("customer", customer);
                dispatcher = req.getRequestDispatcher("/profile.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        CustomerBean user = (CustomerBean) req.getSession().getAttribute("user");
        RequestDispatcher dispatcher;
        if (action.equals("update")) {
            String name = req.getParameter("name");
            String tel = req.getParameter("tel");
            String address = req.getParameter("address");
            if (name == null || name.equals("")
                    || tel == null || tel.equals("")
                    || address == null || address.equals("")) {
                dispatcher = req.getRequestDispatcher("/invalidData.jsp");
                dispatcher.forward(req, resp);
            }
            else
            {
                user.setName(name);
                user.setTel(tel);
                user.setAddress(address);
                if(cdb.update(user))
                {
                    dispatcher = req.getRequestDispatcher("/updateSuccess.jsp");
                    dispatcher.forward(req, resp);
                }
                else
                {
                    dispatcher = req.getRequestDispatcher("/updateFail.jsp");
                    dispatcher.forward(req, resp);
                }

            }
        }
    }
}
