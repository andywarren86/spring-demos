package dev.slapps.jpa;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaDemoApp {

  public static void main(final String[] args) {
    SpringApplication.run(JpaDemoApp.class, args);
  }

  @Bean
  public ApplicationRunner insertSampleProducts(final ProductService productService) {
    return (final ApplicationArguments args) -> {
      productService.insertProduct("Laptop", "High-performance laptop", 999.99);
      productService.insertProduct("Mouse", "Wireless mouse", 29.99);
      productService.insertProduct("Keyboard", "Mechanical keyboard", 149.99);
    };
  }

}