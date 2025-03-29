package edu.mitsinjo.zahochic.service.category;

import edu.mitsinjo.zahochic.model.Category;

public interface ICategoryService {
    Category getCategoryByName(String name);
    Category addCategory(Category category);
}
