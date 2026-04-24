package dev.slapps.jpa;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(final ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  /**
   * Insert a new product into the database.
   */
  public Product insertProduct(final String name, final String description, final Double price) {
    final Product product = new Product(name, description, price);
    final Product savedProduct = productRepository.save(product);
    System.out.println("Product inserted: " + savedProduct);
    return savedProduct;
  }
}
