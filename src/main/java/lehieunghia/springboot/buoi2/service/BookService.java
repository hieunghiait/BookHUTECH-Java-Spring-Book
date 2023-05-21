package lehieunghia.springboot.buoi2.service;
import lehieunghia.springboot.buoi2.model.Book;
import org.springframework.data.domain.Page;

import java.util.List;


public interface BookService {
    List<Book> getAllBook();

    Book saveBook(Book book);

    Book getBookById(Long id);

    void deleteBookById(Long id);

    Page<Book> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);


}
