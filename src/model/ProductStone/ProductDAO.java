package model.ProductStone;

import service.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String selectAll ="select * from products;";
        List<Product> ListUser = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(selectAll);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("product_id");
                String name = rs.getString("product_name");
                String brand = rs.getString("product_brand");
                int price = rs.getInt("product_price");
                int amount = rs.getInt("product_amount");
                String description = rs.getString("product_description");
                ListUser.add(new Product(id,name,brand,price,amount,description));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ListUser;
    }

    @Override
    public boolean deleteProduct(int id) {
        String deleteProduct= "DELETE FROM products WHERE product_id=?;";
        boolean rowDeleted = false;
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(deleteProduct);
            preparedStatement.setInt(1,id);
            rowDeleted=preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean updateProduct(Product product) {
        String updateDtb="UPDATE products SET product_name=?,product_brand=?,product_price=?,product_amount=?,product_description=? WHERE product_id=?;";
        boolean rowUpdated = false;
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(updateDtb);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2,product.getBrand());
            preparedStatement.setInt(3,product.getPrice());
            preparedStatement.setInt(4,product.getAmount());
            preparedStatement.setString(5,product.getDescription());
            preparedStatement.setInt(6,product.getId());
            rowUpdated =preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public Product getProductById(int id) {
        Product product =null;
        String selectProduct ="SELECT product_id,product_name,product_brand,product_price,product_amount,product_description FROM products WHERE product_id=?;";
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(selectProduct);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                String name = rs.getString("product_name");
                String brand = rs.getString("product_brand");
                int price = rs.getInt("product_price");
                int amount = rs.getInt("product_amount");
                String description = rs.getString("product_description");
                product = new Product(id,name,brand,price,amount,description);

            }
        } catch (SQLException e) {
            throw new RuntimeException("Product not exist !");
        }


        return product;
    }

    @Override
    public void insertProduct(Product product) {

        String insertProduct ="INSERT INTO products(product_name, product_brand, product_price, product_amount, product_description) VALUES (?,?,?,?,?);";
        try {
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(insertProduct);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2,product.getBrand());
            preparedStatement.setInt(3,product.getPrice());
            preparedStatement.setInt(4,product.getAmount());
            preparedStatement.setString(5,product.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
