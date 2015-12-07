package bean;

import DB.GiftDB;

import java.sql.SQLException;

/**
 * Created by Lee on 7/12/2015.
 */
public class RedeemGiftBean  {
    String id;
    String customerId;
    String giftId;

    public RedeemGiftBean() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getGiftId() {
        return giftId;
    }

    public void setGiftId(String giftId) {
        this.giftId = giftId;
    }

    public GiftBean getGiftById() throws SQLException {
        return new GiftDB().getById(giftId);
    }
}
