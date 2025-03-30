package edu.mitsinjo.zahochic.repository;

import edu.mitsinjo.zahochic.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
