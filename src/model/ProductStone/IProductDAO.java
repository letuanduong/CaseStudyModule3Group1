package model.ProductStone;

import java.util.List;

public interface IProductDAO {
    List<Product> selectAllProduct();
    boolean deleteProduct(int id);
    boolean updateProduct(Product product);
    Product getProductById(int id);
    void insertProduct(Product product);
}
