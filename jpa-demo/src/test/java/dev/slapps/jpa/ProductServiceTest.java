package dev.slapps.jpa;

import static org.junit.jupiter.api.Assertions.*;

import jakarta.persistence.EntityManager;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class ProductServiceTest {

    @Autowired ProductService productService;
    @Autowired EntityManager em;

    @BeforeEach
    void setUp() {
        System.out.println("ProductServiceTest.setUp()");
        final int updateCunt = em.createQuery("delete from Product p").executeUpdate();
        System.out.println("Deleted " + updateCunt + " products from database");
    }

    @Test
    void testGetAllProductsWithResults() {
        em.persist(new Product("Product 1", "Description 1", 10.0));
        em.persist(new Product("Product 2", "Description 2", 20.0));

        final List<Product> result = productService.getAllProducts(Sort.by("name"));

        assertEquals(2, result.size());
        assertEquals("Product 1", result.get(0).getName());
        assertEquals("Product 2", result.get(1).getName());
    }

    @Test
    void testInsertProductViaRepoSuccess() {
        final String name = "Test Product";
        final String description = "Test Description";
        final Double price = 15.99;
        final Long productId = productService.insertProduct(name, description, price).getId();

        // Verify it was persisted to the database
        final Product product = em.find(Product.class, productId);
        assertNotNull(product);
        assertEquals("Test Product", product.getName());
        assertEquals("Test Description", product.getDescription());
        assertEquals(15.99, product.getPrice());
    }

    @Test
    void testSearchProductsByName() {
        System.out.println("ProductServiceTest.testSearchProductsByName()");
        em.persist(new Product("Laptop", "High-performance laptop", 999.99));
        em.persist(new Product("Desktop", "Gaming desktop", 1499.99));
        em.persist(new Product("Mouse", "Wireless mouse", 29.99));

        final List<Product> result = productService.searchProducts("lap");

        assertEquals(1, result.size());
        assertEquals("Laptop", result.get(0).getName());
    }
}
