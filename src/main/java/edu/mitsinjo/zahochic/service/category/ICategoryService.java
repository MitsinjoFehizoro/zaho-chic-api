package edu.mitsinjo.zahochic.service.category;

import edu.mitsinjo.zahochic.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category>  getAllCategories();
    Category getCategoryByName(String name);
    Category addCategory(Category category);
}
