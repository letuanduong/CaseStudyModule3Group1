package model.ProductStone;

public class ProductBill {
    private int order_id;
    private String username;
    private String productName;
    private int quantity;
    private int total;

    public ProductBill(int order_id, String username,String productName, int quantity, int total) {
        this.order_id = order_id;
        this.username = username;
        this.quantity = quantity;
        this.total = total;
        this. productName=productName;
    }

    public ProductBill() {
    }

    public int getOrder_id() {
        return order_id;
    }


    public String getUsername() {
        return username;
    }


    public int getQuantity() {
        return quantity;
    }

    public ProductBill setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public int getTotal() {
        return total;
    }
}
