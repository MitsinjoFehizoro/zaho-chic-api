package edu.mitsinjo.zahochic.controller;

import edu.mitsinjo.zahochic.model.Category;
import edu.mitsinjo.zahochic.response.ApiResponse;
import edu.mitsinjo.zahochic.service.category.ICategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/categories")
public class CategoryController {
    private final ICategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(new ApiResponse("Récupération avec succès de toutes les catégories.", categories));
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse> getCategoryByName(@RequestParam String name) {
        Category category = categoryService.getCategoryByName(name);
        if (category != null) {
            return ResponseEntity.ok(new ApiResponse("Récupération avec succès de la catégorie : " + category.getName(), category));
        }
        return ResponseEntity.ok(new ApiResponse("Aucune catégorie : " + name, null));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addCategory(@Valid @RequestBody Category category) {
        Category newCategory = categoryService.addCategory(category);
        return ResponseEntity.ok(new ApiResponse("Ajout avec succès de la catégorie " + newCategory.getName(), newCategory));
    }
}