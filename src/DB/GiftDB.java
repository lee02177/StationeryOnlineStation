package DB;

import bean.GiftBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class GiftDB extends DB {
    public GiftDB() {
    }

    public ArrayList<GiftBean> getAll() throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM gift");
        return resultToList(rs);
    }

    public GiftBean getById(String id) throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM gift WHERE id = " + id);
        if (rs.next()) {
            GiftBean gift = new GiftBean();
            gift.setId(rs.getInt("id")+"");
            gift.setName(rs.getString("name"));
            gift.setPointsRequired(rs.getInt("pointsRequired"));
            return gift;
        } else {
            return null;
        }
    }

    public ArrayList<GiftBean> resultToList(ResultSet rs) throws SQLException {
        ArrayList<GiftBean> gifts = new ArrayList<GiftBean>();
        while (rs.next()) {
            GiftBean gift = new GiftBean();
            gift.setId(rs.getInt("id") + "");
            gift.setName(rs.getString("name"));
            gift.setPointsRequired(rs.getInt("pointsRequired"));
            gifts.add(gift);
        }
        return gifts;
    }

    @Override
    public String getTableName() {
        return "gift";
    }
}
