package by.bsuir.discussion.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class ApiError {
    private String errorMessage;
    private Integer errorCode;
}
