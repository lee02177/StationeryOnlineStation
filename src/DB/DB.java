package DB;

import java.sql.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee on 7/12/2015.
 */
public abstract class DB extends HttpServlet {
    //    String url = "jdbc:mysql://localhost:3306/assdb";
    String url = "jdbc:mysql://localhost:3306/assdb";
    String username = "root";
    String password = "";

    public DB() {

    }

    public Connection getConnection() throws IOException, SQLException {
        System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);

    }

    public ResultSet executeQuery(String sql) {
        Connection cnnct;
        PreparedStatement pStmnt;
        ResultSet rs = null;
        try {
            cnnct = getConnection();
            pStmnt = cnnct.prepareStatement(sql);
            rs = pStmnt.executeQuery();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return rs;
    }

    public boolean updateQuery(String sql) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            pStmnt = cnnct.prepareStatement(sql);
            int rowCount = pStmnt.executeUpdate();
            if (rowCount == 1) {
                isSuccess = true;
            }
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public abstract String getTableName();

    public int getLastId() throws SQLException {
        ResultSet rs = executeQuery("SELECT MAX(id) as id FROM " + getTableName());
        if(rs.next())
            return rs.getInt("id") +1;
        else
            return 0;
    }

}
