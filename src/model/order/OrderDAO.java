package model.order;

import model.ProductStone.Product;
import model.ProductStone.ProductBill;
import service.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements IOrderDAO {
    DBConnection dbConnection;
    @Override
    public int sumOrder(int id) {
        String sum ="";
        return 0;
    }

    @Override
    public void editQuantityProductById_Product(int id_product) {

    }

    @Override
    public void deleteProductOrderById_Product(int id_product) {

    }

    @Override
    public int sumQuantityProduct(int id) {
        return 0;
    }

    public List<ProductBill> getHistory(String username) {
        List<ProductBill> productBills = new ArrayList<>();
        String history ="CALL selectOrderDetail(?);";
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(history);
            preparedStatement.setString(1,username);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id =rs.getInt(1);
                String _username =rs.getString(2);
                String _productName = rs.getString(3);
                int _quantity = rs.getInt(4);
                int _total=rs.getInt(5);
                productBills.add(new ProductBill(id,_username,_productName,_quantity,_total));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productBills;
    }

    public void insertOrderDetail(int id_product, int quantity) throws SQLException {
        String sql = "insert into orders (userName) values (?)";
        PreparedStatement statement = dbConnection.getConnection().prepareStatement(sql);
//        statement.setString();

        //lấy ra orderId vừa thêm vào

        String getNewestOrder = "call getNewestOrder";
        Statement getOrder = dbConnection.getConnection().createStatement();
        ResultSet resultSet = getOrder.executeQuery(getNewestOrder);
        int orderId = 0;
        while (resultSet.next()){
            orderId = resultSet.getInt(1);
        }


        String inserOrderDetail = "call insert_order_detail(?,?,?)";
        CallableStatement callableStatement = dbConnection.getConnection().prepareCall(inserOrderDetail);
        callableStatement.setInt(1, orderId);
        callableStatement.setInt(2, id_product);
        callableStatement.setInt(3, quantity);

    }
}
