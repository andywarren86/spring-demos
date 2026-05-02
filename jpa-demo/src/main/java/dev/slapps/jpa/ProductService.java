package dev.slapps.jpa;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product insertProduct(final String name, final String description, final Double price) {
        System.out.println("ProductService.insertProductViaRepo()");

        final Product product = new Product(name, description, price);
        System.out.println("Saving product: " + product);

        final Product newProduct = productRepository.save(product);
        System.out.println("Saved product: " + newProduct);

        return newProduct;
    }

    public List<Product> getAllProducts(final Sort sort) {
        System.out.println("ProductService.getAllProducts()");
        final List<Product> products = productRepository.findAll(sort);
        System.out.println("Found " + products.size() + " products");
        return products;
    }

    public List<Product> searchProducts(final String searchTerm) {
        System.out.println("ProductService.searchProducts()");
        final List<Product> products = productRepository.findByNameContainingIgnoreCase(searchTerm);
        System.out.println(
                "Found " + products.size() + " products matching search term: " + searchTerm);
        return products;
    }
}
