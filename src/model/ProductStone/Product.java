package CodeGym.model.ProductStone;

public class Product {
    private int id;
    private String name;
    private String brand;
    private String price;
    private int amount;
    private String description;

    public Product() {
    }

    public Product(int id, String name, String brand, String price, int amount, String description) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.amount = amount;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public Product setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public Product setPrice(String price) {
        this.price = price;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public Product setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }
}
