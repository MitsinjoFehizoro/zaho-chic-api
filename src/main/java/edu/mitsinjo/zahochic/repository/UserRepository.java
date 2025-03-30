package edu.mitsinjo.zahochic.repository;

import edu.mitsinjo.zahochic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
