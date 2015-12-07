package bean;

/**
 * Created by Lee on 7/12/2015.
 */
public class OrderProductBean {
    String customerId;
    String productId;
    String qty;

    public OrderProductBean() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
}
