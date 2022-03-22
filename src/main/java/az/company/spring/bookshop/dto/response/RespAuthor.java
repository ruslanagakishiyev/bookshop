package az.company.spring.bookshop.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class RespAuthor {

    private Long id;
    private String name;
    private String surname;
    private Date bornTime;
    private String bornArea;
}
