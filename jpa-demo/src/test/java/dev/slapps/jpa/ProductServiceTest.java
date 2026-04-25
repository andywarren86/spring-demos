package dev.slapps.jpa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;

@SpringBootTest
@DisplayName("ProductService Integration Tests")
@Transactional
@Rollback
class ProductServiceTest {

  @Autowired
  private ProductService productService;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private EntityManager entityManager;

  @BeforeEach
  void setUp() {
    System.out.println("ProductServiceTest.setUp()");
    final int updateCunt =
      entityManager.createQuery("delete from Product p").executeUpdate();
    System.out.println("Deleted " + updateCunt + " products from database");

    entityManager.clear(); // Clear persistence context to ensure test isolation
  }

  // Tests for getAllProducts()

  @Test
  @DisplayName("getAllProducts should return all products from repository")
  void testGetAllProductsWithResults() {
    System.out.println("ProductServiceTest.testGetAllProductsWithResults()");
    // Arrange
    productRepository.save(new Product("Product 1", "Description 1", 10.0));
    productRepository.save(new Product("Product 2", "Description 2", 20.0));

    // Flush to ensure data is written to database (not just in session cache)
    // entityManager.flush();

    // Act
    final List<Product> result = productService.getAllProducts();

    // Assert
    assertEquals(2, result.size());
    assertEquals("Product 1", result.get(0).getName());
    assertEquals("Product 2", result.get(1).getName());
  }

  // Tests for insertProductViaRepo()

  @Test
  @DisplayName("insertProductViaRepo should save product and return it with updated name")
  void testInsertProductViaRepoSuccess() {
    // Arrange
    final String name = "Test Product";
    final String description = "Test Description";
    final Double price = 15.99;

    // Act
    final Product result = productService.insertProductViaRepo(name, description, price);

    // Assert
    assertNotNull(result);
    assertEquals("Test Product", result.getName());
    assertEquals(description, result.getDescription());
    assertEquals(price, result.getPrice());

    // Verify it was persisted to the database
    assertNotNull(result.getId());
    final Product fetchedProduct = productRepository.findById(result.getId()).orElse(null);
    assertNotNull(fetchedProduct);
    assertEquals("Test Product", fetchedProduct.getName()); // Original name in DB
  }

  // Tests for insertProductViaSession()

  @Test
  @DisplayName("insertProductViaSession should persist product via EntityManager")
  void testInsertProductViaSessionSuccess() {
    // Arrange
    final String name = "Session Product";
    final String description = "Session Description";
    final Double price = 30.0;

    // Act
    final Product result = productService.insertProductViaSession(name, description, price);

    // Assert
    assertNotNull(result);
    assertEquals(name, result.getName());
    assertEquals(description, result.getDescription());
    assertEquals(price, result.getPrice());

    // Flush and verify the product is in the database
    // entityManager.flush();
    final List<Product> allProducts = productRepository.findAll();
    assertEquals(1, allProducts.size());
    assertEquals(name, allProducts.get(0).getName());
  }
}
