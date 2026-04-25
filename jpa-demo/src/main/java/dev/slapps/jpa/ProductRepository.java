package dev.slapps.jpa;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    /** Find all products with a name containing the given search term. */
    List<Product> findByNameContainingIgnoreCase(String name);
}
