package webshop;

public class Product {

    private Long id;
    private String ProductName;
    private int price;
    private int stock;

    public Product(Long id, String productName, int price, int stock) {
        this.id = id;
        ProductName = productName;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return ProductName;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
