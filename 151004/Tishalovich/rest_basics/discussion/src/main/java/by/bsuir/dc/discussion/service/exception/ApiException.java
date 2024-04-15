package by.bsuir.dc.discussion.service.exception;

import com.google.common.base.Objects;
import lombok.Getter;

@Getter
public class ApiException extends Exception {

    private final int statusCode;

    private final String errorMessage;

    public ApiException(int httpStatusCode, int subStatusCode, String errorMessage) {
        statusCode = httpStatusCode*100 + subStatusCode;
        this.errorMessage = errorMessage;
    }

    public int getHttpStatusCode() {
        return statusCode/100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiException that = (ApiException) o;
        return statusCode == that.statusCode && errorMessage.equals(that.errorMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(statusCode, errorMessage);
    }

}
