package az.company.spring.bookshop.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class RespAuthorList {

    private List<RespAuthor> authorList;
    private RespStatus status;
}
