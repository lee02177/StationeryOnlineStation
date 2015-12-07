package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lee on 7/12/2015.
 */
@WebServlet(urlPatterns = "/handleOrder")
public class HandleOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher dispatcher;
        if (action.equals("place")) {
            dispatcher = req.getRequestDispatcher("/placeOrder.jsp");
            dispatcher.forward(req, resp);
        } else if (action.equals("submit")) {
            String date = req.getParameter("date");
            if (date == null || date.equals("")) {
                dispatcher = req.getRequestDispatcher("/invalidDate.jsp");
                dispatcher.forward(req, resp);
            } else {

            }
        }
    }
}
