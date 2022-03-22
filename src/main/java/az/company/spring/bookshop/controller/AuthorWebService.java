package az.company.spring.bookshop.controller;

import az.company.spring.bookshop.dto.request.ReqAuthor;
import az.company.spring.bookshop.dto.request.ReqBook;
import az.company.spring.bookshop.dto.response.RespAuthorList;
import az.company.spring.bookshop.dto.response.RespBookList;
import az.company.spring.bookshop.dto.response.RespStatus;
import az.company.spring.bookshop.service.AuthorService;
import az.company.spring.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorWebService {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value="/getAuthorList",method = {RequestMethod.GET,RequestMethod.POST})
    public RespAuthorList getAuthorList(){
        return authorService.getAuthorList();
    }

    @RequestMapping(value="/addAuthor", method={RequestMethod.GET,RequestMethod.POST})
    public RespStatus addAuthor(@RequestBody ReqAuthor reqAuthor){
        return authorService.addAuthor(reqAuthor);
    }
}
