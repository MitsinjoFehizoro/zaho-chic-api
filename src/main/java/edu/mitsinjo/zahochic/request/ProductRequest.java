package edu.mitsinjo.zahochic.request;

import edu.mitsinjo.zahochic.model.Image;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductRequest {
    @NotNull
    @Size(min = 3, message = "Title must be at least 3 characters long.")
    private String title;

    @NotNull
    @Size(min = 10, message = "Description too short.")
    private String description;

    @NotNull
    @Positive(message = "Price must be greater than 0")
    @Digits(integer = 8, fraction = 2, message = "Invalid price.") //Besoin d'amelioration
    private BigDecimal price;

    @NotNull
    @PositiveOrZero(message = "Quantity must be positive.")
    @Digits(integer = 8, fraction = 2, message = "Invalid quantity.")
    private int quantityStock;

    @NotNull
    @Size(min = 1, message = "Invalid size.")
    private String size;

    private List<Image> images;

    private String category;
}
