package lehieunghia.springboot.buoi2.service;

import lehieunghia.springboot.buoi2.model.Book;
import lehieunghia.springboot.buoi2.model.Category;
import lehieunghia.springboot.buoi2.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(Long id);


    Category saveCategory(Category category);

    void deleteCategoryById(Long id);

}
