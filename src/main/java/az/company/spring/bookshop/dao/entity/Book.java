package az.company.spring.bookshop.dao.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "books")
@DynamicInsert
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "book_page")
    private int page;

    @Column(name = "write_time")
    private Date writeTime;
}
