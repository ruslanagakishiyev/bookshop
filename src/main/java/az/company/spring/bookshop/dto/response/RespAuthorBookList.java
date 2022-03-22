package az.company.spring.bookshop.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class RespAuthorBookList {
    private List<RespAuthorBook> authorBookList;
    private RespStatus status;
}
