package edu.mitsinjo.zahochic.repository;

import edu.mitsinjo.zahochic.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryName(String category);
}
