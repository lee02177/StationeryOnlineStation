package DB;

import bean.ProductBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProductDB extends DB {

    public ProductDB() {
    }

    @Override
    public String getTableName() {
        return "product";
    }

    public ArrayList<ProductBean> getAllProducts() throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM Product");
        return resultToList(rs);
    }

    public ProductBean getById(String id) throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM Product WHERE id = " + id);
        if (rs.next()) {
            ProductBean product = new ProductBean();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setName(rs.getString("info"));
            product.setCategory(rs.getString("category"));
            product.setPrice(rs.getInt("price"));
            return product;
        } else
            return null;
    }

    public boolean insert(int id, String name, String info, String category, int price) {
        return updateQuery("INSERT INTO Product VALUES("
                + id + ", "
                + "'" + name + "',"
                + "'" + info + "',"
                + "'" + category + "',"
                + price + ")"
        );
    }

    public boolean update(int id, String name, String info, String category, int price) {
        return updateQuery("UPDATE product SET "
                + "name ='" + name + "', "
                + "info ='" + info + "' "
                + "category ='" + category + "' "
                + "price =" + price
                + " WHERE id = " + id
        );
    }

    public boolean delete(int id) {
        return updateQuery("DELETE FROM product WHERE id = '" + id + "'");
    }

    public ArrayList<ProductBean> search(String name, String info, String category, String priceMin, String priceMax) throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM Product WHERE "
                + "name LIKE '" + name + "' AND "
                + "info LIKE '" + info + "' AND "
                + "category LIKE '" + category + "' AND "
                + "price between " + priceMin + " AND " + priceMax
        );
        return resultToList(rs);
    }

    public ArrayList<ProductBean> resultToList(ResultSet rs) throws SQLException {
        ArrayList<ProductBean> products = new ArrayList<ProductBean>();
        while (rs.next()) {
            ProductBean product = new ProductBean();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setInfo(rs.getString("info"));
            product.setCategory(rs.getString("category"));
            product.setPrice(rs.getInt("price"));
            products.add(product);
        }
        return products;
    }

}
