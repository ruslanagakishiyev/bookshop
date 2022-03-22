package az.company.spring.bookshop.controller;

import az.company.spring.bookshop.dto.request.ReqBook;
import az.company.spring.bookshop.dto.response.RespBookList;
import az.company.spring.bookshop.dto.response.RespStatus;
import az.company.spring.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookWebService {

    @Autowired
    private BookService bookService;

    @RequestMapping(value="/getBookList",method = {RequestMethod.GET,RequestMethod.POST})
    public RespBookList getBookList(){
        return bookService.getBookList();
    }

    @RequestMapping(value="/addBook", method={RequestMethod.GET,RequestMethod.POST})
    public RespStatus addBook(@RequestBody ReqBook reqBook){
        return bookService.addBook(reqBook);
    }

}
