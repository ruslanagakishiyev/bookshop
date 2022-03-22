package az.company.spring.bookshop.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class RespBook {
    private Long id;
    private String name;
    private int page;
    private Date writeTime;
}
