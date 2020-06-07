package model.ProductFunction;

import model.ProductFunction.ProductService;
import model.ProductFunction.Product_Key_Function;
import model.ProductStone.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImplement implements Product_Key_Function, ProductService {
    @Override
    public List<Product> AllProduct() {
        return null;
    }

    @Override
    public void insertProduct() throws SQLException {

    }
    @Override
    public Product selectProduct(int id) {
        return null;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        return false;
    }
}
