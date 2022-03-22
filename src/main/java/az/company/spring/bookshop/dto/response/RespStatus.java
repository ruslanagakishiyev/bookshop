package az.company.spring.bookshop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespStatus {
    private String successMessage;
    private Integer successCode;

    private static final Integer SUCCESS_CODE = 1;
    private static final String SUCCESS_MESSAGE = "Success";

    public static RespStatus getSuccessMessage() {
        return new RespStatus(SUCCESS_MESSAGE, SUCCESS_CODE);
    }
}
