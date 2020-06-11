package model.order;

public interface IOrderDAO {
    int sumOrder(int id_order);
    void editQuantityProductById_Product(int id_product);
    void deleteProductOrderById_Product(int id_product);
    int sumQuantityProduct(int id);

}
