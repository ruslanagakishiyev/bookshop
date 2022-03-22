package az.company.spring.bookshop.dto.request;

import az.company.spring.bookshop.dao.entity.Author;
import az.company.spring.bookshop.dao.entity.Book;
import lombok.Data;

@Data
public class ReqAuthorBook {

    private Long id;
    private Book book;
    private Author author;
}
