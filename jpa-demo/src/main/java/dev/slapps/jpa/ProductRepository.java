package dev.slapps.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

  /**
   * Find all products with a name containing the given search term.
   *
   * @param name the search term to match against product names
   * @return a list of products matching the search term
   */
  List<Product> findByNameContainingIgnoreCase(String name);

  /**
   * Find all products with a price less than or equal to the specified maximum price.
   *
   * @param maxPrice the maximum price to search for
   * @return a list of products with price <= maxPrice
   */
  List<Product> findByPriceLessThanOrEqual(Double maxPrice);
}
