package edu.mitsinjo.zahochic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotNull
    @Size(min = 3, message = "Le titre doit avoir au moins 3 caractères.")
    private String title;

    @NotNull
    @Size(min = 10, message = "Description trés courte.")
    private String description;

    @NotNull
    @Positive(message = "Le prix doit etre positive.")
    @Digits(integer = 8, fraction = 2, message = "Prix invalide." )
    private BigDecimal price;

    @NotNull
    @PositiveOrZero(message = "la quantité doit etre positive.")
    @Digits(integer = 8, fraction = 2, message = "Quantité invalide." )
    private int quantityStock;

    @NotNull
    @Size(min = 1, message = "Taille invalide.")
    private String size;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(String title, String description, BigDecimal price, int quantityStock, String size, Category category) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.quantityStock = quantityStock;
        this.size = size;
        this.category = category;
    }
}
