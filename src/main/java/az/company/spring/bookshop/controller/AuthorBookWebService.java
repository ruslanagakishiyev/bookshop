package az.company.spring.bookshop.controller;

import az.company.spring.bookshop.dto.response.RespAuthorBookList;
import az.company.spring.bookshop.service.AuthorBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authorBook")
public class AuthorBookWebService {

    @Autowired
    private AuthorBookService authorBookService;

    @RequestMapping(value="/getAuthorBookList",method = {RequestMethod.GET,RequestMethod.POST})
    public RespAuthorBookList getAuthorBookList(){
        return authorBookService.getAuthorBookList();
    }
}
