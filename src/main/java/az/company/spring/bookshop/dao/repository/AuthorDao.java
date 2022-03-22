package az.company.spring.bookshop.dao.repository;

import az.company.spring.bookshop.dao.entity.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorDao extends CrudRepository<Author, Long> {
    List<Author> findAll();

    Author findAllBy(Long id);
}
