package az.company.spring.bookshop.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class ReqAuthor {

    private Long id;
    private String name;
    private String surname;
    private Date bornTime;
    private String bornArea;
}
