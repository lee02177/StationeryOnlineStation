package bean;

import java.util.ArrayList;

/**
 * Created by Lee on 7/12/2015.
 */
public class ShoppingCartBean {
    ArrayList<ProductBean> productlist = new ArrayList<ProductBean>();
    ArrayList<String> quantitylist = new ArrayList<String>();

    public ShoppingCartBean() {
    }

    public int size() {
        return productlist.size();
    }

    public ArrayList<ProductBean> getProductlist() {
        return productlist;
    }

    public ArrayList<String> getQuantityList() {
        return quantitylist;
    }

    public void add(ProductBean product, String quantity) {
        for (int i = 0; i < productlist.size(); i++) {
            if (productlist.get(i).getId() == (product.getId())) {
                quantitylist.set(i, (Integer.parseInt(quantitylist.get(i)) + Integer.parseInt(quantity)) + "");
                return;
            }
        }
        productlist.add(product);
        quantitylist.add(quantity);
    }

    public void claer() {
        productlist.clear();
        quantitylist.clear();
    }

    public void removeById(String id) {
        for (int i = 0; i < productlist.size(); i++) {
            if (id.equals(productlist.get(i).getId() + "")) {
                productlist.remove(i);
                quantitylist.remove(i);
            }
        }
    }
}
