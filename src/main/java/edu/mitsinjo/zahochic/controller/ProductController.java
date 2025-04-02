package edu.mitsinjo.zahochic.controller;

import edu.mitsinjo.zahochic.model.Product;
import edu.mitsinjo.zahochic.request.ProductRequest;
import edu.mitsinjo.zahochic.response.ApiResponse;
import edu.mitsinjo.zahochic.service.product.IProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/products")
public class ProductController {
    private final IProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@Valid @RequestBody ProductRequest productRequest) {
        Product product = productService.addProduct(productRequest);
        return ResponseEntity.ok(new ApiResponse("Product added successfully.", product));
    }

    @PostMapping("/add/all")
    public ResponseEntity<ApiResponse> addAllProducts(@Valid @RequestBody List<ProductRequest> productRequests) {
        List<Product> products = productService.addAllProducts(productRequests);
        return ResponseEntity.ok(new ApiResponse("All products added successfully.", products));
    }

    @GetMapping("/get/all")
    public ResponseEntity<ApiResponse> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(new ApiResponse("All products retrieved successfully.", products));
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable String id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(new ApiResponse("Successfully retrieved product.", product));
    }

    @GetMapping("/get")
    public ResponseEntity<ApiResponse> getProductByCategory(@RequestParam String category) {
        List<Product> products = productService.getProductsByCategoryName(category);
        return ResponseEntity.ok(new ApiResponse("Successfully retrieved product by category : " + category, products));
    }
}
