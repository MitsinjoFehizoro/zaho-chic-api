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
        return ResponseEntity.ok(new ApiResponse("Produit ajouté avec succès.", product));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(new ApiResponse("Récupération de tous les produits.", products));
    }
}
