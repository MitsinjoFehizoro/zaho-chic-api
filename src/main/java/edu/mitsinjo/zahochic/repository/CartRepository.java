package edu.mitsinjo.zahochic.repository;

import edu.mitsinjo.zahochic.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepository extends JpaRepository<Cart, Long> {
}
