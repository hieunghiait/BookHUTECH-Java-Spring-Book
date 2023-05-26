package lehieunghia.springboot.buoi2.controller;

import lehieunghia.springboot.buoi2.model.Book;
import lehieunghia.springboot.buoi2.model.Category;
import lehieunghia.springboot.buoi2.repository.CategoryRepository;
import lehieunghia.springboot.buoi2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/listCategory")
    public String listCategory(Model model) {
        model.addAttribute("listCategory", categoryService.getAllCategories());
        return "category/list_Category";
    }

    @GetMapping("/showFormCategory")
    public String showFormCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "category/showFormCategory";
    }

    @GetMapping("/saveCategory")
    public String saveCategory(@ModelAttribute("category") Category category) {
        categoryService.saveCategory(category);
        return "redirect:/category/listCategory";
    }
}
