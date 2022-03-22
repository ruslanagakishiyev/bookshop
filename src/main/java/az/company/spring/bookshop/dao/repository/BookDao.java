package az.company.spring.bookshop.dao.repository;

import az.company.spring.bookshop.dao.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookDao extends CrudRepository<Book, Long> {

    List<Book> findAll();
    Book findAllBy(Long id);
}
