package az.company.spring.bookshop.service;

import az.company.spring.bookshop.dto.request.ReqBook;
import az.company.spring.bookshop.dto.response.RespBookList;
import az.company.spring.bookshop.dto.response.RespBook;
import az.company.spring.bookshop.dto.response.RespStatus;

public interface BookService {

    RespBookList getBookList();
    RespBook getBookById(Long id);

    RespStatus addBook(ReqBook reqBook);


}
