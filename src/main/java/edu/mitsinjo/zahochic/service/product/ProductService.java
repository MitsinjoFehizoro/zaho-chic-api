package edu.mitsinjo.zahochic.service.product;

import edu.mitsinjo.zahochic.exception.ResourceNotFoundException;
import edu.mitsinjo.zahochic.model.Category;
import edu.mitsinjo.zahochic.model.Product;
import edu.mitsinjo.zahochic.repository.CategoryRepository;
import edu.mitsinjo.zahochic.repository.ProductRepository;
import edu.mitsinjo.zahochic.request.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(String id) {

        Long validId = Long.parseLong(id);
        return productRepository.findById(validId).orElseThrow(() -> new ResourceNotFoundException("Product with id '" + id + "' not found"));

    }


    @Override
    public List<Product> getProductsByCategoryName(String category) {
        return productRepository.findByCategoryName(category);
    }

    @Override
    public Product addProduct(ProductRequest productRequest) {
        Category category = Optional.ofNullable(categoryRepository.findByName(productRequest.getCategory()))
                .orElseGet(() -> {
                    Category newCategory = new Category(productRequest.getCategory());
                    return categoryRepository.save(newCategory);
                });
        return productRepository.save(createProduct(productRequest, category));
    }

    private Product createProduct(ProductRequest productRequest, Category category) {
        return new Product(
                productRequest.getTitle(),
                productRequest.getDescription(),
                productRequest.getPrice(),
                productRequest.getQuantityStock(),
                productRequest.getSize(),
                category
        );
    }

}
