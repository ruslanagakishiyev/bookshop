package az.company.spring.bookshop.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class ReqBook {

    private Long id;
    private String name;
    private int page;
    private Date writeTime;

}
