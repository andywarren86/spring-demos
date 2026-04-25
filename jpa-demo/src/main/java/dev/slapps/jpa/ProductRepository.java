package dev.slapps.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

  /**
   * Find all products with a name containing the given search term.
   */
  List<Product> findByNameContainingIgnoreCase(String name);

}
