package DB;

import bean.RedeemGiftBean;

import java.sql.ResultSet;
import java.util.ArrayList;

public class RedeemGiftDB extends DB {
    public RedeemGiftDB() {
    }

    public ArrayList<RedeemGiftBean> getAll() {
        return null;
    }

    public boolean insert(String id, String customerId, String giftId) {
        return updateQuery("INSERT INTO redeemgift VALUES("
                + id + ", "
                + customerId + ", "
                + giftId
                + ")");
    }

    public boolean insert(RedeemGiftBean redeemGift) {
        return insert(redeemGift.getId(),
                redeemGift.getCustomerId(),
                redeemGift.getGiftId());
    }


    @Override
    public String getTableName() {
        return "redeemgift";
    }
}
