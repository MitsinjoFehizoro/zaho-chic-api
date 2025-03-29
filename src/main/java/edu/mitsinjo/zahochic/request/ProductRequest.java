package edu.mitsinjo.zahochic.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    @NotNull
    @Size(min = 3, message = "Le titre doit avoir au moins 3 caractères.")
    private String title;

    @NotNull
    @Size(min = 10, message = "Description trés courte.")
    private String description;

    @NotNull
    @Positive(message = "Le prix doit etre positive.")
    @Digits(integer = 8, fraction = 2, message = "Prix invalide.") //Besoin d'amelioration
    private BigDecimal price;

    @NotNull
    @PositiveOrZero(message = "la quantité doit etre positive.")
    @Digits(integer = 8, fraction = 2, message = "Quantité invalide.")
    private int quantityStock;

    @NotNull
    @Size(min = 1, message = "Taille invalide.")
    private String size;
    private String category;
}
