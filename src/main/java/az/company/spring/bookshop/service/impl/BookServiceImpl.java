package az.company.spring.bookshop.service.impl;

import az.company.spring.bookshop.dao.entity.Book;
import az.company.spring.bookshop.dao.repository.BookDao;
import az.company.spring.bookshop.dto.request.ReqBook;
import az.company.spring.bookshop.dto.response.RespBookList;
import az.company.spring.bookshop.dto.response.RespBook;
import az.company.spring.bookshop.dto.response.RespStatus;
import az.company.spring.bookshop.service.BookService;
import az.company.spring.bookshop.util.ExceptionConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public RespBookList getBookList() {
        RespBookList response = new RespBookList();
        List<RespBook> respBooklist = new ArrayList<>();
        try {
            List<Book> bookList = bookDao.findAll();
            if (bookList.isEmpty()) {
                response.setStatus(new RespStatus("Book not founded !", ExceptionConstants.BOOK_NOT_FOUND));
            }

            for (Book book : bookList) {
                RespBook respBook = new RespBook();
                respBook.setId(book.getId());
                respBook.setName(book.getName());
                respBook.setPage(book.getPage());
                respBook.setWriteTime(book.getWriteTime());

                respBooklist.add(respBook);
            }
            response.setBookList(respBooklist);
            response.setStatus(RespStatus.getSuccessMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(new RespStatus("Internal Exception", ExceptionConstants.INTERNAL_EXCEPTION));
        }
        return response;
    }

    @Override
    public RespBook getBookById(Long id) {
        return null;
    }


    @Override
    public RespStatus addBook(ReqBook reqBook) {
        RespStatus response = null;
        String name = reqBook.getName();
        int page = reqBook.getPage();
        Date writeTime = reqBook.getWriteTime();

        try {

            Book book = new Book();

            book.setName(name);
            book.setPage(page);
            book.setWriteTime(writeTime);

            bookDao.save(book);
            response = RespStatus.getSuccessMessage();
        } catch (Exception e) {
            response = new RespStatus("internal exception", ExceptionConstants.INTERNAL_EXCEPTION);
        }
        return response;
    }
}
