package edu.mitsinjo.zahochic.service.product;

import edu.mitsinjo.zahochic.model.Product;
import edu.mitsinjo.zahochic.request.ProductRequest;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();

    Product getProductById(String id);

    List<Product> getProductsByCategoryName(String category);

    Product addProduct(ProductRequest productRequest);
}
