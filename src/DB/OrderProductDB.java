package DB;

import bean.OrderProductBean;


public class OrderProductDB extends DB {
    public OrderProductDB() {
    }

    public boolean insert(String customerId, String productId, String qty) {
        return updateQuery("INSERT INTO orderProduct VALUES("
                + customerId +","
                + productId + ","
                + qty
                + ")"
        );
    }

    public boolean insert(OrderProductBean orderProduct) {
        return insert(orderProduct.getCustomerId(),
                orderProduct.getProductId(),
                orderProduct.getQty());
    }

    @Override
    public String getTableName() {
        return "orderProduct";
    }
}
