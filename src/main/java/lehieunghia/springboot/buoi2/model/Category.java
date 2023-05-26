package lehieunghia.springboot.buoi2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Entity
@Table(name = "category")
@Getter
@Setter

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Book> books;
    public Category(){

    }

    public Category(Long id, String name, List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }
}
