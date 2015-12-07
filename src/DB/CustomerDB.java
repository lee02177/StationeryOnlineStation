package DB;

import bean.CustomerBean;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lee on 7/12/2015.
 */
public class CustomerDB extends DB {
    public CustomerDB() {
    }

    @Override
    public String getTableName() {
        return "customer";
    }

    public CustomerBean getById(String id) throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM customer WHERE id =" + id);
        if (rs.next()) {
            CustomerBean customer = new CustomerBean();
            customer.setId(rs.getInt("id") + "");
            customer.setName(rs.getString("name"));
            customer.setType(rs.getString("customer"));
            return customer;
        }
        else
            return null;
    }


    public boolean validate(String id, String password) throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM customer where "
                + "id = " + id
                + " password = '" + password + "'");
        if (rs == null)
            return false;
        else
            return true;
    }
}
