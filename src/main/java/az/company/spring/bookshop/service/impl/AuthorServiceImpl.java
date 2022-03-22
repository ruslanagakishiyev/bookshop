package az.company.spring.bookshop.service.impl;

import az.company.spring.bookshop.dao.entity.Author;
import az.company.spring.bookshop.dao.entity.Book;
import az.company.spring.bookshop.dao.repository.AuthorDao;
import az.company.spring.bookshop.dto.request.ReqAuthor;
import az.company.spring.bookshop.dto.response.RespAuthor;
import az.company.spring.bookshop.dto.response.RespAuthorList;
import az.company.spring.bookshop.dto.response.RespStatus;
import az.company.spring.bookshop.service.AuthorService;
import az.company.spring.bookshop.service.BookService;
import az.company.spring.bookshop.util.ExceptionConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;



    @Override
    public RespAuthorList getAuthorList() {
        RespAuthorList response = new RespAuthorList();
        List<RespAuthor> respAuthorList = new ArrayList<>();

        try{
            List<Author> authorList = authorDao.findAll();
            if(authorList.isEmpty()){
                response.setStatus(new RespStatus("Author not found !" , ExceptionConstants.AUTHOR_NOT_FOUND));
            }

            for(Author author : authorList){
                RespAuthor respAuthor =  new RespAuthor();
                respAuthor.setId(author.getId());
                respAuthor.setName(author.getName());
                respAuthor.setSurname(author.getSurname());
                respAuthor.setBornTime(author.getBornTime());
                respAuthor.setBornArea(author.getBornArea());

                respAuthorList.add(respAuthor);
            }
            response.setAuthorList(respAuthorList);
            response.setStatus(RespStatus.getSuccessMessage());

        }catch(Exception e){
            e.printStackTrace();
            response.setStatus(new RespStatus("internal exception",ExceptionConstants.INTERNAL_EXCEPTION));
        }
        return response;
    }

    @Override
    public RespAuthor getAuthorById(Long id) {
        return null;
    }

    @Override
    public RespStatus addAuthor(ReqAuthor reqAuthor) {
        RespStatus response = null;
        String name = reqAuthor.getName();
        String surname = reqAuthor.getSurname();
        Date bornTime = reqAuthor.getBornTime();
        String bornArea = reqAuthor.getBornArea();

        try {

            Author author = new Author();

            author.setName(name);
            author.setSurname(surname);
            author.setBornTime(bornTime);
            author.setBornArea(bornArea);

            authorDao.save(author);
            response = RespStatus.getSuccessMessage();
        } catch (Exception e) {
            response = new RespStatus("internal exception", ExceptionConstants.INTERNAL_EXCEPTION);
        }
        return response;
    }
}
