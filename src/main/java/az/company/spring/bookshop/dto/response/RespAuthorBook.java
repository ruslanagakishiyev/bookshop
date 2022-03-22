package az.company.spring.bookshop.dto.response;

import lombok.Data;

@Data
public class RespAuthorBook {
    private Long id;
    private RespBook book;
    private RespAuthor author;
}
