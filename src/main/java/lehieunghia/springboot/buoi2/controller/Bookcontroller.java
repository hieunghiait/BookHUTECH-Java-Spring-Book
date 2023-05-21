package lehieunghia.springboot.buoi2.controller;

import lehieunghia.springboot.buoi2.model.Book;
import lehieunghia.springboot.buoi2.repository.BookRepository;
import lehieunghia.springboot.buoi2.repository.CategoryRepository;
import lehieunghia.springboot.buoi2.service.BookService;
import lehieunghia.springboot.buoi2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class Bookcontroller {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/")
    public String homePage(Model model, @Param("keyword") String keyword) {
        return findPaginated(1, "title", "asc", model);
    }


    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "new_book";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "update_book";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable(value = "id") long id) {
        this.bookService.deleteBookById(id);
        return "redirect:/";
    }

    @GetMapping("/book/details/{id}")
    public String showBookDetails(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            model.addAttribute("bookDetails", book);
            model.addAttribute("pageTitle", "Book Details");
        } else {
            throw new RuntimeException("Loi phia server");
        }
        System.out.println(id);
        return "book-detail";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir, Model model) {
        int pageSize = 5;

        Page<Book> page = bookService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Book> listBooks = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listBooks", listBooks);
        return "homepage";
    }

    @GetMapping("/book/search")
    public String searchBooks(@RequestParam("query") String query, Model model) {
        List<Book> results = bookRepository.findByTitleContainingIgnoreCase(query);
        model.addAttribute("results", results);
        return "search-results";
    }


}
