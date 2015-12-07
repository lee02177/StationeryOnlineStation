package bean;

import DB.CustomerDB;

import java.sql.SQLException;

/**
 * Created by Lee on 7/12/2015.
 */
public class OrderBean {
    String id;
    String date;
    String status;
    String customerId;

    public OrderBean() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerBean getCustomerById() throws SQLException {
        return new CustomerDB().getById(customerId);
    }
}
