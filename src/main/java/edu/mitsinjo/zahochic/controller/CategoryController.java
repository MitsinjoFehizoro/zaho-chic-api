package edu.mitsinjo.zahochic.controller;

import edu.mitsinjo.zahochic.model.Category;
import edu.mitsinjo.zahochic.response.ApiResponse;
import edu.mitsinjo.zahochic.service.category.ICategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/categories")
public class CategoryController {
    private final ICategoryService categoryService;

    @GetMapping("/get/all")
    public ResponseEntity<ApiResponse> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(new ApiResponse("All categories retrieved successfully.", categories));
    }

    @GetMapping("/get")
    public ResponseEntity<ApiResponse> getCategoryByName(@RequestParam String name) {
        Category category = categoryService.getCategoryByName(name);
        return Optional.ofNullable(category)
                .map(c -> ResponseEntity.ok(new ApiResponse("Successfully retrieved category : " + c.getName(), c)))
                .orElse(ResponseEntity.ok(new ApiResponse("No category found for this : " + name, null)));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addCategory(@Valid @RequestBody Category category) {
        Category newCategory = categoryService.addCategory(category);
        return ResponseEntity.ok(new ApiResponse("Category added successfully." + newCategory.getName(), newCategory));
    }
}