package DB;

import bean.RedeemGiftBean;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Lee on 7/12/2015.
 */
public class RedeemGiftDB extends DB {
    public RedeemGiftDB() {
    }

    public ArrayList<RedeemGiftBean> getAll() {

    }

    public boolean insert(String id, String customerId, String giftId) {
        return updateQuery("INSERT INTO redeemgift VALUES("
                + id + ", "
                + customerId + ", "
                + giftId
                + ")");
    }

    public boolean insert(RedeemGiftBean redeemGift)
    {
        return insert(redeemGift.getId(),
                redeemGift.get)
    }


    @Override
    public String getTableName() {
        return "redeemgift";
    }
}
