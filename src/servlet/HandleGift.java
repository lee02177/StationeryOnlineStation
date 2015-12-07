package servlet;

import DB.CustomerDB;
import DB.GiftDB;
import DB.RedeemGiftDB;
import bean.CustomerBean;
import bean.GiftBean;
import bean.RedeemGiftBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet (urlPatterns = "/handleGift")
public class HandleGift extends HttpServlet {
    RedeemGiftDB rdb = new RedeemGiftDB();
    CustomerDB cdb = new CustomerDB();
    GiftDB gdb = new GiftDB();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        ArrayList<GiftBean> gifts;
        RequestDispatcher dispatcher;
        try {
            if (action.equals("list")) {
                gifts = gdb.getAll();
                req.setAttribute("giftList", gifts);
                dispatcher = req.getRequestDispatcher("/showGifts.jsp");
                dispatcher.forward(req, resp);
            } else if (action.equals("search")) {

            } else if (action.equals("maintain")) {

            } else if (action.equals("redeem")) {
                String id = req.getParameter("id");
                CustomerBean user = (CustomerBean)req.getSession().getAttribute("user");
                CustomerBean customer = cdb.getById(user.getId());
                GiftBean gift = gdb.getById(id);
                if(customer.getBonus() < gift.getPointsRequired())
                {
                    dispatcher = req.getRequestDispatcher("/notEnoughBonus.jsp");
                    dispatcher.forward(req, resp);
                }
                else
                {
                    RedeemGiftBean redeemGiftBean = new RedeemGiftBean();
                    redeemGiftBean.setId(rdb.getLastId()+"");
                    redeemGiftBean.setCustomerId(customer.getId());
                    redeemGiftBean.setGiftId(gift.getId());
                    rdb.insert(redeemGiftBean);
                    dispatcher = req.getRequestDispatcher("/redeemSuccess.jsp");
                    dispatcher.forward(req, resp);
                }
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
