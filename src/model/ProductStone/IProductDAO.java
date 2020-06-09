package model.ProductStone;

import java.util.List;

public interface IProductDAO {
    List<Product> selectAllProduct();
    boolean deleteProduct(int id);
    boolean updateProduct(int id);
    Product getProductById(int id);
    void insertProduct(Product product);
}
