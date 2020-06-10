package model.order;

import model.ProductStone.Product;

import java.util.List;

public class Order {
    private int orderId;
    private String user_name;
    private List<Product> products;
    private int total=0;

    public Order() {
    }

    public List<Product> getProducts() {
        return products;
    }


    public Order(int id, String user_name, List<Product> products) {
        this.orderId = id;
        this.user_name = user_name;
        this.products =products;

        for (Product product :products){
            this.total+=product.getPrice();
        }
    }


    public int getId() {
        return orderId;
    }


    public String getUser_name() {
        return user_name;
    }

}
