package az.company.spring.bookshop.service;

import az.company.spring.bookshop.dto.response.RespAuthorBook;
import az.company.spring.bookshop.dto.response.RespAuthorBookList;

public interface AuthorBookService {
    RespAuthorBookList getAuthorBookList();
}
