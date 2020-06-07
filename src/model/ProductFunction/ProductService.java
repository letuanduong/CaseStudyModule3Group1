package model.ProductFunction;

import model.ProductStone.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {

    public List<Product> AllProduct();
    public void insertProduct() throws  SQLException;
    public Product selectProduct(int id);
    public boolean deleteProduct(int id) throws SQLException;
    public boolean updateProduct(Product product) throws  SQLException;

}
