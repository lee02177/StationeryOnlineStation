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
            customer.setType("customer");
            return customer;
        } else
            return null;
    }

    public boolean insert(String id, String name, String tel, String address, String bonus, String credit) {
        return updateQuery("INSERT INTO customer VALUES("
                + id
                + ", '" + name + "'"
                + ", null"
                + ", null"
                + ", '" + tel + "'"
                + ", '" + address + "'"
                + ", " + bonus
                + ", " + credit
                + ")"
        );
    }


    public boolean insert(CustomerBean customer) {
        return insert(customer.getId() + "",
                customer.getName(),
                customer.getTel(),
                customer.getAddress(),
                customer.getBonus() + "",
                customer.getCredit() + "");
    }


    public boolean validate(String id, String password) throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM customer where "
                + "id = " + id + " AND "
                + "password = '" + password + "'");
        if (rs.next())
            return true;
        else
            return false;
    }
}
