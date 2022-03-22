package az.company.spring.bookshop.service;

import az.company.spring.bookshop.dto.request.ReqAuthor;

import az.company.spring.bookshop.dto.response.*;

public interface AuthorService {
    RespAuthorList getAuthorList();
    RespAuthor getAuthorById(Long id);

    RespStatus addAuthor(ReqAuthor reqAuthor);
}
