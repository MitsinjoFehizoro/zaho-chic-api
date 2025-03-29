package edu.mitsinjo.zahochic.request;

import edu.mitsinjo.zahochic.model.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    private String title;
    private String description;
    private BigDecimal price;
    private int quantityStock;
    private String size;
    private String category;
}
