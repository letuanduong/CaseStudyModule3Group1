package model.ProductStone;

import service.DBConnection;

import java.sql.Connection;
import java.util.List;

public class ProductDAO implements IProductDAO {

    DBConnection dbConnection;
    public ProductDAO() throws ClassNotFoundException {
        String user = "mystery1309";
                String pass = "13091997";
        this.dbConnection=DBConnection.getInstance(user,pass);
    }
    @Override
    public List<Product> selectAllProduct() {

        return null;
    }

    @Override
    public boolean deleteProduct(int id) {
        return false;
    }

    @Override
    public boolean updateProduct(int id) {
        return false;
    }

    @Override
    public Product getProductById(int id) {
        return null;
    }

    @Override
    public void insertProduct(Product product) {
        String insertProduct ="insert into products( product_name, product_brand, product_price, product_amount, product_description) VALUES (?,?,?,?,?);";

    }
}
