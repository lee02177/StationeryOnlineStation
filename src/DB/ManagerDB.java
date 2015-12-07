package DB;

import bean.ManagerBean;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lee on 7/12/2015.
 */
public class ManagerDB extends DB {

    public ManagerDB() {
    }

    public ManagerBean getById(String id) throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM manager WHERE id = " + id);
        if(rs.next())
        {
            ManagerBean manager = new ManagerBean();
            manager.setId(rs.getInt("id")+ "");
            manager.setName(rs.getString("name"));
            manager.setType("manager");
            return manager;
        }
        else
            return null;
    }

    public boolean validate(String username, String password) throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM manager where "
                + " username = '" + username + "' AND "
                + " password = '" + password + "'");
        if (rs.next() )
            return true;
        else
            return false;
    }

    @Override
    public String getTableName() {
        return "manager";
    }

}
