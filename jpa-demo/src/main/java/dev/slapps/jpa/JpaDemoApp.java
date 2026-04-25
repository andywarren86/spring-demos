package dev.slapps.jpa;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class JpaDemoApp {

  public static void main(final String[] args) {
    SpringApplication.run(JpaDemoApp.class, args);
  }

  @Bean
  @Order(1)
  public ApplicationRunner insertSampleProducts(final ProductService productService) {
    System.out.println("JpaDemoApp.insertSampleProducts()");
    return (final ApplicationArguments args) -> {
      productService.insertProductViaRepo("Laptop", "High-performance laptop", 999.99);
      productService.insertProductViaSession("Mouse", "Wireless mouse", 29.99);
      // productService.insertProductViaRepo("Keyboard", "Mechanical keyboard", 149.99);

      System.out.println("================================");
      System.out.println("All products in the database:");
      productService.getAllProducts().forEach(product -> {
        System.out.println("Product: " + product);
      });
    };
  }

}