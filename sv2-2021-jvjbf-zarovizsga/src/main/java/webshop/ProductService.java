package webshop;

public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    void saleProduct(long id, int amount) {
        int stock = productRepository.findProductById(id).getStock();
        if (amount > stock) {
            throw new IllegalArgumentException("Not enough product on stock!");
        }
        productRepository.updateProductStock(id, amount);
    }
}
