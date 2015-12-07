package DB;

import bean.OrderBean;
import bean.OrderProductBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class OrderDB extends DB {
    public OrderDB() {
    }

    public ArrayList<OrderBean> getAll() throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM orderlist");
        return resultToList(rs);
    }

    public boolean cancelOrderById(String id) {
        return updateQuery("UPDATE orderlist SET status = 'cancel' WHERE id =" + id);
    }


    public ArrayList<OrderBean> getByCustomerId(String id) throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM orderlist WHERE customerId = " + id);
        return resultToList(rs);
    }


    public boolean insert(String id, String date, String status, String customerId) {
        return updateQuery("INSERT INTO orderlist VALUES("
                + id + " ,"
                + " '" + date + "' ,"
                + " '" + status + "' ,"
                + customerId
                + ")");
    }

    public boolean insert(OrderBean order) {
        return insert(order.getId(),
                order.getDate(),
                order.getStatus(),
                order.getCustomerId());
    }

    public ArrayList<OrderBean> resultToList(ResultSet rs) throws SQLException {
        ArrayList<OrderBean> list = new ArrayList<OrderBean>();
        while (rs.next()) {
            OrderBean order = new OrderBean();
            order.setId(rs.getInt("id") + "");
            order.setDate(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("date")));
            order.setStatus(rs.getString("status"));
            order.setCustomerId(rs.getString("customerId"));
            list.add(order);
        }
        return list;
    }


    @Override
    public String getTableName() {
        return "orderlist";
    }
}
