package lehieunghia.springboot.buoi2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("category")
public class CategoryController {
    @GetMapping("listCategory")
    public String listCategory() {
        return "category/list_Category";
    }
}
