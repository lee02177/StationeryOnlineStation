package servlet;

import DB.ProductDB;
import bean.ProductBean;

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
@WebServlet(name = "HandleProduct", urlPatterns = {"/handleProduct"})
public class HandleProduct extends HttpServlet {
    private ProductDB db = new ProductDB();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        ArrayList<ProductBean> products = null;
        RequestDispatcher dispatcher;
        try {
            if (action.equals("list")) {
                products = db.getAllProducts();
                req.setAttribute("itemList", products);
                dispatcher = req.getRequestDispatcher("/showProduct.jsp");
                dispatcher.forward(req, resp);
            } else if (action.equals("search")) {
                String name = req.getParameter("name");
                String info = req.getParameter("info");
                String category = req.getParameter("category");
                String priceMin = req.getParameter("priceMin");
                String priceMax = req.getParameter("priceMax");
                if (name == null || name.equals(""))
                    name = "%";
                else
                    name = "%" + name + "%";
                if (info == null || info.equals(""))
                    info = "%";
                else
                    info = "%" + info + "%";
                if (category == null || category.equals(""))
                    category = "%";
                else
                    category = "%" + category + "%";
                if(priceMin == null || priceMin.equals(""))
                    priceMin = "0";
                if(priceMax == null || priceMax.equals(""))
                    priceMax = "9999999";

                products = db.search(name, info, category, priceMin, priceMax);
                req.setAttribute("itemList", products);
                dispatcher = req.getRequestDispatcher("/showProduct.jsp");
                dispatcher.forward(req, resp);
            }else if (action.equals("details"))
            {
                String id = req.getParameter("id");
                ProductBean product = db.getById(id);
                req.setAttribute("product", product);
                dispatcher = req.getRequestDispatcher("/showProductDetails.jsp");
                dispatcher.forward(req, resp);
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
