package model.ProductStone;

import java.util.List;

public class ProductDAO implements IProductDAO {
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

    }
}
