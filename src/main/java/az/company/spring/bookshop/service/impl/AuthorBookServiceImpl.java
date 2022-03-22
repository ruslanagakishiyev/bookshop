package az.company.spring.bookshop.service.impl;

import az.company.spring.bookshop.dao.entity.AuthorBook;
import az.company.spring.bookshop.dao.repository.AuthorBookDao;
import az.company.spring.bookshop.dto.response.*;
import az.company.spring.bookshop.service.AuthorBookService;
import az.company.spring.bookshop.util.ExceptionConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorBookServiceImpl implements AuthorBookService {

    @Autowired
    private AuthorBookDao authorBookDao;

    @Override
    public RespAuthorBookList getAuthorBookList() {

        RespAuthorBookList response = new RespAuthorBookList();
        List<RespAuthorBook> respAuthorBookList = new ArrayList<>();

        try {
            List<AuthorBook> bookList = authorBookDao.findAll();
            if (bookList.isEmpty()) {
                response.setStatus(new RespStatus("INFORMATION not found !", ExceptionConstants.INFORMATION_NOT_FOUND));
            }


            for (AuthorBook authorBook : bookList) {
                RespAuthorBook respAuthorBook = new RespAuthorBook();

                RespBook book = new RespBook();
                book.setId(authorBook.getBook().getId());
                book.setName(authorBook.getBook().getName());
                book.setPage(authorBook.getBook().getPage());
                book.setWriteTime(authorBook.getBook().getWriteTime());

                RespAuthor author = new RespAuthor();
                author.setId(authorBook.getAuthor().getId());
                author.setName(authorBook.getAuthor().getName());
                author.setSurname(authorBook.getAuthor().getSurname());
                author.setBornTime(authorBook.getAuthor().getBornTime());
                author.setBornArea(authorBook.getAuthor().getBornArea());

                respAuthorBook.setBook(book);
                respAuthorBook.setAuthor(author);
                respAuthorBookList.add(respAuthorBook);
            }
            response.setAuthorBookList(respAuthorBookList);
            response.setStatus(RespStatus.getSuccessMessage());

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(new RespStatus("internal exception", ExceptionConstants.INTERNAL_EXCEPTION));
        }
        return response;
    }
}
