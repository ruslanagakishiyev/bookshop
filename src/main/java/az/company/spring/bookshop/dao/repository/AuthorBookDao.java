package az.company.spring.bookshop.dao.repository;

import az.company.spring.bookshop.dao.entity.AuthorBook;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorBookDao extends CrudRepository<AuthorBook, Long> {
    List<AuthorBook> findAll();
}
