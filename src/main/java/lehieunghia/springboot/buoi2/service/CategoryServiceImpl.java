package lehieunghia.springboot.buoi2.service;

import lehieunghia.springboot.buoi2.model.Category;
import lehieunghia.springboot.buoi2.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    public CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        Category category = null;
        if (optionalCategory.isPresent()) {
            category = optionalCategory.get();
            return category;
        } else {
            throw new RuntimeException("Category is not found");
        }
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }


    @Override
    public void deleteCategoryById(Long id) {
        this.categoryRepository.deleteById(id);
    }


}
