package lehieunghia.springboot.buoi2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lehieunghia.springboot.buoi2.validator.annotaion.ValidCategoryId;
import lehieunghia.springboot.buoi2.validator.annotaion.ValidUserId;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    /*@NotEmpty(message = "Title must not be empty")
    @Size(min = 3, max = 50, message = "Title must be less than 50 characters")*/
    private String title;
    @NotNull
    @Column(name = "author")
    /*@NotEmpty(message = "Author must not be empty")*/
    private String author;
    @NotNull
    @Column(name = "price")
    /*@NotEmpty(message = "Price is required")*/
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Book() {

    }

    public Book(Long id, String title, String author, Double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }


}
