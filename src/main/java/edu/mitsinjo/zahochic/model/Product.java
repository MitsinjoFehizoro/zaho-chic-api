package edu.mitsinjo.zahochic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private BigDecimal price;

    private int quantityStock;

    private String size;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "category_id")
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItems;

    public void addImageToProduct(Image image) {
        this.images.add(image);
        image.setProduct(this);
    }

    public void removeImageToProduct(Image image) {
        this.images.remove(image);
        image.setProduct(null);
    }

    public Product(String title, String description, BigDecimal price, int quantityStock, String size, Category category, List<Image> images) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.quantityStock = quantityStock;
        this.size = size;
        this.images = images;
        this.category = category;
    }
}
