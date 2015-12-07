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
            customer.setUsername(rs.getString("username"));
            customer.setPassword(rs.getString("password"));
            customer.setType("customer");
            customer.setTel(rs.getString("tel"));
            customer.setAddress(rs.getString("address"));
            customer.setBonus(rs.getInt("bonus"));
            customer.setCredit(rs.getInt("credit"));
            return customer;
        } else
            return null;
    }

    public CustomerBean getByName(String name) throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM customer WHERE username ='" + name + "'");
        if (rs.next()) {
            CustomerBean customer = new CustomerBean();
            customer.setId(rs.getInt("id") + "");
            customer.setName(rs.getString("name"));
            customer.setUsername(rs.getString("username"));
            customer.setPassword(rs.getString("password"));
            customer.setType("customer");
            customer.setTel(rs.getString("tel"));
            customer.setAddress(rs.getString("address"));
            customer.setBonus(rs.getInt("bonus"));
            customer.setCredit(rs.getInt("credit"));
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

    public boolean update(String id, String name, String username, String password, String tel, String address, String bonus, String credit) {
        return updateQuery("UPDATE customer SET "
                + "name ='" + name + "' ,"
                + "username ='" + username + "' ,"
                + "password ='" + password + "' ,"
                + "tel ='" + tel + "' ,"
                + "address ='" + address + "' ,"
                + "bonus =" + bonus + ", "
                + "credit =" + credit + " "
                + "WHERE id = " + id);
    }

    public boolean update(CustomerBean customerBean) {
        return update(customerBean.getId(),
                customerBean.getName(),
                customerBean.getUsername(),
                customerBean.getPassword(),
                customerBean.getTel(),
                customerBean.getAddress(),
                customerBean.getBonus() + "",
                customerBean.getCredit() + "");
    }


    public boolean insert(CustomerBean customer) {
        return insert(customer.getId() + "",
                customer.getName(),
                customer.getTel(),
                customer.getAddress(),
                customer.getBonus() + "",
                customer.getCredit() + "");
    }

    public boolean remove(String id)
    {
        return updateQuery("DELETE FROM customer WHERE id =" + id);
    }


    public boolean validate(String username, String password) throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM customer where "
                + "username = '" + username + "' AND "
                + "password = '" + password + "'");
        if (rs.next())
            return true;
        else
            return false;
    }
}
