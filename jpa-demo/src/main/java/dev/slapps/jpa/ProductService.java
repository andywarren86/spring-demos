package dev.slapps.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired private ProductRepository productRepository;

    @PersistenceContext private EntityManager entityManager;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /** Insert a new product into the database. */
    public Product insertProductViaRepo(
            final String name, final String description, final Double price) {
        System.out.println("ProductService.insertProductViaRepo()");

        final Product product = new Product(name, description, price);
        return productRepository.save(product);
    }

    public Product insertProductViaSession(
            final String name, final String description, final Double price) {
        System.out.println("ProductService.insertProductViaSession()");
        System.out.println(entityManager);

        final Product product = new Product(name, description, price);
        entityManager.persist(product);
        System.out.println("Product inserted: " + product);

        return product;
    }
}
