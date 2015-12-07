package servlet;

import DB.GiftDB;
import bean.GiftBean;

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
@WebServlet (urlPatterns = "/handleGift")
public class HandleGift extends HttpServlet {
    GiftDB db = new GiftDB();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        ArrayList<GiftBean> gifts;
        RequestDispatcher dispatcher;
        try {
            if (action.equals("list")) {
                gifts = db.getAll();
                req.setAttribute("giftList", gifts);
                dispatcher = req.getRequestDispatcher("/showGifts.jsp");
                dispatcher.forward(req, resp);
            } else if (action.equals("search")) {

            } else if (action.equals("maintain")) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
