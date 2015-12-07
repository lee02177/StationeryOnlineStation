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
@WebServlet(urlPatterns = "/handleRegister")
public class HandleRegister extends HttpServlet {
    CustomerDB db = new CustomerDB();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String tel = req.getParameter("tel");
        String address = req.getParameter("address");
        String credit = req.getParameter("credit");
        RequestDispatcher dispatcher;
        try {
            if (name == null || name.equals("")
                    || tel == null || tel.equals("")
                    || address == null || address.equals("")
                    || credit == null || credit.equals("")) {
                dispatcher = req.getRequestDispatcher("/registerError.jsp");
                dispatcher.forward(req, resp);
            } else {
                CustomerBean customer = new CustomerBean();
                customer.setId(db.getLastId() + "");
                customer.setName(name);
                customer.setAddress(address);
                customer.setTel(tel);
                customer.setBonus(0);
                customer.setCredit(Integer.parseInt(credit));
                if(db.insert(customer))
                    dispatcher = req.getRequestDispatcher("/registerSuccess.jsp");
                else
                    dispatcher = req.getRequestDispatcher("registerError.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
